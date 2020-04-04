package project.book.of.cain

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import project.book.of.cain.acts.di.actsModule
import project.book.of.cain.network.networkModule

class BocApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BocApplication)
            modules(
                listOf(
                    networkModule,
                    actsModule
                )
            )
        }

    }

}
