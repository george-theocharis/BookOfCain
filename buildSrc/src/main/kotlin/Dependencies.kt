package dependencies

object Versions {

    object Kotlin {
        const val kotlin = "1.3.61"
        const val coroutines = "1.3.4"
    }

    object Android {

        const val constraintLayout = "1.1.3"
        const val appCompat = "1.1.0"
        const val androidKtx = "1.2.0"

    }

    object Debug {

        const val leakCanary = "2.2"

    }

    object Di {

        const val koin = "2.1.0"

    }

    object Network {

        const val retrofit = "2.7.2"

    }

    object Testing {

        const val mockk = "1.9"

    }

}

object Libs {

    object Kotlin {

        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutines}"

    }

    object Android {

        const val appCompat = "androidx.appcompat:appcompat:${Versions.Android.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}"
        const val androidKtx = "androidx.core:core-ktx:${Versions.Android.androidKtx}"

    }

    object Debug {

        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.Debug.leakCanary}"

    }

    object Di {

        val koin = "org.koin:koin-android:${Versions.Di.koin}"

    }

    object Network {

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit}"

    }

    object Testing {

        const val mockk = "io.mockk:mockk:${Versions.Testing.mockk}"

    }

}
