package dependencies

object Versions {

    object Kotlin {

        const val KOTLIN = "1.3.61"
        const val COROUTINES = "1.3.4"

    }

    object Android {

        const val CONSTRAINT_LAYOUT = "1.1.3"
        const val APP_COMPAT = "1.1.0"
        const val ANDROID_KTX = "1.2.0"

    }

    object Debug {

        const val LEAK_CANARY = "2.2"

    }

    object Di {

        const val KOIN = "2.1.0"

    }

    object Network {

        const val RETROFIT = "2.7.2"

    }

    object Testing {

        const val MOCKK = "1.9"

    }

}

object Libs {

    object Kotlin {

        const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.KOTLIN}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.COROUTINES}"

    }

    object Android {

        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Android.APP_COMPAT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.Android.CONSTRAINT_LAYOUT}"
        const val ANDROID_KTX = "androidx.core:core-ktx:${Versions.Android.ANDROID_KTX}"

    }

    object Debug {

        const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.Debug.LEAK_CANARY}"

    }

    object Di {

        const val KOIN = "org.koin:koin-android:${Versions.Di.KOIN}"

    }

    object Network {

        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT}"

    }

    object Testing {

        const val MOCKK = "io.mockk:mockk:${Versions.Testing.MOCKK}"

    }

}
