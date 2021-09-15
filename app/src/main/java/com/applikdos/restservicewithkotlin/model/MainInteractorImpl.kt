package com.applikdos.restservicewithkotlin.model

import com.applikdos.restservicewithkotlin.RestEngine
import com.applikdos.restservicewithkotlin.UserService
import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class MainInteractorImpl @Inject constructor(
) : MainInteractor {

    override fun listUsers(subscriber: Observer<List<UserDataCollectionItem>>) {
        RestEngine.getRestEngine().create(UserService::class.java).listUsers()
            .subscribeOn(Schedulers.newThread())
            .map { it.filter { it.address.city == "South Elvis" } }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(subscriber)
    }

}