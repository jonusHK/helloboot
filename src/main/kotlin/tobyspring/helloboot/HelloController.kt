package tobyspring.helloboot

class HelloController(val helloService: HelloService) {

    fun hello(name: String): String {
        return helloService.sayHello(requireNotNull(name))
    }
}