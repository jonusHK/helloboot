package com.bhkpo.springboot.helloboot

import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class MySpringApplication {

    companion object {
        @JvmStatic
        fun run() {
            val applicationContext: AnnotationConfigWebApplicationContext = object: AnnotationConfigWebApplicationContext() {
                @Suppress("ACCIDENTAL_OVERRIDE")
                override fun setClassLoader(classLoader: ClassLoader) {
                    this.classLoader = classLoader
                }

                override fun onRefresh() {
                    super.onRefresh()

                    val serverFactory: ServletWebServerFactory = this.getBean(ServletWebServerFactory::class.java)
                    val dispatcherServlet: DispatcherServlet = this.getBean(DispatcherServlet::class.java)

                    val webServer = serverFactory.getWebServer(ServletContextInitializer {
                        it.addServlet("dispatcherServlet", dispatcherServlet).addMapping( "/*")
                    })
                    webServer.start()
                }
            }.apply {
                register(HellobootApplication::class.java)
            }
            applicationContext.refresh()
        }
    }
}