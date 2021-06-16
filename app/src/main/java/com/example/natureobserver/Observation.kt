package com.example.natureobserver

import java.util.*


class Observation (title: String, date: Date, location: String, notes: String) {
    val title: String
    val date: Date
    val location: String
    val notes: String

    init {
        this.title = title
        this.date = date
        this.location = location
        this.notes = notes
    }
}