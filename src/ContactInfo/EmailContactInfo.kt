package ContactInfo

class EmailContactInfo(val email: String) : IContactInfo {
    override fun getContactDestination(): String {
        return email
    }
}