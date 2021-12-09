package ru.cft.shift2021summer.countries.data

/** Источник данных **/

import io.reactivex.Single
import io.reactivex.SingleConverter
import io.reactivex.internal.operators.single.SingleCreate
import ru.cft.shift2021summer.countries.domain.model.*
import java.util.*

interface CountriesDatasource{
    fun getAll(): Single<List<CountryModel>>

    fun get(name: String): Single<CountryModel>
}

class CountriesDatasourceImpl(private val countryApi: CountryApi) : CountriesDatasource {
    private val countries = mutableListOf<CountryModel>()

    override fun getAll(): Single<List<CountryModel>> =
        countryApi.getAll()
            .map {
                it.body() ?: countries
            }

    override fun get(name: String): Single<CountryModel> =
        countryApi.get(name)
            .map {
                it.body()?.get(0) ?: countries[0]
            }

    init{
        for (i in 1..20){ //тестовые данные
            val country = CountryModel("name$i", listOf("topLevelDomain$i", "topLevelDomain$i"),
                "alpha2Code$i", "alpha3Code$i", listOf("callingCodes$i", "callingCodes$i"),
                "capital$i", listOf("altSpellings$i", "altSpellings$i"), "region$i", "subregion$i",
                i, listOf(i * 1.0, i * 1.0), "demonym$i", i * 1.0, i * 1.0, listOf("UTC-05:00"),
                listOf("borders$i", "borders$i"), "nativeName$i", "numericCode$i",
                listOf(CurrencyModel("code$i", "name$i", "symbol$i")),
                listOf(LanguageModel("iso639_1$i", "iso639_2$i", "name$i", "nativeName$i")),
                CountryNameTranslationModel("de$i", "es$i", "fr$i", "ja$i", "it$i", "br$i", "pt$i"), "flag$i",
                listOf(RegionalBlockModel("acronym$i", "name$i", listOf("otherAcronyms$i"), listOf("otherNames$i"))), "cios$i");

            countries.add(country);
        }
    }
}