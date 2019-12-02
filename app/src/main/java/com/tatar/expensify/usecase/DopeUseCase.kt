package com.tatar.expensify.usecase

import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import timber.log.Timber
import javax.inject.Inject

class DopeUseCase @Inject constructor(private val expenseTypeDao: ExpenseTypeDao) : UseCase {
    override fun doSomething() {
        Timber.d("DopeUseCase is doing something")
    }
}