package com.example.peoplelistapp.data.person

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val dao: PersonDao) {
    val allPeople: Flow<List<Person>> = dao.getAll()

    @WorkerThread
    suspend fun insert(person: Person){
        dao.insert(person)
    }
}