package ru.cft.shift2021summer.countries.splashscreen.presentation

import ru.cft.shift2021summer.countries.base.BaseView

/** MVP контракт для SplashScreenActivity **/

interface SplashScreenView : BaseView {
    fun bindSplashScreen()
    fun closeScreen()
}