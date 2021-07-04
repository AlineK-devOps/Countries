package ru.cft.shift2021summer.model

/** Модель государственной валюты **/

data class CurrencyModel(
    val code: String,  //код валюты
    val name: String,  //название валюты
    val symbol: String //знак валюты
)
