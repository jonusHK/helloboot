package tobyspring.helloboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet


@Configuration
class HellobootApplication {
    @Bean
    fun helloController(helloService: HelloService): HelloController {
        return HelloController(helloService)
    }

    @Bean
    fun helloService(): HelloService {
        return SimpleHelloService()
    }
}

fun main(args: Array<String>) {
    // DispatcherServlet 은 GenericWebApplicationContext 사용
    val applicationContext: AnnotationConfigWebApplicationContext = object: AnnotationConfigWebApplicationContext() {
        @Suppress("ACCIDENTAL_OVERRIDE")
        override fun setClassLoader(classLoader: ClassLoader) {
            this.classLoader = classLoader
        }

        override fun onRefresh() {
            super.onRefresh()

            val serverFactory: ServletWebServerFactory = TomcatServletWebServerFactory()
            val webServer = serverFactory.getWebServer(ServletContextInitializer {
                it.addServlet(
                    "dispatcherServlet",
                    DispatcherServlet(this)
                ).addMapping("/*")
            })
            webServer.start()
        }
    }.apply {
        register(HellobootApplication::class.java)
    }
    applicationContext.refresh()
}
