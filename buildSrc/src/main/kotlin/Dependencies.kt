package dependencies

object Versions {

    const val kotlin = "1.3.61"
    const val constraintLayout = "1.1.3"
    const val appCompat = "1.1.0"
    const val androidKtx = "1.2.0"

    object Debug {

        const val leakCanary = "2.2"

    }

    object Network {

        const val retrofit = "2.7.2"

    }
}

object Libs {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val androidKtx = "androidx.core:core-ktx:${Versions.androidKtx}"

    object Debug {

        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.Debug.leakCanary}"

    }

    object Network {

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit}"

    }

}
