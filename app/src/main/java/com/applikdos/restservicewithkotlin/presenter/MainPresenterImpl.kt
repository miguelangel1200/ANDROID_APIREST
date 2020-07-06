package com.applikdos.restservicewithkotlin.presenter

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import com.applikdos.restservicewithkotlin.model.MainInteractorImpl
import com.applikdos.restservicewithkotlin.view.MainActivity


class MainPresenterImpl(view: MainActivity): MainPresenter {

    var view: MainActivity? = view
    var interactor: MainInteractorImpl = MainInteractorImpl(this)

    override fun listUsers() {
        interactor.listUsers()
    }

    override fun showResult(result: List<UserDataCollectionItem>) {
        view?.showResult(result)
    }

    override fun errorResult(t: String) {
        view?.errorResult(t)
    }


}