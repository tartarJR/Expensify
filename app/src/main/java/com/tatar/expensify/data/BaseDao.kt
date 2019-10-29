package com.tatar.expensify.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {

    @Insert
    fun insert(obj: T)

    @Insert
    fun insert(vararg obj: T)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)

    @Delete
    fun deleteGivens(vararg obj: T): Int
}