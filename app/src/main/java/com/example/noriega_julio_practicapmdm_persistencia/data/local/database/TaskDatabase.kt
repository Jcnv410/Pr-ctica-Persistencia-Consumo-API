package com.example.noriega_julio_practicapmdm_persistencia.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noriega_julio_practicapmdm_persistencia.data.model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null
        fun provideTaskDao(context: Context): TaskDao {
            return getDatabase(context).taskDao()
        }

        fun getDatabase(context: Context): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "StudySphere"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


