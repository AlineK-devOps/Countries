package ru.cft.shift2021summer.countries.domain.model

/** Модель названия страны на разных языках **/

data class CountryNameTranslationModel(
    val de: String, //немецкий
    val es: String, //испанский
    val fr: String, //французкий
    val ja: String, //японский
    val it: String, //итальянский
    val br: String, //бразильский
    val pt: String, //португальский
)
{
    override fun toString(): String =
        "DE: $de, ES: $es, FR: $fr, JA: $ja, IT: %it, BR: $br, PT: $pt."
}
