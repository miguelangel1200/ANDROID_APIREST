package com.applikdos.restservicewithkotlin.entities

class UserDataCollection : ArrayList<UserDataCollectionItem>()

data class UserDataCollectionItem(
    val id: Int,
    val name: String,
    val precio: Double,
    val description: String
)

