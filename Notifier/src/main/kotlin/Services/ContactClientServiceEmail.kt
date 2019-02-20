package Services

class ContactClientServiceEmail: ContactClientService {
    override fun sendMessage(params: ContactClientParams) {
        println("Do I have internet connection?")
        println("Sending through Email to ${params.contact.getContactDestination()} the message: ${params.message}")
        println("Email sent!")
    }
}