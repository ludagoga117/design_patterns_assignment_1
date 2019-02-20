import ContactInfo.EmailContactInfo
import ContactInfo.FacebookContactInfo
import ContactInfo.SMSContactInfo
import Services.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class ServicesTests {

    var contactClientParams: ContactClientParams? = null

    @After
    fun tearDown(){
        contactClientParams = null
    }

    @Test
    fun shouldSendMessageViaSMS() {
        val service: ContactClientService = ContactClientServiceSMS()
        contactClientParams = ContactClientParams(
                "Hola mundo",
                SMSContactInfo("3146545454")
        )

        contactClientParams?.let {
            service.sendMessage( it )
        }
    }

    @Test
    fun shouldSendMessageViaEmail(){
        val service: ContactClientService = ContactClientServiceEmail()
        contactClientParams = ContactClientParams(
                "Hola mundo",
                EmailContactInfo("example.example@example.com")
        )

        contactClientParams?.let {
            service.sendMessage( it )
        }
    }

    @Test
    fun shouldSendMessageViaFacebook(){
        val service: ContactClientService = ContactClientServiceFacebook()
        contactClientParams = ContactClientParams(
                "Hola mundo",
                FacebookContactInfo("Fulano de tal")
        )

        contactClientParams?.let {
            service.sendMessage( it )
        }
    }
}