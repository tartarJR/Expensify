package com.tatar.expensify.di.expense

import com.tatar.expensify.di.app.component.AppComponent
import com.tatar.expensify.ui.login.MainActivity
import dagger.BindsInstance
import dagger.Component

@PerExpense
@Component(dependencies = [AppComponent::class], modules = [ExpenseModule::class])
interface ExpenseComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun binInt(int: Int): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): ExpenseComponent
    }
}