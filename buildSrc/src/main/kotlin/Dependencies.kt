object Constants {
    const val compileSdkVersion = "30"
    const val minSdkVersion = "21"
    const val targetSdkVersion = "30"
    const val versionCode = 1
    const val versionName = "1.0.0"
}


object Versions {
    const val assertJ = "3.15.0"
    const val coroutines = "1.3.5"
    const val androidXCoreVersion = "1.3.1"
    const val androidx_core_version = "1.3.1"
    const val androidx_test_version = "1.1.2"
    const val arch_testing_version = "2.1.0"
    const val appcompat_version = "1.2.0"

    const val constraint_layout_version = "2.0.4"
    const val coroutines_adapter_version = "0.9.2"
    const val coroutines_version = "1.3.7"
    const val espresso_core_version = "3.3.0"
    const val fragmentKtx_version = "1.3.0-alpha08"
    const val fragment_testing_version = "1.2.5"

    const val hilt_lifecycle_extensions_version = "1.0.0-alpha02"
    const val junit_version = "4.13"
    const val glide_version = "4.11.0"
    const val material_version = "1.3.0-beta01"

    const val moshi_version = "1.10.0"
    const val okhttp_version = "4.9.0"
    const val okhttp_logging_iterceptor_version = "4.9.0"
    const val retrofit_moshi_converter_version = "2.9.0"
    const val room_version = "2.2.6"
    const val nav_version = "2.3.0"
    const val retrofit_version = "2.9.0"

    const val timber_version = "4.7.1"
    const val threetenabp_version = "1.2.4"
    const val viewModelKtx_version = "2.3.0-alpha07"
    const val kotlinVersion = "1.4.21"
}

object Libraries {
    const val androidXCore = "androidx.core:core-ktx:${Versions.androidx_core_version}"
    const val Junit = "junit:junit:${Versions.junit_version}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
}

object Network {
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofitScalars =
        "com.squareup.retrofit2:converter-scalars:${Versions.retrofit_version}"

    const val retrofitMoshi =
        "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_moshi_converter_version}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi_version}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi_version}"

    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutines_adapter_version}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_iterceptor_version}"
}

object Cache {
    const val room = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room_version}"
    const val roomCoroutines = "androidx.room:room-ktx:${Versions.room_version}"
}