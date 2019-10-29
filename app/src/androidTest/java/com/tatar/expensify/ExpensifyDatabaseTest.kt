package com.tatar.expensify

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.tatar.expensify.data.local.ExpensifyDatabase
import com.tatar.expensify.data.local.expense.Expense
import com.tatar.expensify.data.local.expense.ExpenseDao
import com.tatar.expensify.data.local.expensetype.ExpenseType
import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExpensifyDatabaseTest {

    private lateinit var expenseDao: ExpenseDao
    private lateinit var expenseTypeDao: ExpenseTypeDao
    private lateinit var expensifyDatabase: ExpensifyDatabase

    @Before
    fun createExpensifyDatabase() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        // In-memory db for testing purposes only, will be destroyed after test execution
        expensifyDatabase = Room.inMemoryDatabaseBuilder(context, ExpensifyDatabase::class.java)
            .allowMainThreadQueries() // Allowed only for testing
            .build()

        expenseDao = expensifyDatabase.expenseDao
        expenseTypeDao = expensifyDatabase.expenseTypeDao

        insertExpenseType(provideExpenseType())
    }

    @After
    fun closeExpensifyDatabase() {
        expensifyDatabase.close()
    }

    @Test
    fun insert_Expense_Success() {
        val expenseToInsert = provideExpense()
        expenseDao.insert(expenseToInsert)
        val lastInsertedExpense = expenseDao.getLastExpense()
        assertEquals(expenseToInsert.amount, lastInsertedExpense?.amount)
    }

    private fun insertExpenseType(expenseType: ExpenseType) {
        expenseTypeDao.insert(expenseType)
    }

    private fun provideExpense(): Expense {
        return Expense(
            amount = 10.2,
            expenseTypeId = 1,
            explanation = ""
        )
    }

    private fun provideExpenseType(): ExpenseType {
        return ExpenseType(
            name = "sample expense type",
            explanation = "sample expense type explanation"
        )
    }
}
