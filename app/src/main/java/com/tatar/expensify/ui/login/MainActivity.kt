package com.tatar.expensify.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tatar.expensify.ExpensifyApp
import com.tatar.expensify.R
import com.tatar.expensify.di.expense.DaggerExpenseComponent
import com.tatar.expensify.repository.DopeRepository
import com.tatar.expensify.repository.FakeRepository
import com.tatar.expensify.ui.sample.SampleActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fakeRepository: FakeRepository

    @Inject
    lateinit var dopeRepository: DopeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        provideDependencies()
    }

    // TODO Facebook login will be implemented
    fun fakeLoginClick(view: View) {

        fakeRepository.fakeFunction()
        dopeRepository.fakeFunction()

        val intent = Intent(this, SampleActivity::class.java)
        startActivity(intent)
    }

    private fun provideDependencies() {
        DaggerExpenseComponent.builder()
            .binInt(1)
            .appComponent((application as ExpensifyApp).appComponent())
            .build()
            .inject(this)
    }
}
