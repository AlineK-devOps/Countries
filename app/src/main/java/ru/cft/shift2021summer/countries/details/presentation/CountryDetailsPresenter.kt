package ru.cft.shift2021summer.countries.details.presentation

import ru.cft.shift2021summer.countries.base.BasePresenter
import ru.cft.shift2021summer.countries.details.domain.GetCountryUseCase

/** Класс-presenter для страницы деталей MVP **/

class CountryDetailsPresenter(
    private val getCountryUseCase: GetCountryUseCase,
    private val countryName: String
) : BasePresenter<CountryDetailsView>() {

    override fun onViewAttached() {
        val country = getCountryUseCase.invoke(countryName)

        if (country != null) {
            view?.bindCountry(country)
        } else {
            view?.closeScreen()
        }
    }
}