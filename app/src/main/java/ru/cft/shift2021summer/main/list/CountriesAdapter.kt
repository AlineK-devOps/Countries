package ru.cft.shift2021summer.adapters

//адаптер списка стран

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.data.model.CountryModel

class CountriesAdapter(private val onItemClick: (CountryModel) -> Unit) :
    RecyclerView.Adapter<CountryHolder>() {

    var countries: List<CountryModel> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = (LayoutInflater.from(parent.context))
            .inflate(R.layout.item_country, parent, false)
        return CountryHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = countries.size

}

class CountryHolder(
    view: View,
    private val onItemClick: (CountryModel) -> Unit)
    : RecyclerView.ViewHolder(view){

    private val nameText = view.findViewById<TextView>(R.id.nameText)
    private val capitalText = view.findViewById<TextView>(R.id.capitalText)

    fun bind(country: CountryModel){
        nameText.text = itemView.context.getString(R.string.name_country_format, country.name)
        capitalText.text = itemView.context.getString(R.string.capital_format, country.capital)
        itemView.setOnClickListener { onItemClick(country) }
    }
}