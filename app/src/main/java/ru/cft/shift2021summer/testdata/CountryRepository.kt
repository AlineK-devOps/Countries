package ru.cft.shift2021summer.testdata

//тестовые данные для списка стран

class CountryRepository {
    private val countries = mutableListOf<CountrySimplified>(
        CountrySimplified(
          name = "Russia",
          capital = "Moscow",
          population = 146_238_185,
          area = 17_125_191.0
        ),

        CountrySimplified(
            name = "Canada",
            capital = "Ottawa",
            population = 38_048_738,
            area = 9_984_670.0
        ),

        CountrySimplified(
            name = "USA",
            capital = "Washington",
            population = 331_449_281,
            area = 3_796_742.0
        ),

        CountrySimplified(
            name = "France",
            capital = "Paris",
            population = 67_413_000,
            area = 640_679.0
        ),

        CountrySimplified(
            name = "Mexico",
            capital = "Mexico City",
            population = 126_014_024,
            area = 1_972_550.0
        ),

        CountrySimplified(
            name = "Germany",
            capital = "Berlin",
            population = 83_190_556,
            area = 357_022.0
        ),

        CountrySimplified(
            name = "Netherlands",
            capital = "Amsterdam",
            population = 17_611_300,
            area = 41_865.0
        ),

        CountrySimplified(
            name = "Italy",
            capital = "Rome",
            population = 60_317_116,
            area = 301_340.0
        ),

        CountrySimplified(
            name = "Ukraine",
            capital = "Kyiv",
            population = 41_442_615,
            area = 603_628.0
        ),

        CountrySimplified(
            name = "Norway",
            capital = "Oslo",
            population = 5_391_369,
            area = 385_207.0
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