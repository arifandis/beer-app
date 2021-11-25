package com.example.testapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.VhBeerBinding
import com.example.testapp.model.Beer
import com.squareup.picasso.Picasso

class BeerAdapter(val context: Context, val beers: List<Beer>, val onClick: (Beer) -> Unit):
    RecyclerView.Adapter<BeerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.vh_beer, parent, false))
    }

    override fun onBindViewHolder(holder: BeerAdapter.ViewHolder, position: Int) {
        holder.bindData(beers[position])
    }

    override fun getItemCount(): Int = beers.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = VhBeerBinding.bind(view)

        fun bindData(beer: Beer) {
            Picasso.get().load(beer.image_url).into(binding.ivBeer)
            binding.tvName.text = beer.name
            binding.tvTagline.text = beer.tagline
            binding.tvDesc.text = beer.description
        }
    }
}