package com.tatar.expensify.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expenses_table ORDER BY _id DESC")
    fun getAllExpenses(): LiveData<List<Expense>> // TODO nullable?

    @Query("SELECT * FROM expenses_table WHERE _id = :key")
    fun get(key: Long): Expense // TODO nullable?, why is it not LiveData

    @Query("SELECT * FROM expenses_table ORDER BY _id DESC LIMIT 1")
    fun getLastExpense(): Expense? // TODO nullable?, why is it not LiveData

    @Insert
    fun insert(expense: Expense)

    @Update
    fun update(expense: Expense)

    @Delete
    fun deleteGivenExpense(expense: Expense)

    @Delete
    fun deleteGivenExpenses(expenses: List<Expense>): Int

    @Query("DELETE FROM expenses_table")
    fun clearExpenses()
}