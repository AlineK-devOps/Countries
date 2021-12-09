package ru.cft.shift2021summer.countries.domain.model

/** Модель регионального блока **/

data class RegionalBlockModel(
    val acronym: String,             //аббревиатура
    val name: String,                //название блока
    val otherAcronyms: List<String>, //прочие аббревиатуры
    val otherNames: List<String>     //прочие названия блока
){
    override fun toString(): String {
        var info = "Name: $name, acronym: $acronym"
        val temp = "None"

        info += if (!otherNames.isNullOrEmpty())
            ", other names: $otherNames"
        else
            ", other names: $temp"

        info += if (!otherAcronyms.isNullOrEmpty())
            ", other acronyms: $otherNames"
        else
            ", other acronyms: $temp"

        return info
    }
}
