package tobyspring.helloboot


class SimpleHelloService : HelloService {
    override fun sayHello(name: String): String {
        return "Hello $name"
    }
}