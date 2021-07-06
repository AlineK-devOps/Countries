package ru.cft.shift2021summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.cft.shift2021summer.testdata.CountryRepository
import ru.cft.shift2021summer.testdata.CountrySimplified

class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var countriesRepository: CountryRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        countriesRepository = (application as WorldWideApplication).countryRepository
        val country = countriesRepository.getCountry("Russia")

        val nameText = findViewById<TextView>(R.id.nameText)
        val infoText = findViewById<TextView>(R.id.infoText)

        nameText.text = getString(R.string.name_country_format,country?.name)
        infoText.text = getString(R.string.info_format,country?.capital)
    }
}