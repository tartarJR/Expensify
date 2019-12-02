package com.tatar.expensify.di.expense

import com.tatar.expensify.usecase.DopeUseCase
import com.tatar.expensify.usecase.UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class ExpenseModule {

    @PerExpense
    @Binds
    abstract fun provideFakeUseCase(dopeUseCase: DopeUseCase): UseCase
}