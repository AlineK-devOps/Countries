package ru.cft.shift2021summer.adapters

//адаптер списка стран

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.testdata.CountrySimplified

class CountriesAdapter : RecyclerView.Adapter<CountryHolder>() {
    var countries: List<CountrySimplified> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = (LayoutInflater.from(parent.context))
            .inflate(R.layout.item_country, parent, false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = countries.size

}

class CountryHolder(view: View) : RecyclerView.ViewHolder(view){
    private val nameText = view.findViewById<TextView>(R.id.nameText)
    private val capitalText = view.findViewById<TextView>(R.id.capitalText)
    private val popAreaText = view.findViewById<TextView>(R.id.popAreaText)

    fun bind(country: CountrySimplified){
        nameText.text = itemView.context.getString(R.string.name_country_format, country.name)
        capitalText.text = itemView.context.getString(R.string.capital_format, country.capital)
        popAreaText.text = itemView.context.getString(R.string.pop_area_format, country.population, country.area)
    }
}