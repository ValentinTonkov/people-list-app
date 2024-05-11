package com.example.peoplelistapp.ui.person.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplelistapp.R
import com.example.peoplelistapp.data.person.Person

class PersonAdapter(private val personList: List<Person>) : RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_rv_row, parent, false)

        return PersonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.personNameText.text = personList[position].name
        holder.personAgeText.text = personList[position].age.toString()

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "You clicked on ${personList[position].name}", Toast.LENGTH_SHORT).show()
        }
    }
}