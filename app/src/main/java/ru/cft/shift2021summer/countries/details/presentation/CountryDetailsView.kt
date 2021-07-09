package ru.cft.shift2021summer.countries.details.presentation

import ru.cft.shift2021summer.countries.base.BaseView
import ru.cft.shift2021summer.countries.model.CountryModel

/** MVP контракт для CountryDetailsActivity **/

interface CountryDetailsView : BaseView {
    fun bindCountry(country: CountryModel)
    fun closeScreen()
}