package com.tatar.expensify.repository

import com.tatar.expensify.data.local.expense.ExpenseDao
import timber.log.Timber

class AnotherFakeRepository(private val expenseDao: ExpenseDao) {

    fun fakeFunction() {
        Timber.d("fake call in AnotherFakeRepository")
    }
}