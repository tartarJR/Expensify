package com.tatar.expensify.usecase

import com.tatar.expensify.data.local.expense.ExpenseDao
import com.tatar.expensify.di.sample.PerSample
import timber.log.Timber
import javax.inject.Inject

@PerSample
class AnotherFakeUseCase @Inject constructor(private val expenseDao: ExpenseDao) : UseCase {
    override fun doSomething() {
        Timber.d("AnotherFakeUseCase is doing something")
    }
}