package com.example.peoplelistapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peoplelistapp.data.person.Person
import com.example.peoplelistapp.service.PeopleService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    private val _allPeople = MutableLiveData<List<Person>>()
    val allPeople : LiveData<List<Person>>
        get() = _allPeople

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://stunning-succotash-jrvg6xqvgxqhp4r7-8080.app.github.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PeopleService = retrofit.create(PeopleService::class.java)

    fun getAll(){
        viewModelScope.launch (Dispatchers.IO){
            _allPeople.postValue(service.getAll().body())
        }
    }

    fun create(person: Person){
        viewModelScope.launch (Dispatchers.IO){
            service.create(person)
        }
    }


}