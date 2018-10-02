package example.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class HelloClientSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    HelloClient client = embeddedServer
            .applicationContext
            .getBean(HelloClient)

    void "test hello world"() {
        when:
        client.hello().blockingGet()

        then:
        def ex = thrown(HttpClientResponseException)
        def error = ex.response.getBody(CustomError).get()
        error.errorCode == 42
    }
}
