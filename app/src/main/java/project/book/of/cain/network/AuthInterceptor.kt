package project.book.of.cain.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    companion object {

        private const val ACCESS_TOKEN = "access_token"
        private const val LOCALE = "locale"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url().newBuilder()
            .addQueryParameter(ACCESS_TOKEN, "USKCMjfTqRlolF16JBFf54Q48E5ZdOL4Lx")
            .addQueryParameter(LOCALE, "en_US")
            .build()

        return chain.proceed(request.newBuilder().url(url).build())
    }
}
