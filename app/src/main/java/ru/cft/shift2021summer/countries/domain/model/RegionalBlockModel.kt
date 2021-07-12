package ru.cft.shift2021summer.countries.domain.model

/** Модель регионального блока **/

data class RegionalBlockModel(
    val acronym: String,             //аббревиатура
    val name: String,                //название блока
    val otherAcronyms: List<String>, //прочие аббревиатуры
    val otherNames: List<String>     //прочие названия блока
){
    override fun toString(): String {
        var info : String = "Name: $name, acronym: $acronym"
        val temp = "None"

        if (otherNames.isNotEmpty())
            info += ", other names: $otherNames"
        else
            info += ", other names: $temp"

        if (otherAcronyms.isNotEmpty())
            info += ", other names: $otherNames"
        else
            info += ", other names: $temp"

        return info
    }
}
