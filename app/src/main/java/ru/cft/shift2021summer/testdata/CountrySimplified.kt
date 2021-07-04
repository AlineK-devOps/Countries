package ru.cft.shift2021summer.testdata

//упрощенный класс страны

data class CountrySimplified(
    val name: String,    //название страны
    val capital: String, //столица
    val population: Int, //население
    val area: Double,    //площадь
)