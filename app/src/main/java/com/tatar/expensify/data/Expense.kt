package com.tatar.expensify.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "expenses_table", foreignKeys = [ForeignKey(
        entity = ExpenseType::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("expense_type_id")
    )]
)
data class Expense(
    var amount: Double,
    var explanation: String,

    @ColumnInfo(name = "expense_type_id", index = true)
    var expenseTypeId: Int,

    @ColumnInfo(name = "user_id")
    var userId: Long = 0L // TODO add User entity
) : BaseEntity()