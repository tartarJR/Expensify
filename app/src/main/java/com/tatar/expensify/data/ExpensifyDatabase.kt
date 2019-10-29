package com.tatar.expensify.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
    Increase the version by one anytime the schema changes, otherwise app won't work
    The property exportSchema saves the schema of the db to a folder to provide a version history for db, it is set to true by default
*/
@Database(entities = [Expense::class, ExpenseType::class], version = 1, exportSchema = false)
abstract class ExpensifyDatabase : RoomDatabase() {

    // Declare all DAO interfaces associated with the entities
    abstract val expenseDao: ExpenseDao
    abstract val expenseTypeDao: ExpenseTypeDao

    companion object {

        private const val DATABASE_NAME = "expensify_database"

        /*
            Make sure value of instance is up to date and same for all execution threads by making the instance volatile
            Changes made by a thread to instance are visible to other threads immediately
        */
        @Volatile
        private var INSTANCE: ExpensifyDatabase? = null

        fun getInstance(context: Context): ExpensifyDatabase {
            /*
                Multiple threads may ask for a db instance at the same time and to prevent having more than one db instance
                and allowing only one thread to execute the db creation code at a certain time we use a synchronized block.
                Using a synchronized block ensures that only one thread can execute this block at one certain time
            */
            synchronized(this) {
                // Smart cast is only available to local variables, so copy INSTANCE(class variable) value to local variable
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExpensifyDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration() // TODO A migration object with a migration strategy is needed
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}