package Notifier

import ContactInfo.EmailContactInfo
import ContactInfo.FacebookContactInfo
import ContactInfo.SMSContactInfo
import Services.ContactClientParams
import Services.ContactClientService
import User.User

interface INotifier {
    fun send(message: String)
}

class Notifier(
        val users: ArrayList<User>,
        val emailService: ContactClientService,
        val smsService: ContactClientService,
        val facebookService: ContactClientService) : INotifier {

    override fun send(message: String) {
        users.forEach { user ->
            user.contactInfo.forEach { contactInfo ->
                var preferedContactService: ContactClientService? = null
                when (contactInfo) {
                    is EmailContactInfo ->
                        preferedContactService = emailService
                    is FacebookContactInfo ->
                        preferedContactService = facebookService
                    is SMSContactInfo ->
                        preferedContactService = smsService
                }
                preferedContactService?.let {
                    it.sendMessage(
                            ContactClientParams(message, contactInfo)
                    )
                }
            }
        }
    }
}