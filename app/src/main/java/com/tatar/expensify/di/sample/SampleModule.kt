package com.tatar.expensify.di.sample

import com.tatar.expensify.repository.AnotherFakeRepository
import com.tatar.expensify.usecase.UseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object SampleModule {

    @PerSample
    @Provides
    fun provideAnotherFakeRepository(@Named("AnotherFakeUseCase") useCase: UseCase): AnotherFakeRepository {
        return AnotherFakeRepository(useCase)
    }
}