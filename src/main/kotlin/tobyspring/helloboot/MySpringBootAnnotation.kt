package tobyspring.helloboot

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Configuration
@ComponentScan
annotation class MySpringBootAnnotation