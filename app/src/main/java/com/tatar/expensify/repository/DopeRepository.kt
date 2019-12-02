package com.tatar.expensify.repository

import com.tatar.expensify.di.expense.PerExpense
import com.tatar.expensify.usecase.UseCase
import timber.log.Timber
import javax.inject.Inject

@PerExpense
class DopeRepository @Inject constructor(
    private val int: Int,
    private val useCase: UseCase
) {

    fun fakeFunction() {
        Timber.d("fake call in DopeRepository: $int")
        useCase.doSomething()
    }
}