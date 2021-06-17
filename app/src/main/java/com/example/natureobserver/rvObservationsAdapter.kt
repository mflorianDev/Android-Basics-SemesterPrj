package com.example.natureobserver

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RvObservationAdapter(private var observations: ArrayList<Observation>): RecyclerView.Adapter<RvObservationViewHolder>() {
    // Create your view holder here
    // This method is called as often as the count of views that fit in one screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvObservationViewHolder {
        val listItemRootView = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_view, parent, false)
        return RvObservationViewHolder(listItemRootView)
    }
    // Bind the "plain" data object to a viewholder at the given position
    // Be sure to reset/clean out every view since there might be data which is set already
    override fun onBindViewHolder(holder: RvObservationViewHolder, position: Int) {
        val item = observations[position]
        holder.rvTitle.text = item.title
        holder.rvDate.text = item.date
        holder.rvLocation.text = item.location
        holder.rvNotes.text = item.notes
    }
    // Returns the count of total items in the list
    override fun getItemCount() = observations.size
    // Use this to update the list and refresh the UI
    fun updateContacts(contacts: ArrayList<Observation>) {
        this.observations = observations
        notifyDataSetChanged()
    }
}