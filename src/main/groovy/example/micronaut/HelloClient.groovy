package example.micronaut

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client('/hello')
interface HelloClient {

    @Get
    Single<String> hello()
}
