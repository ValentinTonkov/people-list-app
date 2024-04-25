package com.example.peoplelistapp.data.person

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.peoplelistapp.data.person.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: Person)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query ("SELECT * FROM person")
    fun getAll() : Flow<List<Person>>
}