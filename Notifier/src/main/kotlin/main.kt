import Application.Application
import ContactInfo.EmailContactInfo
import ContactInfo.FacebookContactInfo
import ContactInfo.SMSContactInfo
import Notifier.Notifier
import User.User
import Services.*

fun main(args: Array<String>) {
    val users: ArrayList<User> = arrayListOf(
            User(
                    "Fulano de tal",
                    arrayListOf(
                            EmailContactInfo("email.example@example.com"),
                            SMSContactInfo("3146546565")
                    )
            ),
            User(
                    "Otro fulano",
                    arrayListOf(
                            FacebookContactInfo("El otro fulano")
                    )
            )
    )
    val notifier = Notifier(
            users,
            ContactClientServiceEmail(),
            ContactClientServiceSMS(),
            ContactClientServiceFacebook()
    )
    Application(notifier).doSomething()
}