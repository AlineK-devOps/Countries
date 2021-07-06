package ru.cft.shift2021summer

import android.app.Application
import ru.cft.shift2021summer.testdata.CountryRepository

class WorldWideApplication : Application() {
    lateinit var countryRepository: CountryRepository

    override fun onCreate() {
        super.onCreate()
        countryRepository = CountryRepository()
    }
}