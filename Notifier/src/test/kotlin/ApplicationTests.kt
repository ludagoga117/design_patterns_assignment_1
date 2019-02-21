import Application.Application
import Notifier.INotifier
import org.junit.After
import org.junit.Before
import org.junit.Test

class ApplicationTests {

    private class MockedNotifier : INotifier {
        override fun send(message: String) {
            println("Message (${message}) successfully send to all users through their respective preferred mediums")
        }
    }

    var mockedApplication : Application? = null
    var mockedNotifier : INotifier? = null

    @Before
    fun setup() {
        mockedNotifier = MockedNotifier()

        mockedNotifier?.let {
            mockedApplication = Application( it )
        }
    }

    @After
    fun tearDown() {
        mockedApplication = null
        mockedNotifier = null
    }

    @Test
    fun shouldDoSomething() {
        mockedApplication?.doSomething()
    }
}