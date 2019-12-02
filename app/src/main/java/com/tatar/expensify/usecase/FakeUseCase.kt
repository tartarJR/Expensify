package com.tatar.expensify.usecase

import com.tatar.expensify.di.sample.PerSample
import timber.log.Timber
import javax.inject.Inject

@PerSample
class FakeUseCase @Inject constructor() : UseCase {
    override fun doSomething() {
        Timber.d("FakeUseCase is doing something")
    }
}