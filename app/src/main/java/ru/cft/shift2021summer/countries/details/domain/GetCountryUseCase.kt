package ru.cft.shift2021summer.countries.details.domain

import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.model.CountryModel

class GetCountryUseCase(
    private val countryRepository: CountryRepository
) {

    operator fun invoke(name: String): CountryModel? =
        countryRepository.getCountry(name)

}