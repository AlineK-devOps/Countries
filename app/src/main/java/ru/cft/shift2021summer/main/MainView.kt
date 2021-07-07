package ru.cft.shift2021summer.main

/** MVP контракт для MainActivity **/

import ru.cft.shift2021summer.base.BaseView
import ru.cft.shift2021summer.data.model.CountryModel

interface MainView : BaseView {
    fun bindCountry(countries: List<CountryModel>)
    fun openDetailsScreen(countryName: String)
}