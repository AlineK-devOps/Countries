package ru.cft.shift2021summer.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.model.CountryRepository

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

        nameText.text = getString(R.string.name_country_format, country?.name)
        infoText.text = getString(R.string.info_format, country)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener { finish() }
    }
}