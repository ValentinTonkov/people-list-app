package com.example.peoplelistapp.data

import android.app.Application
import com.example.peoplelistapp.data.person.PersonRepository

class DataApplication : Application() {
    private val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val repository by lazy { PersonRepository(database.getPersonDao()) }
}