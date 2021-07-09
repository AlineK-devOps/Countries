package ru.cft.shift2021summer.countries.data

import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.model.*

/** Репозиторий стран **/

class CountryRepositoryImpl private constructor( //Singleton
    private val countriesLocalDatasource: CountriesLocalDatasource
): CountryRepository {
    companion object{
        private var repository: CountryRepositoryImpl? = null

        fun getInstance(): CountryRepositoryImpl{
            if (repository == null)
                repository = CountryRepositoryImpl(CountriesLocalDatasourceImpl())

            return repository as CountryRepositoryImpl
        }
    }

    override fun getAllCountries(): List<CountryModel> = countriesLocalDatasource.getAllCountries()

    override fun getCountry(name: String): CountryModel? =
        countriesLocalDatasource.getAllCountries().firstOrNull { it.name.equals(name, true) }
}