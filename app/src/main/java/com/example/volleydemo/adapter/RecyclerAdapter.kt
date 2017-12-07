package com.example.volleydemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.volleydemo.R
import com.example.volleydemo.data.Hit
import kotlinx.android.synthetic.main.row_adapter.view.*

class RecyclerAdapter(private val hitsList: List<Hit>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return hitsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_adapter, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(hitsList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(hitItem: Hit) = with(itemView) {
            Glide.with(itemView.context)
                    .load(hitItem.webformatURL)
                    .into(ivPhoto)

            tvName.text = hitItem.user
        }
    }
}