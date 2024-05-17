package com.example.peoplelistapp.service

import com.example.peoplelistapp.data.person.Person
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PeopleService {
    @GET("/api/people")
    suspend fun getAll(): Response<List<Person>>

    @POST("/api/people")
    suspend fun create(@Body person: Person)

    @GET("/api/people/{id}")
    suspend fun getPersonById(@Path("id") id : Int): Response<Person>


}