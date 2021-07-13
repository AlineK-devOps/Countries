package ru.cft.shift2021summer.countries.filter.presentation

import ru.cft.shift2021summer.countries.base.BaseView

/** MVP контракт для FilterActivity**/

interface FilterView : BaseView{
    fun bindFilter()
    fun getFilterParams()
    fun closeScreen()
}