package ru.cft.shift2021summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.adapters.CountriesAdapter
import ru.cft.shift2021summer.testdata.CountryRepository

class MainActivity : AppCompatActivity() {
    private lateinit var countryRepository: CountryRepository
    private lateinit var countriesRecycler: RecyclerView
    private val adapter = CountriesAdapter {
        CountryDetailsActivity.start(this, it.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countriesRecycler = findViewById(R.id.countriesRecycler)
        countriesRecycler.adapter = adapter
        countriesRecycler.layoutManager = LinearLayoutManager(this)

        countryRepository = CountryRepository()
    }

    override fun onResume() {
        super.onResume()
        adapter.countries = countryRepository.getAllCountries()
    }
}