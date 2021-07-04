package ru.cft.shift2021summer.adapters

//адаптер списка стран

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.testdata.CountrySimplified

class CountriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

class CountryHolder(view: View) : RecyclerView.ViewHolder(view){
    fun bind(country: CountrySimplified){

    }
}