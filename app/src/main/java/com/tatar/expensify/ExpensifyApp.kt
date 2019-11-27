package com.tatar.expensify

import android.app.Application
import com.tatar.expensify.di.app.component.AppComponent
import com.tatar.expensify.di.app.component.DaggerAppComponent

import timber.log.Timber


class ExpensifyApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        appComponent = DaggerAppComponent.builder().app(this).build()
    }

    fun appComponent(): AppComponent {
        return appComponent
    }
}