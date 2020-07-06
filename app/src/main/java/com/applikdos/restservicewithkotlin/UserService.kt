package com.applikdos.restservicewithkotlin

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun listUsers(): Call<List<UserDataCollectionItem>>
}