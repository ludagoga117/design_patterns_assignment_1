import ContactInfo.IContactInfo
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test

class ContactInfoTests {

    private class MockedContactInfo : IContactInfo {
        override fun getContactDestination(): String {
            return "mocked contact destination"
        }
    }

    var contactInfo: IContactInfo? = null

    @Before
    fun setup() {
        contactInfo = MockedContactInfo()
    }

    @After
    fun tearDown() {
        contactInfo = null
    }

    @Test
    fun shouldGetContactDestination() {
        Assert.assertEquals("mocked contact destination", contactInfo?.getContactDestination())
    }
}