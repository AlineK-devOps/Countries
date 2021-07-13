package ru.cft.shift2021summer.countries.main.presentation

/** MVP контракт для MainActivity **/

import ru.cft.shift2021summer.countries.base.BaseView
import ru.cft.shift2021summer.countries.domain.model.CountryModel

interface MainView : BaseView {
    fun bindCountry(countries: List<CountryModel>)
    fun bindRandomCountry(randomCountry: CountryModel)
    fun openFilterScreen()
    fun openDetailsScreen(countryName: String)
}