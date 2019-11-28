package com.tatar.expensify.di.sample

import com.tatar.expensify.data.local.expense.ExpenseDao
import com.tatar.expensify.repository.AnotherFakeRepository
import dagger.Module
import dagger.Provides

@Module
object SampleModule {

    @PerSample
    @Provides
    fun provideAnotherFakeRepository(expenseDao: ExpenseDao): AnotherFakeRepository {
        return AnotherFakeRepository(expenseDao)
    }
}