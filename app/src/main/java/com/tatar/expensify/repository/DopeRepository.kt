package com.tatar.expensify.repository

import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import timber.log.Timber
import javax.inject.Inject

class DopeRepository @Inject constructor(private val expenseTypeDao: ExpenseTypeDao) {

    fun fakeFunction() {
        Timber.d("fake call in DopeRepository")
    }
}