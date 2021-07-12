package ru.cft.shift2021summer.countries.domain.model

/** Модель государственной валюты **/

data class CurrencyModel(
    val code: String,  //код валюты
    val name: String,  //название валюты
    val symbol: String //знак валюты
)
{
    override fun toString(): String =
        "Name: $name, code: $code, symbol: $symbol."
}
