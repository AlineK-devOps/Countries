package ru.cft.shift2021summer.countries

import ru.cft.shift2021summer.countries.domain.model.*

object TestEntities {
    const val COUNTRY_ID = "name1"

    val COUNTRY_1 = CountryModel(
        name = "country1",
        topLevelDomain = listOf(".co1"),
        alpha2Code = "c1",
        alpha3Code = "co1",
        callingCodes = listOf("1"),
        capital = "capital1",
        altSpellings = listOf("spelling1"),
        region = "region1",
        subregion = "subregion1",
        population = 11111,
        latlng = listOf(1.0, 1.0),
        demonym = "demonym1",
        area = 1111.1,
        gini = 1.1,
        timezones = listOf("+1:00"),
        borders = listOf("boreder1"),
        nativeName = "nativeName1",
        numericCode = "1",
        currencies = listOf(CurrencyModel("code1", "name1", "symbol1")),
        languages = listOf(LanguageModel("11", "21", "name1", "nativeName1")),
        translations = CountryNameTranslationModel("de1", "es1", "fr1", "ja1", "it1", "br1", "pt1"),
        flag = "url1",
        regionalBlocs = listOf(RegionalBlockModel("acronym1", "name1", listOf("otherAcronym1"), listOf("otherName1"))),
        cioc = "cois1"
    )

    private val COUNTRY_2 = CountryModel(
        name = "country2",
        topLevelDomain = listOf(".co2"),
        alpha2Code = "c2",
        alpha3Code = "co2",
        callingCodes = listOf("2"),
        capital = "capital2",
        altSpellings = listOf("spelling2"),
        region = "region2",
        subregion = "subregion2",
        population = 22222,
        latlng = listOf(2.0, 2.0),
        demonym = "demonym2",
        area = 2222.2,
        gini = 2.2,
        timezones = listOf("+2:00"),
        borders = listOf("boreder2"),
        nativeName = "nativeName2",
        numericCode = "2",
        currencies = listOf(CurrencyModel("code2", "name2", "symbol2")),
        languages = listOf(LanguageModel("12", "22", "name2", "nativeName2")),
        translations = CountryNameTranslationModel("de2", "es2", "fr2", "ja2", "it2", "br2", "pt2"),
        flag = "url2",
        regionalBlocs = listOf(RegionalBlockModel("acronym2", "name2", listOf("otherAcronym2"), listOf("otherName2"))),
        cioc = "cois2"
    )

    val ALL_COUNTRIES = listOf(COUNTRY_1, COUNTRY_2)
}