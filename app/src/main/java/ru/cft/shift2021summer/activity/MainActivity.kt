package ru.cft.shift2021summer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.MainView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.activity.CountryDetailsActivity
import ru.cft.shift2021summer.adapters.CountriesAdapter
import ru.cft.shift2021summer.model.CountryModel
import ru.cft.shift2021summer.model.CountryRepository

class MainActivity : AppCompatActivity(), MainView {
    //private lateinit var countryRepository: CountryRepository

    private val adapter = CountriesAdapter {
        //CountryDetailsActivity.start(this, it.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countriesRecycler = findViewById<RecyclerView>(R.id.countriesRecycler)
        countriesRecycler.adapter = adapter
        countriesRecycler.layoutManager = LinearLayoutManager(this)

        //countryRepository = CountryRepository()
    }

    /*override fun onResume() {
        super.onResume()
        adapter.countries = countryRepository.getAllCountries()
    }*/

    override fun bindCountry(countries: List<CountryModel>){
        adapter.countries = countries
    }

    override fun openDetailsScreen(countryName: String){
        CountryDetailsActivity.start(this, countryName)
    }
}