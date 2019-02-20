class Application(private var notifier: INotifier) {

    fun set(notifier: INotifier){
        this.notifier = notifier
    }

    fun doSomething(){
        this.notifier.send("Hola mundo!")
    }
}