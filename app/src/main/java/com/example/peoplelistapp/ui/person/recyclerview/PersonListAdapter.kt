package com.example.peoplelistapp.ui.person.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import com.example.peoplelistapp.R
import com.example.peoplelistapp.data.person.Person
import com.example.peoplelistapp.ui.home.HomeFragmentDirections

class PersonListAdapter : ListAdapter<Person, PersonViewHolder>(PersonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_rv_row, parent, false)

        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        
        holder.personNameText.text = currentList[position].name
        holder.personAgeText.text = currentList[position].age.toString()
        holder.personIdText.text = currentList[position].id.toString()

        holder.itemView.setOnClickListener {
            val navController = Navigation.findNavController(it)
            if (navController.currentDestination?.id == R.id.nav_home){
                // passing the id of the selected person
                val action = HomeFragmentDirections.actionNavHomeToNavPersonInfo(currentList[position].id)
                navController.navigate(action)
            }
        }
    }
}