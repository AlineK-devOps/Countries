package ru.cft.shift2021summer.countries.details.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

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
    private lateinit var flagImg: ImageView
    private var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        actionBar = supportActionBar
        nameText = findViewById(R.id.nameText)
        infoText = findViewById(R.id.infoText)
        flagImg = findViewById(R.id.flag)

        presenter?.attachView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                presenter?.onBackButtonClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun bindCountry(country: CountryModel) {
        actionBar?.title = ""

        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        nameText.text = getString(R.string.country_name_capital, country.name, country.getNameAndCapital())

        infoText.text = getString(R.string.info_about_country, country)

        GlideToVectorYou
            .init()
            .with(this)
            .setPlaceHolder(R.drawable.flag_of_earth, R.drawable.flag_of_earth)
            .load(Uri.parse(country.flag), flagImg)
    }

    override fun closeScreen() {
        finish()
    }
}