package project.book.of.cain.acts.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import project.book.of.cain.acts.data.ActsApi
import project.book.of.cain.acts.data.ActsRepositoryImpl
import project.book.of.cain.acts.domain.ActsRepository
import project.book.of.cain.acts.ui.ActsViewModel
import retrofit2.Retrofit

internal val actsModule = module {

    single { provideActsApi(get()) }
    factory<ActsRepository> { ActsRepositoryImpl(api = get()) }
    viewModel { ActsViewModel(repository = get()) }
}

private fun provideActsApi(retrofit: Retrofit) = retrofit.create(ActsApi::class.java)
