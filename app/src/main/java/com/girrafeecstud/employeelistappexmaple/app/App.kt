package com.girrafeecstud.employeelistappexmaple.app

import android.app.Application
import com.girrafeecstud.employeelistappexmaple.di.AppComponent
import com.girrafeecstud.employeelistappexmaple.di.AppDependencies
import com.girrafeecstud.employeelistappexmaple.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appDependencies(appDependencies = AppDependenciesImpl())
            .context(context = this)
            .build()
    }

    private inner class AppDependenciesImpl: AppDependencies {
        override val application: Application = this@App
    }

}