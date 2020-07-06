package com.applikdos.restservicewithkotlin.presenter

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem

interface MainPresenter {

    fun listUsers()
    fun showResult(result: List<UserDataCollectionItem>)
    fun errorResult(t: String)
}