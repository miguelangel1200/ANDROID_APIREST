package com.applikdos.restservicewithkotlin.view

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem

interface MainView {

    fun showResult(result: List<UserDataCollectionItem>)
    fun errorResult(t: String)
}