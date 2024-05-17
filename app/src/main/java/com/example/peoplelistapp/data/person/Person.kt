package com.example.peoplelistapp.data.person

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class Person(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int
) {
    override fun toString(): String {
        return "id: $id $name $age"
    }
}
