package ru.cft.shift2021summer.countries.details.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import ru.cft.shift2021summer.countries.base.BasePresenter
import ru.cft.shift2021summer.countries.domain.CountryRepository

/** Класс-presenter для страницы деталей MVP **/

class CountryDetailsPresenter(
    private val repository: CountryRepository,
    private val countryName: String
) : BasePresenter<CountryDetailsView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onViewAttached() {
        val disposable = repository.get(countryName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    view?.bindCountry(it)
                },
            )
        compositeDisposable.add(disposable)
    }
}