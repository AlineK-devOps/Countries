package ru.cft.shift2021summer.countries.domain

import ru.cft.shift2021summer.countries.model.CountryModel

interface CountryRepository {
    fun getAllCountries(): List<CountryModel>

    fun getCountry(name: String): CountryModel?
}