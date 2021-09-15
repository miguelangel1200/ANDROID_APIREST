package com.applikdos.restservicewithkotlin.model

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import io.reactivex.rxjava3.core.Observer

interface MainInteractor {

    fun listUsers(subscriber: Observer<List<UserDataCollectionItem>>)
}