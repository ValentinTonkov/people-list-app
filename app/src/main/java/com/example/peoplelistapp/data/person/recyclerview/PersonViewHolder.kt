package com.example.peoplelistapp.data.person.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplelistapp.R

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val personNameText: TextView
    val personAgeText: TextView

    init {
        personNameText = itemView.findViewById(R.id.personNameText)
        personAgeText = itemView.findViewById(R.id.personAgeText)
    }
}