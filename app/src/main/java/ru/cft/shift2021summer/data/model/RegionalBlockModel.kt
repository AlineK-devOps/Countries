package ru.cft.shift2021summer.data.model

/** Модель регионального блока **/

data class RegionalBlockModel(
    val acronym: String,             //аббревиатура
    val name: String,                //название блока
    val otherAcronyms: List<String>, //прочие аббревиатуры
    val otherNames: List<String>     //прочие названия блока
)
