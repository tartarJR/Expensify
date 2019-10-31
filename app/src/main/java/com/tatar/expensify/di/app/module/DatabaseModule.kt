package com.tatar.expensify.di.app.module

import android.content.Context
import com.tatar.expensify.data.local.ExpensifyDatabase
import com.tatar.expensify.data.local.expense.ExpenseDao
import com.tatar.expensify.data.local.expensetype.ExpenseTypeDao
import com.tatar.expensify.di.app.scope.PerApp
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideExpensifyDatabase(context: Context): ExpensifyDatabase {
        return ExpensifyDatabase.getInstance(context)
    }

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideExpenseDao(expensifyDatabase: ExpensifyDatabase): ExpenseDao {
        return expensifyDatabase.expenseDao
    }

    @JvmStatic
    @PerApp
    @Provides
    internal fun provideExpenseTypeDao(expensifyDatabase: ExpensifyDatabase): ExpenseTypeDao {
        return expensifyDatabase.expenseTypeDao
    }
}