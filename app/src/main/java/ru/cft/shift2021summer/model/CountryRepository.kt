package ru.cft.shift2021summer.model

import java.util.*

/** Репозиторий стран **/

class CountryRepository private constructor() { //Singleton
    companion object{
        private var repository: CountryRepository? = null

        fun getInstance(): CountryRepository?{
            if (repository == null)
                repository = CountryRepository()

            return repository
        }
    }

    private val countries = mutableListOf<CountryModel>()

    init{
        for (i in 1..20){ //тестовые данные
            val country = CountryModel("name$i", listOf("topLevelDomain$i", "topLevelDomain$i"),
                "alpha2Code$i", "alpha3Code$i", listOf("callingCodes$i", "callingCodes$i"),
                "capital$i", listOf("altSpellings$i", "altSpellings$i"), "region$i", "subregion$i",
                i, listOf(i * 1.0, i * 1.0), "demonym$i", i * 1.0, i * 1.0, listOf(TimeZone.getDefault()),
                listOf("borders$i", "borders$i"), "nativeName$i", "numericCode$i",
                listOf(CurrencyModel("code$i", "name$i", "symbol$i")),
                listOf(LanguageModel("iso639_1$i", "iso639_2$i", "name$i", "nativeName$i")),
                CountryNameTranslationModel("de$i", "es$i", "fr$i", "ja$i", "it$i", "br$i", "pt$i"), "flag$i",
                listOf(RegionalBlockModel("acronym$i", "name$i", listOf("otherAcronyms$i"), listOf("otherNames$i"))), "cios$i");

            countries.add(country);
        }
    }

    fun getAllCountries(): List<CountryModel> = countries

    fun getRepository() = countries

    fun getCountry(name: String): CountryModel? =
        countries.firstOrNull { it.name.equals(name, true) }
}