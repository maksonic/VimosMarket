plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.hilt.plugin)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = ModuleInfo.Feature.Onboarding.namespace
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK

        testInstrumentationRunner = AndroidConfig.TEST_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = AndroidConfig.IS_MINIFY
            isShrinkResources = AndroidConfig.IS_SHRINK_RESOURCES

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = AndroidConfig.JAVA_VERSION
        targetCompatibility = AndroidConfig.JAVA_VERSION
    }

    kotlinOptions {
        jvmTarget = AndroidConfig.JVM_TARGET
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(ModuleInfo.Common.Ui.path))
    implementation(project(ModuleInfo.Navigation.Router.path))
    implementation(libs.appcompat)
    implementation(libs.glide)
    implementation(libs.material)
    implementation(libs.splash.screen)
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
}