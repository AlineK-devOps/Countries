package ru.cft.shift2021summer.countries.model

/** Модель государственного языка **/

data class LanguageModel(
    val iso639_1: String,  //двухбуквенный код языка
    val iso639_2: String,  //трёхбуквенный код языка
    val name: String,      //название на английском языке
    val nativeName: String //название на данном языке
)
