package ru.cft.shift2021summer.countries.main.presentation

/** Класс-presenter для главной страницы MVP **/

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import ru.cft.shift2021summer.countries.base.BasePresenter
import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.domain.model.CountryModel

class MainPresenter(
    private val repository: CountryRepository
    )
    : BasePresenter<MainView>() {

    fun onScreenResumed(){
        val disposable = repository.getAll()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    view?.bindCountry(it)
                },
            )
        compositeDisposable.add(disposable)
    }

    fun onCountryClicked(country: CountryModel){
        view?.openDetailsScreen(country.name)
    }
}