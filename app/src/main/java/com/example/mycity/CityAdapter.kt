package com.example.mycity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private val listCity: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent,
            false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, tahun, description, photo) = listCity[position]
        val context = holder.itemView.context
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val intentToDetail = Intent(context, DetailActivity::class.java)
            intentToDetail.putExtra(DetailActivity.EXTRA_NAME, name)
            intentToDetail.putExtra(DetailActivity.EXTRA_TAHUN, tahun)
            intentToDetail.putExtra(DetailActivity.EXTRA_DESCRIPTION, description)
            intentToDetail.putExtra(DetailActivity.EXTRA_PHOTO, photo)
            context.startActivity(intentToDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: City)
    }

    override fun getItemCount(): Int = listCity.size
}