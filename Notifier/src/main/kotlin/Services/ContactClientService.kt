package Services

import ContactInfo.IContactInfo

data class ContactClientParams(val message: String, val contact: IContactInfo)

interface ContactClientService {
    fun sendMessage(params: ContactClientParams)
}