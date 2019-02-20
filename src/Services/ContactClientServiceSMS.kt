package Services

class ContactClientServiceSMS: ContactClientService {
    override fun sendMessage(params: ContactClientParams) {
        println("Checking for mobile network")
        println("Sending through SMS network to ${params.contact.getContactDestination()} the message: ${params.message}")
        println("SMS ready")
    }
}