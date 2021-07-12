package ru.cft.shift2021summer.countries.main.presentation

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.adapters.CountriesAdapter
import ru.cft.shift2021summer.countries.details.presentation.CountryDetailsActivity
import ru.cft.shift2021summer.countries.domain.model.CountryModel
import ru.cft.shift2021summer.countries.data.CountryRepositoryImpl
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MainView {
    private val presenter by lazy { MainPresenter(CountryRepositoryImpl.getInstance()) }

    private val adapter by lazy { CountriesAdapter (presenter::onCountryClicked) }

    private lateinit var countriesRecycler: RecyclerView

    private lateinit var shortInfoRandomCountry : TextView
    private lateinit var infoRandomCountry : TextView
    private lateinit var flagImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        countriesRecycler = findViewById<RecyclerView>(R.id.countriesRecycler)
        countriesRecycler.adapter = adapter

        shortInfoRandomCountry = findViewById(R.id.shortInfoRandomCountry)
        infoRandomCountry = findViewById(R.id.infoRandomCountry)
        flagImg = findViewById(R.id.flag)
    }

    override fun onResume() {
        super.onResume()
        presenter.onScreenResumed()
    }

    override fun bindCountry(countries: List<CountryModel>){
        adapter.countries = countries

        val randomCountry: CountryModel = getRandomCountry(countries)

        shortInfoRandomCountry.text = getString(R.string.country_name_capital, randomCountry.name, randomCountry.capital)

        GlideToVectorYou
            .init()
            .with(this)
            .setPlaceHolder(R.drawable.flag_of_earth, R.drawable.flag_of_earth)
            .load(Uri.parse(randomCountry.flag), flagImg)

        infoRandomCountry.text = randomCountry.getShortInfo()
    }

    private fun getRandomCountry(countries: List<CountryModel>): CountryModel =
        countries[Random.nextInt(0, countries.size - 1)]

    override fun openDetailsScreen(countryName: String){
        CountryDetailsActivity.start(this, countryName)
    }
}