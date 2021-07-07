package ru.cft.shift2021summer.main

/** Класс-presenter для главной страницы MVP **/

import ru.cft.shift2021summer.base.BasePresenter
import ru.cft.shift2021summer.data.model.CountryModel
import ru.cft.shift2021summer.data.CountryRepository

class MainPresenter(private val repository: CountryRepository?) : BasePresenter<MainView>() {
    fun onScreenResumed(){
        val countries = repository?.getAllCountries()
        if (countries != null) {
            view?.bindCountry(countries)
        }
    }

    fun onCountryClicked(country: CountryModel){
        view?.openDetailsScreen(country.name)
    }
}