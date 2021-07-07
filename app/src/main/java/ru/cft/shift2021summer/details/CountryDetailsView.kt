package ru.cft.shift2021summer.details

import ru.cft.shift2021summer.base.BaseView
import ru.cft.shift2021summer.data.model.CountryModel

/** MVP контракт для CountryDetailsActivity **/

interface CountryDetailsView : BaseView {
    fun bindCountry(country: CountryModel)
    fun closeScreen()
}