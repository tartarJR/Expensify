package com.tatar.expensify.data.local.expensetype

import androidx.room.Entity
import com.tatar.expensify.data.local.base.BaseEntity

@Entity(tableName = "expense_types_table")
class ExpenseType(
    var name: String,
    var explanation: String
) : BaseEntity()