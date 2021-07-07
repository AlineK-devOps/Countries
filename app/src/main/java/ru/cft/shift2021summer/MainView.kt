package ru.cft.shift2021summer

import ru.cft.shift2021summer.activity.CountryDetailsActivity
import ru.cft.shift2021summer.model.CountryModel

interface MainView {
    fun bindCountry(countries: List<CountryModel>)
    fun openDetailsScreen(countryName: String)
}