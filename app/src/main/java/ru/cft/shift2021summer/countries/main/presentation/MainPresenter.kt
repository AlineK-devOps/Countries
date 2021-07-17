package ru.cft.shift2021summer.countries.main.presentation

/** Класс-presenter для главной страницы MVP **/

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import ru.cft.shift2021summer.countries.base.BasePresenter
import ru.cft.shift2021summer.countries.domain.CountryRepository
import ru.cft.shift2021summer.countries.domain.model.CountryModel
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class  MainPresenter(
    private val repository: CountryRepository,
    private val params: Array<String>? = null
    )
    : BasePresenter<MainView>() {

    fun onScreenResumed(){
        val disposable = repository.getAll()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {

                    if (params != null && params.isNotEmpty()){
                        var filteredCountries: MutableList<CountryModel> = mutableListOf()
                        var regions: MutableList<String> = mutableListOf()
                        var regionalBlocks: MutableList<String> = mutableListOf()

                        for (str in params){
                            val list: List<String> = str.split("-")
                            if (list[0] == "region")
                                regions.add(list[1].lowercase())
                            else
                                regionalBlocks.add(list[1].lowercase())
                        }

                        for (country in it){
                            var isCorrectRegion = false
                            var isCorrectBlock = false

                            if (regions.isNotEmpty()){
                                if (regions.contains("all") || regions.contains(country.region.lowercase())){
                                    isCorrectRegion = true
                                }
                            }
                            else isCorrectRegion = true

                            if (regionalBlocks.isNotEmpty()){
                                for (block in country.regionalBlocs){
                                    if (regionalBlocks.contains("all") || regionalBlocks.contains(block.acronym.lowercase())){
                                        isCorrectBlock = true
                                        break
                                    }
                                }
                            }
                            else isCorrectBlock = true

                            if (isCorrectRegion && isCorrectBlock)
                                filteredCountries.add(country)
                        }
                        view?.bindCountry(filteredCountries)
                    }
                    else view?.bindCountry(it)

                    view?.bindRandomCountry(it[Random.nextInt(0, it.size - 1)])
                },
            )
        compositeDisposable.add(disposable)
    }

    fun onSearchUsed(countries: List<CountryModel>, text: String): List<CountryModel>{
        var filteredCountries: ArrayList<CountryModel> = ArrayList()

        for (country in countries){
            if (country.name.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault())))
                filteredCountries.add(country)
        }
        return filteredCountries
    }

    fun onFilterButtonClicked(){
        view?.openFilterScreen()
    }

    fun onCountryClicked(country: CountryModel){
        view?.openDetailsScreen(country.name)
    }
}