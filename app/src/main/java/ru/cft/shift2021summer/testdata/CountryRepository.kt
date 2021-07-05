package ru.cft.shift2021summer.testdata

//тестовые данные для списка стран

class CountryRepository {
    private val countries = mutableListOf<CountrySimplified>(
        CountrySimplified(
          name = "Russia",
          capital = "Moscow",
        ),

        CountrySimplified(
            name = "Canada",
            capital = "Ottawa",
        ),

        CountrySimplified(
            name = "USA",
            capital = "Washington",
        ),

        CountrySimplified(
            name = "France",
            capital = "Paris",
        ),

        CountrySimplified(
            name = "Mexico",
            capital = "Mexico City",
        ),

        CountrySimplified(
            name = "Germany",
            capital = "Berlin",
        ),

        CountrySimplified(
            name = "Netherlands",
            capital = "Amsterdam",
        ),

        CountrySimplified(
            name = "Italy",
            capital = "Rome",
        ),

        CountrySimplified(
            name = "Ukraine",
            capital = "Kyiv",
        ),

        CountrySimplified(
            name = "Norway",
            capital = "Oslo",
        )
    )

    fun getAllCountries(): List<CountrySimplified> = countries

    fun setCountry(country: CountrySimplified){
        val index = countries.indexOfFirst { it.name.equals(country.name, true) }
        countries[index] = country
    }

    fun getCountry(name: String): CountrySimplified? =
        countries.firstOrNull { it.name.equals(name, true) }
}