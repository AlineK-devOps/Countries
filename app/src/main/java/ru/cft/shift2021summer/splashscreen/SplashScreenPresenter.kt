package ru.cft.shift2021summer.splashscreen

import ru.cft.shift2021summer.base.BasePresenter

/** Класс-presenter для заставки MVP **/

class SplashScreenPresenter : BasePresenter<SplashScreenView>() {

    override fun onViewAttached() {
        view?.bindSplashScreen()
    }
}