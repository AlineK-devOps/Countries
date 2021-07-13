package ru.cft.shift2021summer.countries.main.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.markushi.ui.CircleButton
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.adapters.CountriesAdapter
import ru.cft.shift2021summer.countries.details.presentation.CountryDetailsActivity
import ru.cft.shift2021summer.countries.domain.model.CountryModel
import ru.cft.shift2021summer.countries.data.CountryRepositoryImpl
import ru.cft.shift2021summer.countries.details.presentation.CountryDetailsPresenter
import ru.cft.shift2021summer.countries.filter.presentation.FilterActivity
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MainView {
    companion object{
        private const val EXTRA_NAME = "EXTRA_NAME3"

        fun start(context: Context, params: Array<String>){
            val intent = Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRA_NAME, params)
            }
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        MainPresenter(
            CountryRepositoryImpl.getInstance(),
            intent.getStringArrayExtra(EXTRA_NAME)
        )
    }

    private val adapter by lazy { CountriesAdapter (presenter::onCountryClicked) }

    private lateinit var countriesRecycler: RecyclerView

    private lateinit var shortInfoRandomCountry : TextView
    private lateinit var infoRandomCountry : TextView
    private lateinit var flagImg: ImageView
    private lateinit var searchView: SearchView
    private lateinit var filterButton: CircleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        countriesRecycler = findViewById(R.id.countriesRecycler)
        countriesRecycler.adapter = adapter

        shortInfoRandomCountry = findViewById(R.id.shortInfoRandomCountry)
        infoRandomCountry = findViewById(R.id.infoRandomCountry)
        flagImg = findViewById(R.id.flag)
        searchView = findViewById(R.id.searchView)

        filterButton = findViewById(R.id.filterButton)
        filterButton.setOnClickListener {
            presenter.onFilterButtonClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onScreenResumed()
    }

    override fun bindCountry(countries: List<CountryModel>){
        adapter.countries = countries
        initSearchView()
    }

    override fun bindRandomCountry(randomCountry: CountryModel) {
        shortInfoRandomCountry.text = getString(R.string.country_name_capital, randomCountry.name, randomCountry.capital)

        GlideToVectorYou
            .init()
            .with(this)
            .setPlaceHolder(R.drawable.flag_of_earth, R.drawable.flag_of_earth)
            .load(Uri.parse(randomCountry.flag), flagImg)

        infoRandomCountry.text = randomCountry.getShortInfo()
    }

    private fun initSearchView(){
        searchView.setOnQueryTextListener (object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filterAdapter =  CountriesAdapter (presenter::onCountryClicked)
                filterAdapter.countries = presenter.onSearchUsed(adapter.countries, newText)
                countriesRecycler.adapter = filterAdapter
                return true
            }
        })
    }

    override fun openFilterScreen() {
        FilterActivity.start(this)
    }

    override fun openDetailsScreen(countryName: String){
        CountryDetailsActivity.start(this, countryName)
    }
}