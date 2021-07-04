package ru.cft.shift2021summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.testdata.CountryRepository

class MainActivity : AppCompatActivity() {
    private lateinit var countryRepository: CountryRepository
    private lateinit var countriesRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countriesRecycler = findViewById(R.id.countriesRecycler)
        countryRepository = CountryRepository()

    }
}