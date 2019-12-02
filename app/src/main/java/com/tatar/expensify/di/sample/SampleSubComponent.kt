package com.tatar.expensify.di.sample

import com.tatar.expensify.ui.sample.SampleActivity
import dagger.BindsInstance
import dagger.Subcomponent

@PerSample
@Subcomponent(modules = [SampleModule::class, UseCaseModule::class])
interface SampleSubComponent {
    fun inject(sampleActivity: SampleActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun bindFirstInt(@FirstInt firstInt: Int): Builder

        @BindsInstance
        fun bindSecondInt(@SecondInt secondInt: Int): Builder

        fun build(): SampleSubComponent
    }
}