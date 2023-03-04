package tobyspring.helloboot

class HelloController {
    fun hello(name: String): String {
        return "Hello $name"
    }
}