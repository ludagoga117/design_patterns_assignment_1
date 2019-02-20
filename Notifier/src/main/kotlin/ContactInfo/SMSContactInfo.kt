package ContactInfo

class SMSContactInfo(val phoneNumber: String) : IContactInfo {
    override fun getContactDestination(): String {
        return phoneNumber
    }
}