package com.tatar.expensify.di.sample

import com.tatar.expensify.usecase.AnotherFakeUseCase
import com.tatar.expensify.usecase.FakeUseCase
import com.tatar.expensify.usecase.UseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UseCaseModule {

    @Named("AnotherFakeUseCase")
    @Provides
    fun provideAnotherFakeUseCase(anotherFakeUseCase: AnotherFakeUseCase): UseCase {
        return anotherFakeUseCase
    }

    @Named("FakeUseCase")
    @Provides
    fun provideFakeUseCase(fakeUseCase: FakeUseCase): UseCase {
        return fakeUseCase
    }
}