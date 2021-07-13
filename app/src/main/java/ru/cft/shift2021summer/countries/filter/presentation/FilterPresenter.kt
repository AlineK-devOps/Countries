package ru.cft.shift2021summer.countries.filter.presentation

import ru.cft.shift2021summer.countries.base.BasePresenter

class FilterPresenter: BasePresenter<FilterView>() {

    fun onScreenResumed(){
        view?.bindFilter()
    }

    fun onBackButtonClicked(){
        view?.closeScreen()
    }
}