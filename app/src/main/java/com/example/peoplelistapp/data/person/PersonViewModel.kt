package com.example.peoplelistapp.data.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class PersonViewModel(private val repository: PersonRepository) : ViewModel() {

    val allPeople = repository.allPeople.asLiveData()

    fun insert(person: Person){
        viewModelScope.launch (Dispatchers.IO){
           repository.insert(person)
        }
    }
}

@Suppress("UNCHECKED_CAST")
class PersonViewModelFactory(private val repository: PersonRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)){
            return PersonViewModel(repository) as T
        }
        throw IllegalArgumentException("No such ViewModel class")
    }
}