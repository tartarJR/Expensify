package com.tatar.expensify.di.expense

import com.tatar.expensify.di.app.component.AppComponent
import com.tatar.expensify.ui.login.MainActivity
import dagger.Component

@PerExpense
@Component(dependencies = [AppComponent::class], modules = [ExpenseModule::class])
interface ExpenseComponent {
    fun inject(mainActivity: MainActivity)
}