package ru.cft.shift2021summer

/** Класс-presenter для главной страницы MVP **/

import ru.cft.shift2021summer.model.CountryModel
import ru.cft.shift2021summer.model.CountryRepository

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