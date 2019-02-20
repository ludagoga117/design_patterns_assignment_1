interface INotifier {
    fun send(message: String)
}

class Notifier : INotifier {
    override fun send(message: String) {
        print(message)
    }
}