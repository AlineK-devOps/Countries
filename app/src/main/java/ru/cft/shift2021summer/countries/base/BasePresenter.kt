package ru.cft.shift2021summer.countries.base

/** Базовый presenter для MVP **/

open class BasePresenter <View: BaseView> {
    var view: View? = null

    fun attachView(view: View){
        this.view = view
        onViewAttached()
    }

    fun destroy(){
        this.view = null
    }

    open fun onViewAttached(){}
}