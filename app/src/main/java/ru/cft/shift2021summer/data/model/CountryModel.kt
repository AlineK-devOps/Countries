package ru.cft.shift2021summer.data.model

import java.util.*

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
    val latlng: List<Double>,                      //широта
    val demonym: String,                           //название коренного населения
    val area: Double,                              //площадь
    val gini: Double,                              //индекс Джини – это показатель распределения доходов среди населения
    val timezones: List<TimeZone>,                 //список часовых поясов
    val borders: List<String>,                     //список соседних государств
    val nativeName: String,                        //название страны на родном языке
    val numericCode: String,                       //код страны
    val currencies: List<CurrencyModel>,           //список государственных валют
    val languages: List<LanguageModel>,            //список государственных языков
    val translations: CountryNameTranslationModel, //переводы названия страны
    val flag: String,                              //ссылка на флаг
    val regionalBlocs: List<RegionalBlockModel>,   //список региональных блоков
    val cioc: String                               //центральноамериканский общий рынок?
)
