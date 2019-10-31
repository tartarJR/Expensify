package com.tatar.expensify.di

import android.app.Application
import com.tatar.expensify.ExpensifyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/*
    By extending AndroidInjector and specifying ExpensifyApp we are basically telling Dagger 2 that
    we are going to inject ExpensifyApp to this component and ExpensifyApp is a client of that component
*/
@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<ExpensifyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder // Bind the instance of Application to the component at the time of component construction

        fun build(): AppComponent // Mandatory for the component
    }
}