package ru.cft.shift2021summer

/** Класс-presenter для заставки MVP **/

class SplashScreenPresenter : BasePresenter<SplashScreenView>() {

    override fun onViewAttached() {
        view?.bindSplashScreen()
    }
}