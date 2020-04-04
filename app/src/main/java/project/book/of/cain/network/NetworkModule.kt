package project.book.of.cain.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_URL = "https://us.api.blizzard.com"
private const val CONTENT_TYPE = "application/json"

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttp(authInterceptor = get()) }
    single { provideRetrofit(okHttpClient = get()) }
}

private fun provideOkHttp(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory(MediaType.get(CONTENT_TYPE)))
        .build()
}
