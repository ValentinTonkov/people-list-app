package com.example.peoplelistapp.data.person.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import com.example.peoplelistapp.R
import com.example.peoplelistapp.data.person.Person

class PersonListAdapter : ListAdapter<Person, PersonViewHolder>(PersonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_rv_row, parent, false)

        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.personNameText.text = currentList[position].name
        holder.personAgeText.text = currentList[position].age.toString()

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "You clicked on ${currentList[position].name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}