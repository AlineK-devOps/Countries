package ru.cft.shift2021summer.countries.filter.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import ru.cft.shift2021summer.countries.base.BasePresenter
import java.util.*
import kotlin.random.Random

class FilterPresenter: BasePresenter<FilterView>() {

    fun onScreenResumed(){
        view?.bindFilter()
    }

    fun onBackButtonClicked(){
        view?.closeScreen()
    }
}