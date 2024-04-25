package com.example.peoplelistapp.data.person

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "person")
data class Person(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
                  val name: String,
                  val age: Int)
{
    override fun toString(): String {
        return "id: $id $name $age"
    }
}
