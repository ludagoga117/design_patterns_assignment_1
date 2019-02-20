package ContactInfo

class FacebookContactInfo(val userId: String) : IContactInfo {
    override fun getContactDestination(): String {
        return userId
    }
}