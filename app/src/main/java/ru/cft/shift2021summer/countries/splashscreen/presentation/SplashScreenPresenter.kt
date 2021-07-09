package ru.cft.shift2021summer.countries.splashscreen.presentation

import ru.cft.shift2021summer.countries.base.BasePresenter

/** Класс-presenter для заставки MVP **/

class SplashScreenPresenter : BasePresenter<SplashScreenView>() {

    override fun onViewAttached() {
        view?.bindSplashScreen()
    }
}