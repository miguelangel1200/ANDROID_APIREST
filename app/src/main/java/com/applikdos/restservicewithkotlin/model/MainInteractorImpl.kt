package com.applikdos.restservicewithkotlin.model

import com.applikdos.restservicewithkotlin.RestEngine
import com.applikdos.restservicewithkotlin.UserService
import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import com.applikdos.restservicewithkotlin.presenter.MainPresenter
import com.applikdos.restservicewithkotlin.presenter.MainPresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainInteractorImpl(presenter: MainPresenterImpl): MainInteractor{

    var preseter: MainPresenterImpl = presenter

    override fun listUsers() {
        val userService: UserService = RestEngine.getRestEngine().create(UserService::class.java)
        val result: Call<List<UserDataCollectionItem>> = userService.listUsers()

        result.enqueue(object : Callback<List<UserDataCollectionItem>> {

            override fun onFailure(call: Call<List<UserDataCollectionItem>>, t: Throwable) {
                preseter.errorResult(t.message.toString())
            }

            override fun onResponse(call: Call<List<UserDataCollectionItem>>,
                                    response: Response<List<UserDataCollectionItem>>
            ) {
                response.body()?.let { preseter.showResult(it) }
            }

        })
    }


}