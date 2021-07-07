package ru.cft.shift2021summer

import ru.cft.shift2021summer.model.CountryModel

/** MVP контракт для CountryDetailsActivity **/

interface CountryDetailsView : BaseView {
    fun bindCountry(country: CountryModel)
    fun closeScreen()
}