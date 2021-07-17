package ru.cft.shift2021summer.countries.base

import io.reactivex.disposables.CompositeDisposable

/** Базовый presenter для MVP **/

open class BasePresenter <View: BaseView> {
    var view: View? = null
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun attachView(view: View){
        this.view = view
        onViewAttached()
    }

    fun destroy(){
        this.view = null
    }

    open fun onViewAttached(){}

    fun onCleared() {
        compositeDisposable.clear()
    }
}