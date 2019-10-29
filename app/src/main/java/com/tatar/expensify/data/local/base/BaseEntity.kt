package com.tatar.expensify.data.local.base

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

abstract class BaseEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo(name = "created_at")
    var createdAt: Long = System.currentTimeMillis()

    @ColumnInfo(name = "updated_at")
    var updatedAt: Long? = null

    @ColumnInfo(name = "is_synced")
    var synced: Boolean = false
}