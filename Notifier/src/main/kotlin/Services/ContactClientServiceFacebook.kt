package Services

class ContactClientServiceFacebook: ContactClientService {
    override fun sendMessage(params: ContactClientParams) {
        println("Connecting to Facebook")
        println("Sending through Facebook to ${params.contact.getContactDestination()} the message: ${params.message}")
        println("Closing Facebook connection")
    }
}