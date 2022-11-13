package com.aleisder.ecommerceapp.presentation.store_screen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.aleisder.ecommerceapp.models.mainscreen.BestSeller
import com.bumptech.glide.Glide
import com.example.ecommerceapp.R

class BestSellerAdapter(
    private val bestSellers: List<BestSeller>
) : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {

    class BestSellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val priceWithDiscount: TextView = view.findViewById(R.id.tv_price_with_discount)
        val fullPrice: TextView = view.findViewById(R.id.tv_price_without_discount)
        val picture: ImageView = view.findViewById(R.id.iv_phone_picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(
            R.layout.best_seller_item, parent, false)
        return BestSellerViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.apply {
            title.text = bestSellers[position].title
            priceWithDiscount.text = bestSellers[position].discount_price.toString()
            fullPrice.text = bestSellers[position].price_without_discount.toString()
            Glide.with(picture).load(bestSellers[position].picture.toUri()).into(picture)
        }
    }

    override fun getItemCount() = bestSellers.size
}