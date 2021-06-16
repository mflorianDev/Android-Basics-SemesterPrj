package com.example.natureobserver

import android.content.Context
import org.json.JSONObject

object DataService {

    val PREFERENCE_NAME = "ObservationsPreference"
    val PREFERENCE_OBSERVATIONS_KEY = "observations"
    lateinit var observations: JSONObject

    var observationsObjectsList: ArrayList<Observation> = ArrayList()


}