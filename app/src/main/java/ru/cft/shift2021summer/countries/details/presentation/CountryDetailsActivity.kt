package ru.cft.shift2021summer.countries.details.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.countries.data.CountryRepositoryImpl
import ru.cft.shift2021summer.countries.domain.model.CountryModel


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
                CountryRepositoryImpl.getInstance(),
                it
            )
        }
    }

    private lateinit var nameText : TextView
    private lateinit var infoText : TextView
    private lateinit var backButton: Button
    private lateinit var flagImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        nameText = findViewById(R.id.nameText)
        infoText = findViewById(R.id.infoText)
        backButton = findViewById(R.id.backButton)
        flagImg = findViewById(R.id.flag)

        presenter?.attachView(this)
    }

    override fun bindCountry(country: CountryModel) {
        nameText.text = getString(R.string.country_name_capital, country.name, country.getNameAndCapital())

        infoText.text = getString(R.string.info_about_country, country)

        Picasso.with(this)
            .load(country.flag)
            .fit()
            .placeholder(R.drawable.flag_of_earth)
            .centerCrop()
            .into(flagImg)

        /*Glide.with(this)
            .load(country.flag)
            .into(flagImg)*/

        backButton.setOnClickListener { closeScreen() }
    }

    override fun closeScreen() {
        finish()
    }
}