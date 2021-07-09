package ru.cft.shift2021summer.countries.main.presentation

/** Класс-presenter для главной страницы MVP **/

import ru.cft.shift2021summer.countries.base.BasePresenter
import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.main.domain.GetAllCountriesUseCase
import ru.cft.shift2021summer.countries.model.CountryModel

class MainPresenter(private val getAllCountriesUseCase: GetAllCountriesUseCase)
    : BasePresenter<MainView>() {
    fun onScreenResumed(){
        val countries = getAllCountriesUseCase.invoke()
        view?.bindCountry(countries)
    }

    fun onCountryClicked(country: CountryModel){
        view?.openDetailsScreen(country.name)
    }
}