package com.example.natureobserver

class Observation(title: String, date: String, location: String, notes: String) {
    val title: String
    val date: String
    val location: String
    val notes: String

    init {
        this.title = title
        this.date = date
        this.location = location
        this.notes = notes
    }
}