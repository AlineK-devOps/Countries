package ru.cft.shift2021summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.cft.shift2021summer.testdata.CountrySimplified

class CountryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val nameText = findViewById<TextView>(R.id.nameText)
        val infoText = findViewById<TextView>(R.id.infoText)

        val country = CountrySimplified("Russia", "Moscow")

        nameText.text = getString(R.string.name_country_format,country.name)
        infoText.text = getString(R.string.info_format,country.capital)
    }
}