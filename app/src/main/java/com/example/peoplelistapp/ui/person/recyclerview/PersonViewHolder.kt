package com.example.peoplelistapp.ui.person.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplelistapp.R

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val personNameText: TextView
    val personAgeText: TextView
    val personIdText: TextView

    init {
        personNameText = itemView.findViewById(R.id.personNameText)
        personAgeText = itemView.findViewById(R.id.personAgeText)
        personIdText = itemView.findViewById(R.id.personIdText)
    }
}