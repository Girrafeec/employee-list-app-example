package com.girrafeecstud.employeelistappexmaple.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [


              ],
    dependencies = [
        AppDependencies::class
            ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun appDependencies(appDependencies: AppDependencies): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}