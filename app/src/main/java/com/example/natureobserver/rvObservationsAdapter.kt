package com.example.natureobserver

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item_view.view.*

class rvObservationsAdapter (val items: ArrayList<Observation>, val context: Context): RecyclerView.Adapter<rvObservationsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): rvObservationsAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_item_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: rvObservationsAdapter.ViewHolder, position: Int) {
        val model: Observation = items[position]
        holder.tvItem.text = model.title.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItem = view.tvItem!!
    }
}