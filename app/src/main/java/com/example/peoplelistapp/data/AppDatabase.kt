package com.example.peoplelistapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.peoplelistapp.data.person.Person
import com.example.peoplelistapp.data.person.PersonDao

@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPersonDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}