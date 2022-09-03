class Dependencies {

    object Jetpack {

    }

    object Google {

        object Material {
            const val material = "com.google.android.material:material:${Versions.materialVersion}"
        }

    }

    object AndroidX {

        object Core {
            const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        }

        object Espresso {
            const val espressoCore =
                "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
        }

        object Constraintlayout {
            const val constraintLayout =
                "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        }

        object AppCompat {
            const val appCompat =
                "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        }

    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    }

    object Coroutines {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    }

    object jUnit {
        const val jUnit = "junit:junit:${Versions.jUnitVersion}"
        const val jUnitAndroidTest = "androidx.test.ext:junit:${Versions.jUnitAndroidxExtVersion}"
    }

    object Kaspresso {

    }
}