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
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

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
    private lateinit var mapView: MapView
    private var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKeySingleton.initKey()
        MapKitFactory.initialize(this)

        setContentView(R.layout.activity_country_details)

        actionBar = supportActionBar
        nameText = findViewById(R.id.nameText)
        infoText = findViewById(R.id.infoText)
        flagImg = findViewById(R.id.flag)

        mapView = findViewById(R.id.mapView)

        presenter?.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
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

        if (country.latlng.isNotEmpty()){
            val zoom = when {
                country.area < 50000.0f -> 7.0f
                country.area < 100000.0f -> 6.0f
                country.area < 500000.0f -> 5.0f
                country.area < 2000000.0f -> 4.0f
                country.area < 5000000.0f -> 3.0f
                else -> 2.0f
            }

            mapView.map.move(
                CameraPosition(
                    Point(country.latlng[0], country.latlng[1]),
                    zoom,
                    0.0f,
                    0.0f),
                Animation(Animation.Type.SMOOTH, 0F),
                null)
        }
    }

    override fun closeScreen() {
        finish()
    }
}