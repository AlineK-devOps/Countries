package ru.cft.shift2021summer.countries.domain.model

/** Модель страны, которая содержит информацию, приходящую с бекэнда **/

data class CountryModel(
    val name: String,                              //название страны на английском языке
    val topLevelDomain: List<String>,              //список доменов верхнего уровня
    val alpha2Code: String,                        //двухбуквенный код страны
    val alpha3Code: String,                        //трёхбуквенный код страны
    val callingCodes: List<String>,                //список телефонных кодов страны
    val capital: String,                           //столица
    val altSpellings: List<String>,                //список альтернативных названий страны
    val region: String,                            //регион
    val subregion: String,                         //субрегион
    val population: Int,                           //население
    val latlng: List<Double>,                      //координаты
    val demonym: String,                           //название коренного населения
    val area: Double,                              //площадь
    val gini: Double,                              //индекс Джини – это показатель распределения доходов среди населения
    val timezones: List<String>,                   //список часовых поясов
    val borders: List<String>,                     //список соседних государств
    val nativeName: String,                        //название страны на родном языке
    val numericCode: String,                       //код страны
    val currencies: List<CurrencyModel>,           //список государственных валют
    val languages: List<LanguageModel>,            //список государственных языков
    val translations: CountryNameTranslationModel, //переводы названия страны
    val flag: String? = null,                      //ссылка на флаг
    val regionalBlocs: List<RegionalBlockModel>,   //список региональных блоков
    val cioc: String                               //центральноамериканский общий рынок?
){
    fun getNameAndCapital(): String {
        return if (capital.isNotBlank()) capital
        else "None"
    }

    fun getShortInfo(): String{
        return String.format(
            "Native name: %s\n" + "Coordinates: %s\n" +
                    "Population: %d humans\n" + "Area: %.1f km^2\n" +
                    "Numeric code: %s", nativeName, latlng, population, area, numericCode)
    }

    override fun toString(): String {
        var info: String = String.format(
                    "Native name: %s\n\n" + "Coordinates: %s\n\n" +
                    "Population: %d humans\n\n" + "Area: %.1f km^2\n\n" + "Gini index: %.2f\n\n" +
                    "Numeric code: %s\n\n" + "Alpha-2 code: %s, alpha-3 code: %s\n\n", nativeName, latlng, population, area, gini, numericCode, alpha2Code, alpha3Code)

        if (region.isNotBlank()){
            info += String.format("Region: %s", region)
            if (subregion.isNotBlank())
                info += String.format(", subregion: %s", subregion)
        }
        else info += "Region: None"
        info += "\n\n"

        if (demonym.isNotBlank())
            info += String.format("Demonym: %s", demonym)
        else info += "Demonym: None"
        info += "\n\n"

        if (callingCodes.isNotEmpty())
            info += String.format("Calling codes: %s", callingCodes)
        else info += "Calling codes: None"
        info += "\n\n"

        if (timezones.isNotEmpty())
            info += String.format("Time zones: %s", timezones)
        else info += "Time zones: None"
        info += "\n\n"

        if (currencies.isNotEmpty())
            info += String.format("Currencies: %s", currencies)
        else info += "Currencies: None"
        info += "\n\n"

        if (languages.isNotEmpty())
            info += String.format("Languages: %s", languages)
        else info += "Languages: None"
        info += "\n\n"

        if (altSpellings.isNotEmpty())
            info += String.format("Alternative spellings: %s", altSpellings)
        else info += "Alternative spellings: None"
        info += "\n\n"

        if (translations.toString().isNotBlank())
            info += String.format("Translations: %s", translations)
        else info += "Translations None"
        info += "\n\n"

        if (borders.isNotEmpty())
            info += String.format("Borders: %s", borders)
        else info += "Borders None"
        info += "\n\n"

        if (regionalBlocs.isNotEmpty())
            info += String.format("Regional blocs: %s", regionalBlocs)
        else info += "Regional blocs: None"
        info += "\n\n"

        if (cioc.isNotBlank())
            info += String.format("Cioc: %s", cioc)
        else info += "Cioc: None"
        info += "\n\n"

        if (topLevelDomain.isNotEmpty())
            info += String.format("Top level domain: %s", topLevelDomain)
        else info += "Top level domain: None"

        return info
    }
}
