package com.tatar.expensify.repository

import com.tatar.expensify.di.sample.PerSample
import com.tatar.expensify.usecase.UseCase
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

@PerSample
class FakeRepository @Inject constructor(@Named("FakeUseCase") private val useCase: UseCase) {

    fun fakeFunction() {
        Timber.d("fake call in FakeRepository")
        useCase.doSomething()
    }
}