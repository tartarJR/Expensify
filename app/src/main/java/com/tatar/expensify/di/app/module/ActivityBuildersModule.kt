package com.tatar.expensify.di.app.module

import com.tatar.expensify.ui.login.MainActivity

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}
