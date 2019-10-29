package com.tatar.expensify.data

import androidx.room.Entity

@Entity(tableName = "expense_types_table")
class ExpenseType(
    var name: String,
    var explanation: String
) : BaseEntity()