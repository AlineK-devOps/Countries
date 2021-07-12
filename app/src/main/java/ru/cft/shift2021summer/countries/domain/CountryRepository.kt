package ru.cft.shift2021summer.countries.domain

import io.reactivex.Single
import ru.cft.shift2021summer.countries.domain.model.CountryModel

interface CountryRepository {
    fun getAll(): Single<List<CountryModel>>

    fun get(name: String): Single<CountryModel>
}