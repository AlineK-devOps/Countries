package ru.cft.shift2021summer

import ru.cft.shift2021summer.model.CountryModel

/** MVP контракт для SplashScreenActivity **/

interface SplashScreenView : BaseView{
    fun bindSplashScreen()
    fun closeScreen()
}