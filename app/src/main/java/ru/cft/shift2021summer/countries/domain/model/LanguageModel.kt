package ru.cft.shift2021summer.countries.domain.model

/** Модель государственного языка **/

data class LanguageModel(
    val iso639_1: String,  //двухбуквенный код языка
    val iso639_2: String,  //трёхбуквенный код языка
    val name: String,      //название на английском языке
    val nativeName: String //название на данном языке
)
{
    override fun toString(): String =
        "Name: $name, native name: $nativeName, ISO639-1: $iso639_1, ISO639-2: $iso639_2."
}
