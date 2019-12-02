package com.tatar.expensify.ui.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tatar.expensify.ExpensifyApp
import com.tatar.expensify.R
import com.tatar.expensify.repository.AnotherFakeRepository
import com.tatar.expensify.repository.FakeRepository
import com.tatar.expensify.usecase.FakeUseCase
import com.tatar.expensify.usecase.UseCase
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class SampleActivity : AppCompatActivity() {

    @Inject
    lateinit var anotherFakeRepository: AnotherFakeRepository

    @Inject
    lateinit var fakeRepository1: FakeRepository

    @Inject
    lateinit var fakeRepository2: FakeRepository

    // Dagger knows how to inject them without supplying the named or qualifier annotation
    @Inject
    lateinit var fakeUseCase: FakeUseCase

    @Inject
    lateinit var fakeUseCase2: FakeUseCase

    @Named("FakeUseCase")
    @Inject
    lateinit var fakeUseCase3: UseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        provideDependencies()

        Timber.d("fakeRepository1: $fakeUseCase")
        Timber.d("fakeRepository2: $fakeUseCase2")
        Timber.d("fakeRepository3: $fakeUseCase3")

        anotherFakeRepository.fakeFunction()
        fakeRepository1.fakeFunction()
    }

    private fun provideDependencies() {
        /*(application as ExpensifyApp)
            .appComponent()
            .getSampleSubComponentBuilder()
            .bindFirstInt(10)
            .bindSecondInt(10)
            .build()
            .inject(this)*/

        (application as ExpensifyApp)
            .appComponent()
            .getSampleSubComponentFactory().create(10, 10)
    }
}
