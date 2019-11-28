package com.tatar.expensify.repository

import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import com.tatar.expensify.di.expense.PerExpense
import timber.log.Timber
import javax.inject.Inject

@PerExpense
class DopeRepository @Inject constructor(
    private val expenseTypeDao: ExpenseTypeDao,
    private val int: Int
) {

    fun fakeFunction() {
        Timber.d("fake call in DopeRepository: $int")
    }
}