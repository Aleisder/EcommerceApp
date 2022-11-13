package com.aleisder.ecommerceapp.presentation.store_screen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.aleisder.ecommerceapp.models.mainscreen.HomeStore
import com.bumptech.glide.Glide
import com.example.ecommerceapp.R

class HotSalesAdapter(
    private val hotSales: List<HomeStore>
) : RecyclerView.Adapter<HotSalesAdapter.HotSalesViewHolder>() {
    class HotSalesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val subtitle: TextView = view.findViewById(R.id.tv_subtitle)
        val picture: ImageView = view.findViewById(R.id.iv_picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        val adapterLayout =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.hot_sales_item, parent, false)
        return HotSalesViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        holder.apply {
            title.text = hotSales[position].title
            subtitle.text = hotSales[position].subtitle
            Glide.with(picture).load(hotSales[position].picture.toUri()).into(picture)
        }
    }

    override fun getItemCount() = hotSales.size
}