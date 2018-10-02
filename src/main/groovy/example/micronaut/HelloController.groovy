package example.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

@Controller('/hello')
class HelloController {

    @Get
    Single<HttpResponse> hello() {
        def error = new CustomError(message: 'Fear is the path to the dark side.', errorCode: 42)
        def response = HttpResponse.badRequest(error)
        return Single.just(response)
    }
}
