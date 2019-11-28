package com.tatar.expensify.ui.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tatar.expensify.ExpensifyApp
import com.tatar.expensify.R
import com.tatar.expensify.repository.AnotherFakeRepository
import javax.inject.Inject

class SampleActivity : AppCompatActivity() {

    @Inject
    lateinit var anotherFakeRepository: AnotherFakeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        provideDependencies()

        anotherFakeRepository.fakeFunction()
    }

    private fun provideDependencies(){
        (application as ExpensifyApp)
            .appComponent()
            .getSampleSubComponent()
            .inject(this)
    }
}
