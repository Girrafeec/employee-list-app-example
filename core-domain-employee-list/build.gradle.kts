
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        //applicationId = "com.girrafeecstud.employeelistappexamplecoredomain"
        minSdk = 21
        targetSdk = 31
        //versionCode = 1
        //versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Dagger
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerCompiler)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutines)

    // Unit-tests
    testImplementation(Dependencies.jUnit.jUnit)

    // Mockito
    testImplementation(Dependencies.Mockito.mockitoKotlin)
    testImplementation(Dependencies.Mockito.mockitoInline)

    implementation(project(":core-domain"))
    implementation(project(":core-domain-employee-list-entities"))
    implementation(project(":core-unit-tests-employee-list-sample-data"))
}