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
        return if (!capital.isNullOrBlank()) capital
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

        if (!region.isNullOrBlank()){
            info += String.format("Region: %s", region)
            if (!subregion.isNullOrBlank())
                info += String.format(", subregion: %s", subregion)
        }
        else info += "Region: None"
        info += "\n\n"

        info += if (!demonym.isNullOrBlank())
            String.format("Demonym: %s", demonym)
        else "Demonym: None"
        info += "\n\n"

        info += if (!callingCodes.isNullOrEmpty())
            String.format("Calling codes: %s", callingCodes)
        else "Calling codes: None"
        info += "\n\n"

        info += if (!timezones.isNullOrEmpty())
            String.format("Time zones: %s", timezones)
        else "Time zones: None"
        info += "\n\n"

        info += if (!currencies.isNullOrEmpty())
            String.format("Currencies: %s", currencies)
        else "Currencies: None"
        info += "\n\n"

        info += if (!languages.isNullOrEmpty())
            String.format("Languages: %s", languages)
        else "Languages: None"
        info += "\n\n"

        info += if (!altSpellings.isNullOrEmpty())
            String.format("Alternative spellings: %s", altSpellings)
        else "Alternative spellings: None"
        info += "\n\n"

        info += if (translations != null && translations.toString().isNotBlank())
            String.format("Translations: %s", translations)
        else "Translations None"
        info += "\n\n"

        info += if (!borders.isNullOrEmpty())
            String.format("Borders: %s", borders)
        else "Borders None"
        info += "\n\n"

        info += if (!regionalBlocs.isNullOrEmpty())
            String.format("Regional blocs: %s", regionalBlocs)
        else "Regional blocs: None"
        info += "\n\n"

        info += if (!cioc.isNullOrBlank())
            String.format("Cioc: %s", cioc)
        else "Cioc: None"
        info += "\n\n"

        info += if (!topLevelDomain.isNullOrEmpty())
            String.format("Top level domain: %s", topLevelDomain)
        else "Top level domain: None"

        return info
    }
}
