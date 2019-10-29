package com.tatar.expensify.data.local.expensetype

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tatar.expensify.data.local.base.BaseDao

@Dao
interface ExpenseTypeDao :
    BaseDao<ExpenseType> {

    @Query("SELECT * FROM expense_types_table")
    fun getAllExpenseTypes(): LiveData<List<ExpenseType>> // TODO nullable?

    @Query("SELECT * FROM expense_types_table WHERE id = :id")
    fun getExpenseType(id: Long): ExpenseType // TODO nullable?, why is it not LiveData

    @Query("DELETE FROM expense_types_table")
    fun clearExpenses()
}