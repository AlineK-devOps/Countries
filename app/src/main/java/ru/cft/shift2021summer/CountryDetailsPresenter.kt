package ru.cft.shift2021summer

import ru.cft.shift2021summer.model.CountryRepository

/** Класс-presenter для страницы деталей MVP **/

class CountryDetailsPresenter(
    private val repository: CountryRepository?,
    private val countryName: String
) : BasePresenter<CountryDetailsView>() {

    override fun onViewAttached() {
        val country = repository?.getCountry(countryName)

        if (country != null) {
            view?.bindCountry(country)
        } else {
            view?.closeScreen()
        }
    }

    fun onSaveButtonClicked(character: Character) {
        /*repository.set(character)

        view?.closeScreen()*/
    }
}