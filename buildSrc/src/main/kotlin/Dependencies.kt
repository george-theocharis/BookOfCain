package dependencies

object Versions {

    object Kotlin {

        const val KOTLIN = "1.3.71"
        const val COROUTINES = "1.3.4"

    }

    object Android {

        const val CONSTRAINT_LAYOUT = "1.1.3"
        const val APP_COMPAT = "1.1.0"
        const val ANDROID_KTX = "1.2.0"
        const val VIEWMODEL_KTX = "2.1.0"

        object Test {

            const val CORE = "2.1.0"

        }

    }

    object Debug {

        const val LEAK_CANARY = "2.2"

    }

    object Di {

        const val KOIN = "2.1.2"

    }

    object Network {

        const val RETROFIT = "2.7.2"
        const val CONVERTER = "0.5.0"

    }

    object Testing {

        const val MOCKK = "1.9"
        const val COROUTINES = "1.3.5"
        const val JUNIT = "4.12"

    }

}

object Libs {

    object Kotlin {

        const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.KOTLIN}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.COROUTINES}"
        const val SERIALIZER = "org.jetbrains.kotlin:kotlin-serialization:${Versions.Kotlin.KOTLIN}"

    }

    object Android {

        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Android.APP_COMPAT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.Android.CONSTRAINT_LAYOUT}"
        const val ANDROID_KTX = "androidx.core:core-ktx:${Versions.Android.ANDROID_KTX}"
        const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.VIEWMODEL_KTX}"

        object Test {

            const val CORE = "androidx.arch.core:core-testing:${Versions.Android.Test.CORE}"

        }

    }

    object Debug {

        const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.Debug.LEAK_CANARY}"

    }

    object Di {

        const val KOIN = "org.koin:koin-android:${Versions.Di.KOIN}"
        const val VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.Di.KOIN}"

    }

    object Network {

        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT}"
        const val CONVERTER = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.Network.CONVERTER}"

    }

    object Testing {

        const val JUNIT = "junit:junit:${Versions.Testing.JUNIT}"
        const val MOCKK = "io.mockk:mockk:${Versions.Testing.MOCKK}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Testing.COROUTINES}"

    }

}
