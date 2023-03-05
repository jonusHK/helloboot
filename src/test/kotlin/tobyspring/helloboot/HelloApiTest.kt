package tobyspring.helloboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

class HelloApiTest {
    @Test
    fun helloApi() {
        val rest: TestRestTemplate = TestRestTemplate()

        val res: ResponseEntity<String> =
            rest.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, "Spring")

        // Check
        // status 200
        assertThat(res.statusCode).isEqualTo(HttpStatus.OK)
        // header (content-type) text/plain
        assertThat(res.headers.getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE)
        // body Hello Spring
        assertThat(res.body).isEqualTo("Hello Spring")
    }
}