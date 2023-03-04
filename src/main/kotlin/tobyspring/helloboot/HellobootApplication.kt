package tobyspring.helloboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.registerBean
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@SpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    val applicationContext = GenericApplicationContext().apply {
        registerBean<SimpleHelloService>()
        registerBean<HelloController>()
    }
    applicationContext.refresh()

    val serverFactory: ServletWebServerFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer(ServletContextInitializer {
        it.addServlet("frontcontroller", object: HttpServlet() {
            override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
                // 인증, 보안, 다국어, 공통 기능
                if (req.requestURI.equals("/hello") && req.method.equals(HttpMethod.GET.name)) {
                    val name: String = req.getParameter("name")
                    val helloController: HelloController = applicationContext.getBean(HelloController::class.java)
                    val ret = helloController.hello(name)

                    resp.contentType = MediaType.TEXT_PLAIN_VALUE
                    resp.writer.println(ret)
                }
                else {
                    resp.status = HttpStatus.NOT_FOUND.value()
                }
            }
        }).addMapping("/*")
    })
    webServer.start()
}
