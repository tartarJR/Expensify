package com.tatar.expensify.di.app.component

import android.content.Context
import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import com.tatar.expensify.di.app.module.DatabaseModule
import com.tatar.expensify.di.app.module.NetworkModule
import com.tatar.expensify.di.app.scope.PerApp
import dagger.BindsInstance
import dagger.Component

@PerApp
@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    // TODO provide app level dependencies here
    //fun expenseDao(): ExpenseDao

    fun expenseTypeDao(): ExpenseTypeDao

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(applicationContext: Context): Builder // Bind the instance of Application to the component at the time of component construction, provide run time dependencies

        fun build(): AppComponent // Mandatory for the component if Builder interface is used
    }
}