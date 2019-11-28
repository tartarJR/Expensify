package com.tatar.expensify.di.expense

import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import com.tatar.expensify.repository.FakeRepository
import dagger.Module
import dagger.Provides

@Module
object ExpenseModule {

    @PerExpense
    @Provides
    fun provideFakeRepository(expenseTypeDao: ExpenseTypeDao): FakeRepository {
        return FakeRepository(expenseTypeDao)
    }
}