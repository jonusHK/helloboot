package tobyspring.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

class HelloApiTest: AnnotationSpec() {

    @BeforeEach
    fun beforeTest() {
        println("Before each Test")
    }

    @Test
    fun helloApi() {
        val rest: TestRestTemplate = TestRestTemplate()

        val res: ResponseEntity<String> =
            rest.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, "Spring")

        // Check
        // status 200
        res.statusCode shouldBe HttpStatus.OK
        // header (content-type) text/plain
        res.headers.getFirst(HttpHeaders.CONTENT_TYPE) shouldStartWith MediaType.TEXT_PLAIN_VALUE
        // body Hello Spring
        res.body shouldBe "Hello Spring"
    }

    @Test
    fun failsHelloApi() {
        val rest: TestRestTemplate = TestRestTemplate()

        val res: ResponseEntity<String> =
            rest.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, "")

        res.statusCode shouldBe HttpStatus.INTERNAL_SERVER_ERROR
    }
}