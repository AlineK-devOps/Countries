package ru.cft.shift2021summer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.cft.shift2021summer.testdata.CountryRepository
import ru.cft.shift2021summer.testdata.CountrySimplified

class CountryDetailsActivity : AppCompatActivity() {
    companion object{
        private const val EXTRA_NAME = "EXTRA_NAME"

        fun start(context: Context, name: String){
            val intent = Intent(context, CountryDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
            }
            context.startActivity(intent)
        }
    }

    private lateinit var countriesRepository: CountryRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        countriesRepository = CountryRepository()
        val name = intent.getStringExtra(EXTRA_NAME)
        val country = name?.let { countriesRepository.getCountry(it) }

        val nameText = findViewById<TextView>(R.id.nameText)
        val infoText = findViewById<TextView>(R.id.infoText)

        nameText.text = getString(R.string.name_country_format,country?.name)
        infoText.text = getString(R.string.info_format,country?.capital)
    }
}