package com.tatar.expensify.di.sample

import com.tatar.expensify.ui.sample.SampleActivity
import dagger.Subcomponent

@PerSample
@Subcomponent(modules = [SampleModule::class, UseCaseModule::class])
interface SampleSubComponent {
    fun inject(sampleActivity: SampleActivity)
}