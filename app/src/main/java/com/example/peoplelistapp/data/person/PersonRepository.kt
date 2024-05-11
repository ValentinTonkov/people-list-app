package com.example.peoplelistapp.data.person

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val dao: PersonDao) {
    val allPeople: Flow<List<Person>> = dao.getAll()

    fun getById(id: Int): LiveData<Person> = dao.getById(id).asLiveData()

    @WorkerThread
    suspend fun insert(person: Person){
        dao.insert(person)
    }
}