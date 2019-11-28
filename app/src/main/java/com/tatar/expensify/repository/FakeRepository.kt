package com.tatar.expensify.repository

import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import timber.log.Timber


class FakeRepository(private val expenseTypeDao: ExpenseTypeDao) {

    fun fakeFunction() {
        Timber.d("fake call in FakeRepository")
    }
}