package com.tatar.expensify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_types_table")
class ExpenseType(

    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,
    var name: String,
    var explanation: String
)