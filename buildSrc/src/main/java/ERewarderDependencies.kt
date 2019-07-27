object ERewarderVersion {
    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
    const val minSdkVersion = 21

    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.3.41"
    const val coreKtx = "1.0.2"
    const val lifecycle = "2.0.0"
    const val junit = "4.12"
    const val espresso = "3.2.0"
    const val runner = "1.2.0"

    const val javaxInject = "1"
    const val javaxAnnotation = "1.0"
    const val room = "2.2.0-alpha01"
    const val rxJava = "2.2.10"
    const val rxAndroid = "2.1.1"
    const val okhttp = "3.12.0"
    const val retrofit = "2.6.0"
    const val recyclerAnimator = "3.0.0"
    const val materialComponent = "1.1.0-alpha08"
    const val dagger = "2.24"
    const val stetho = "1.5.1"
    const val timber = "4.7.1"
    const val navigation = "2.1.0-alpha06"
    const val constraintLayout = "2.0.0-beta1"
    const val rxAnimation = "0.0.6"
    const val otpView = "1.4.3"
    const val shimmerLayout = "0.4.0"
    const val fresco = "2.0.0"
    const val multidex = "2.0.1"
    const val overscrollDecor = "1.0.4"
}

object ERewarderCoreDependencies {
    const val applicationId = "com.ayokunlepaul.erewarder"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${ERewarderVersion.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${ERewarderVersion.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${ERewarderVersion.coreKtx}"
    const val androidFragmentKtx = "androidx.fragment:fragment-ktx:${ERewarderVersion.coreKtx}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${ERewarderVersion.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${ERewarderVersion.lifecycle}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${ERewarderVersion.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${ERewarderVersion.navigation}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${ERewarderVersion.constraintLayout}"
    const val multidex = "androidx.multidex:multidex:${ERewarderVersion.multidex}"
}

object ERewarderViewDependencies {
    const val materialComponent = "com.google.android.material:material:${ERewarderVersion.materialComponent}"
    const val rxAnimation = "com.mikhaellopez:rxanimation:${ERewarderVersion.rxAnimation}"
    const val shimmerLayout = "com.facebook.shimmer:shimmer:${ERewarderVersion.shimmerLayout}"
    const val optView = "com.chaos.view:pinview:${ERewarderVersion.otpView}"
    const val fresco = "com.facebook.fresco:fresco:${ERewarderVersion.fresco}"
}

object ERewarderDIDependencies {
    const val javax = "javax.inject:javax.inject:${ERewarderVersion.javaxInject}"
    const val javaxAnnotation = "javax.annotation:jsr250-api:${ERewarderVersion.javaxAnnotation}"
    const val dagger = "com.google.dagger:dagger:${ERewarderVersion.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${ERewarderVersion.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${ERewarderVersion.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${ERewarderVersion.dagger}"
}

object ERewarderCacheDependencies {
    const val room = "androidx.room:room-runtime:${ERewarderVersion.room}"
    const val roomRx = "androidx.room:room-rxjava2:${ERewarderVersion.room}"
    const val roomCompiler = "androidx.room:room-compiler:${ERewarderVersion.room}"
}

object ERewarderUtilityDependencies {
    const val timber = "com.jakewharton.timber:timber:${ERewarderVersion.timber}"
    const val recyclerAnimator = "jp.wasabeef:recyclerview-animators:${ERewarderVersion.recyclerAnimator}"
    const val overscrollDecor = "me.everything:overscroll-decor-android:${ERewarderVersion.overscrollDecor}"
}

object ERewarderAsyncDependencies {
    const val rxJava = "io.reactivex.rxjava2:rxjava:${ERewarderVersion.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${ERewarderVersion.rxAndroid}"
}