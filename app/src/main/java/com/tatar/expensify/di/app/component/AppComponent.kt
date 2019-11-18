package com.tatar.expensify.di.app.component

import android.app.Application
import com.tatar.expensify.di.app.module.DatabaseModule
import com.tatar.expensify.di.app.module.GlideModule
import com.tatar.expensify.di.app.scope.PerApp
import dagger.BindsInstance
import dagger.Component


@PerApp
@Component(
    modules = [
        DatabaseModule::class,
        GlideModule::class
    ]
)
interface AppComponent {

    // TODO provide app level dependencies here

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder // Bind the instance of Application to the component at the time of component construction

        fun build(): AppComponent // Mandatory for the component
    }
}