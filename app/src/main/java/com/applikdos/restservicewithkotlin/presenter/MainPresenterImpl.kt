package com.applikdos.restservicewithkotlin.presenter

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import com.applikdos.restservicewithkotlin.model.DefaultObserver
import com.applikdos.restservicewithkotlin.model.MainInteractor
import com.applikdos.restservicewithkotlin.view.MainActivity
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainActivity,
    private val interactor: MainInteractor
) : MainPresenter {

    override fun listUsers() {
        interactor.listUsers(MainObserver())
    }

    inner class MainObserver : DefaultObserver<List<UserDataCollectionItem>>() {

        override fun onNext(t: List<UserDataCollectionItem>?) {
            dispose()
            view?.showResult(t!!)
        }

        override fun onError(e: Throwable?) {
            view?.errorResult(e?.message.toString())
        }
    }

}