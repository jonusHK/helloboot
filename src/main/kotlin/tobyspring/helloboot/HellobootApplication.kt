package tobyspring.helloboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@SpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)
    val serverFactory: ServletWebServerFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer(ServletContextInitializer {

        val helloController: HelloController = HelloController()

        it.addServlet("frontcontroller", object: HttpServlet() {
            override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
                // 인증, 보안, 다국어, 공통 기능
                if (req.requestURI.equals("/hello") && req.method.equals(HttpMethod.GET.name)) {
                    val name: String = req.getParameter("name")
                    val ret: String = helloController.hello(name)

                    resp.status = HttpStatus.OK.value()
                    resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                    resp.writer.println(ret)
                }
                else if (req.requestURI.equals("/user")) {
                    //
                }
                else {
                    resp.status = HttpStatus.NOT_FOUND.value()
                }
            }
        }).addMapping("/*")
    })
    webServer.start()
}
