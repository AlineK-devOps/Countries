package ru.cft.shift2021summer.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.adapters.CountriesAdapter
import ru.cft.shift2021summer.details.CountryDetailsActivity
import ru.cft.shift2021summer.data.model.CountryModel
import ru.cft.shift2021summer.data.CountryRepository

class MainActivity : AppCompatActivity(), MainView {
    private val presenter by lazy { MainPresenter(CountryRepository.getInstance()) }

    private val adapter by lazy { CountriesAdapter (presenter::onCountryClicked) }

    private lateinit var countriesRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        countriesRecycler = findViewById<RecyclerView>(R.id.countriesRecycler)
        countriesRecycler.adapter = adapter
        countriesRecycler.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onScreenResumed()
    }

    override fun bindCountry(countries: List<CountryModel>){
        adapter.countries = countries
    }

    override fun openDetailsScreen(countryName: String){
        CountryDetailsActivity.start(this, countryName)
    }
}