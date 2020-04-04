package project.book.of.cain.acts.di

import org.koin.dsl.module
import project.book.of.cain.acts.data.ActsApi
import retrofit2.Retrofit

internal val actsModule = module {

    single { provideActsApi(get()) }

}

private fun provideActsApi(retrofit: Retrofit) = retrofit.create(ActsApi::class.java)
