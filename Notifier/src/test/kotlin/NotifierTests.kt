import ContactInfo.SMSContactInfo
import Notifier.INotifier
import Notifier.Notifier
import Services.ContactClientParams
import Services.ContactClientService
import User.User
import org.junit.After
import org.junit.Before
import org.junit.Test

class NotifierTests {

    private class MockedEmailContactClientService : ContactClientService {
        override fun sendMessage(params: ContactClientParams) {
            println("Mocked email Sending ${params.message} to ${params.contact.getContactDestination()}")
        }
    }

    private class MockedFacebookContactClientService : ContactClientService {
        override fun sendMessage(params: ContactClientParams) {
            println("Mocked facebook Sending ${params.message} to ${params.contact.getContactDestination()}")
        }
    }

    private class MockedSMSContactClientService : ContactClientService {
        override fun sendMessage(params: ContactClientParams) {
            println("Mocked sms Sending ${params.message} to ${params.contact.getContactDestination()}")
        }
    }

    var mockedEmailService: ContactClientService? = null
    var mockedFacebookService: ContactClientService? = null
    var mockedSMSService: ContactClientService? = null
    var mockedUser: User? = null

    @Before
    fun setup() {
        mockedEmailService = MockedEmailContactClientService()
        mockedFacebookService = MockedFacebookContactClientService()
        mockedSMSService = MockedSMSContactClientService()
    }

    @After
    fun tearDown() {
        mockedEmailService = null
        mockedFacebookService = null
        mockedSMSService = null
        mockedUser = null
    }

    @Test
    fun shouldSendMessageThroughSMS() {
        val mockedEmailService = mockedEmailService ?: return

        val mockedFacebookService = mockedFacebookService ?: return

        val mockedSMSService = mockedSMSService ?: return

        mockedUser = User("Fulano de tal", arrayListOf(
                SMSContactInfo("1234123412")
        ))

        mockedUser?.let { mockedUser ->
            val notifier: INotifier = Notifier(
                    arrayListOf(mockedUser),
                    mockedEmailService,
                    mockedSMSService,
                    mockedFacebookService
            )
            notifier.send("Clase de patrones de disenyo")
        }
    }
}