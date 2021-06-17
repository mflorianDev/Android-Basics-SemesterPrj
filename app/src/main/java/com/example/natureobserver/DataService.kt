package com.example.natureobserver

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object DataService {
    // Constant for SharedPreference-Name
    const val PREFERENCE_NAME = "ObservationsPreference"
    // Constant key where observationsObjectsList is stored in SharedPreference
    const val PREFERENCE_OBSERVATIONS_KEY = "observations"
    // ArrayList of Type Observation-Class holding all observations at runtime
    var observationsObjectsList: ArrayList<Observation> = ArrayList()

    var isInitalizedObservationsObjectsList = false

    // Type Definition for conversion from JSON to ArrayList<Observation> with GSON
    // EXAMPLE: Gson().fromJson<ArrayList<Observation>>(myJsonString, myType)
    // val myType = object : TypeToken<ArrayList<Observation>>() {}.type

}