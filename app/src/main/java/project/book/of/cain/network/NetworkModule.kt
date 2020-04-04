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
    factory { provideOkHttp() }
    single { provideRetrofit(get()) }
}

private fun provideOkHttp() = OkHttpClient().newBuilder().build()

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory(MediaType.get(CONTENT_TYPE)))
        .build()
}
