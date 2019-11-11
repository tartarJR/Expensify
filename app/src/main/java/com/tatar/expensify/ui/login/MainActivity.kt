package com.tatar.expensify.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.tatar.expensify.R
import com.tatar.expensify.ui.expense.ExpenseActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // TODO Facebook login will be implemented
    fun fakeLoginClick(view: View) {
        val intent = Intent(this, ExpenseActivity::class.java)
        startActivity(intent)
    }
}
