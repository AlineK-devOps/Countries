package ru.cft.shift2021summer.countries.main.domain

import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.model.CountryModel

class GetAllCountriesUseCase(
    private val countryRepository: CountryRepository
) {

    operator fun invoke(): List<CountryModel> =
        countryRepository.getAllCountries()

}