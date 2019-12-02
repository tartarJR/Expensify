package com.tatar.expensify.repository

import com.tatar.expensify.usecase.UseCase
import timber.log.Timber

class AnotherFakeRepository(private val useCase: UseCase) {

    fun fakeFunction() {
        Timber.d("fake call in AnotherFakeRepository")
        useCase.doSomething()
    }
}