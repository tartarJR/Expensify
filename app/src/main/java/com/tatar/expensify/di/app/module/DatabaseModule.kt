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

    //@JvmStatic no need to add this annotation anymore as Dagger 2 will be identifying these methods as static
    @PerApp
    @Provides
    internal fun provideExpensifyDatabase(context: Context): ExpensifyDatabase {
        return ExpensifyDatabase.getInstance(context)
    }

    @PerApp
    @Provides
    internal fun provideExpenseDao(expensifyDatabase: ExpensifyDatabase): ExpenseDao {
        return expensifyDatabase.expenseDao
    }

    @PerApp
    @Provides
    internal fun provideExpenseTypeDao(expensifyDatabase: ExpensifyDatabase): ExpenseTypeDao {
        return expensifyDatabase.expenseTypeDao
    }
}