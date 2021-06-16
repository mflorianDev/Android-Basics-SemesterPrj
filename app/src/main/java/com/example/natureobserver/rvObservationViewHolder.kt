package com.example.natureobserver

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvObservationViewHolder (rootView: View): RecyclerView.ViewHolder(rootView) {
    val rvTitle: TextView
    val rvDate: TextView
    val rvLocation: TextView

    init {
        rvTitle = rootView.findViewById(R.id.rvTitle)
        rvDate = rootView.findViewById(R.id.rvDate)
        rvLocation = rootView.findViewById(R.id.rvLocation)
    }
}