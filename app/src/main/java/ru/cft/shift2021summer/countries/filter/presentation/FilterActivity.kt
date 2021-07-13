package ru.cft.shift2021summer.countries.filter.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.countries.data.CountryRepositoryImpl
import ru.cft.shift2021summer.countries.details.presentation.CountryDetailsActivity
import ru.cft.shift2021summer.countries.main.presentation.MainPresenter

class FilterActivity : AppCompatActivity(), FilterView {
    private val presenter by lazy { FilterPresenter() }

    companion object{
        fun start(context: Context){
            val intent = Intent(context, FilterActivity::class.java).apply{}
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
    }

    override fun onResume() {
        super.onResume()
        presenter.onScreenResumed()
    }

    override fun bindFilter() {
        TODO("Not yet implemented")
    }

    override fun getFilterParams() {
        TODO("Not yet implemented")
    }

    override fun closeScreen() {
        finish()
    }
}