package com.tatar.expensify.data.local.expense

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.tatar.expensify.data.local.base.BaseDao

@Dao
interface ExpenseDao :
    BaseDao<Expense> {

    @Query("SELECT * FROM expenses_table ORDER BY id DESC")
    fun getAllExpenses(): LiveData<List<Expense>> // TODO nullable?

    @Query("SELECT * FROM expenses_table WHERE id = :key")
    fun get(key: Long): Expense // TODO nullable?, why is it not LiveData

    @Query("SELECT * FROM expenses_table ORDER BY id DESC LIMIT 1")
    fun getLastExpense(): Expense? // TODO nullable?, why is it not LiveData

    @Query("DELETE FROM expenses_table")
    fun clearExpenses()
}