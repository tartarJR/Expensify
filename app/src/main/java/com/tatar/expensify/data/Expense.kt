package com.tatar.expensify.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses_table")
data class Expense(

    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,

    var amount: Double,
    var type: ExpenseType,
    var explanation: String,

    @ColumnInfo(name = "user_id")
    var userId: Long = 0L,

    @ColumnInfo(name = "entry_time")
    val entryTime: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "is_synced")
    val isSynced: Boolean = false
)