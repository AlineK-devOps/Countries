package ru.cft.shift2021summer.splashscreen

import ru.cft.shift2021summer.base.BaseView

/** MVP контракт для SplashScreenActivity **/

interface SplashScreenView : BaseView {
    fun bindSplashScreen()
    fun closeScreen()
}