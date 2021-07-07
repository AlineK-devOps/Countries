package ru.cft.shift2021summer.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.data.model.CountryModel
import ru.cft.shift2021summer.data.CountryRepository

class CountryDetailsActivity : AppCompatActivity(), CountryDetailsView {
    companion object{
        private const val EXTRA_NAME = "EXTRA_NAME"

        fun start(context: Context, name: String){
            val intent = Intent(context, CountryDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
            }
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        intent.getStringExtra(EXTRA_NAME)?.let {
            CountryDetailsPresenter(
                CountryRepository.getInstance(),
                it
            )
        }
    }

    private lateinit var nameText : TextView
    private lateinit var infoText : TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        nameText = findViewById<TextView>(R.id.nameText)
        infoText = findViewById<TextView>(R.id.infoText)
        backButton = findViewById<Button>(R.id.backButton)

        presenter?.attachView(this)
    }

    override fun bindCountry(country: CountryModel) {
        nameText.text = getString(R.string.name_country_format, country.name)
        infoText.text = getString(R.string.info_format, country)

        backButton.setOnClickListener { closeScreen() }
    }

    override fun closeScreen() {
        finish()
    }
}