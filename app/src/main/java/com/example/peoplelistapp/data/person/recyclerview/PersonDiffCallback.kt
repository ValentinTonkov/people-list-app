package com.example.peoplelistapp.data.person.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.peoplelistapp.data.person.Person

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.name == newItem.name && oldItem.age == newItem.age
    }
}