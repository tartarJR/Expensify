package com.tatar.expensify.di.app.component

import android.app.Application
import com.tatar.expensify.ExpensifyApp
import com.tatar.expensify.di.app.module.ActivityBuildersModule
import com.tatar.expensify.di.app.module.DatabaseModule
import com.tatar.expensify.di.app.module.GlideModule
import com.tatar.expensify.di.app.scope.PerApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/*
    By extending AndroidInjector and specifying ExpensifyApp we are basically telling Dagger 2 that
    we are going to inject ExpensifyApp to this component and ExpensifyApp is a client of that component
*/
@PerApp
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        DatabaseModule::class,
        GlideModule::class]
)
interface AppComponent : AndroidInjector<ExpensifyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder // Bind the instance of Application to the component at the time of component construction

        fun build(): AppComponent // Mandatory for the component
    }
}