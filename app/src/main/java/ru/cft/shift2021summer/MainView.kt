package ru.cft.shift2021summer

/** MVP контракт для MainActivity **/

import ru.cft.shift2021summer.model.CountryModel

interface MainView : BaseView{
    fun bindCountry(countries: List<CountryModel>)
    fun openDetailsScreen(countryName: String)
}