package ru.cft.shift2021summer.details

import ru.cft.shift2021summer.base.BasePresenter
import ru.cft.shift2021summer.data.CountryRepository

/** Класс-presenter для страницы деталей MVP **/

class CountryDetailsPresenter(
    private val repository: CountryRepository?,
    private val countryName: String
) : BasePresenter<CountryDetailsView>() {

    override fun onViewAttached() {
        val country = repository?.getCountry(countryName)

        if (country != null) {
            view?.bindCountry(country)
        } else {
            view?.closeScreen()
        }
    }
}