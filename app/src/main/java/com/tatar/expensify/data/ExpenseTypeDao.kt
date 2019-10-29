package com.tatar.expensify.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpenseTypeDao : BaseDao<ExpenseType> {

    @Query("SELECT * FROM expense_types_table")
    fun getAllExpenseTypes(): LiveData<List<ExpenseType>> // TODO nullable?

    @Query("SELECT * FROM expense_types_table WHERE id = :id")
    fun getExpenseType(id: Long): ExpenseType // TODO nullable?, why is it not LiveData

    @Query("DELETE FROM expense_types_table")
    fun clearExpenses()
}