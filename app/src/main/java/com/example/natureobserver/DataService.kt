package com.example.natureobserver

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataService {
    // Constant for SharedPreference-Name
    const val PREFERENCE_NAME = "ObservationsPreference"
    // Constant key where observationsObjectsList is stored in SharedPreference
    const val PREFERENCE_OBSERVATIONS_KEY = "observations"
    // ArrayList of Type Observation-Class holding all observations at runtime
    var observationsObjectsList: ArrayList<Observation> = ArrayList()
    // Variable to check if observationsObjectsList was already initialized
    var isInitalizedObservationsObjectsList = false

    // Type Definition for conversion from JSON to ArrayList<Observation> with GSON
    // EXAMPLE: Gson().fromJson<ArrayList<Observation>>(myJsonString, myType)
    // val myType = object : TypeToken<ArrayList<Observation>>() {}.type


    // Initialize observationsObjectsList from SharedPreferences/TestArray
    private fun initObservationsObjectsList(mySharedPreferences: SharedPreferences){
        if (isInitalizedObservationsObjectsList == false){
            Log.e("already initialized", isInitalizedObservationsObjectsList.toString())
            val mySharedPreferences = mySharedPreferences
            val observationsListJsonString = mySharedPreferences.getString(PREFERENCE_OBSERVATIONS_KEY, "")
            if (observationsListJsonString.isNullOrEmpty()) {   // Initialize with Testarray
                val observationTestArray = getObservationTestArray()
                observationsObjectsList.addAll(observationTestArray)
                isInitalizedObservationsObjectsList = true
                Log.e("DataService.observationsObjectsList", "observationTestArray assigned")
            } else {    // Initialize with SharedPreferences
                val myType = object : TypeToken<ArrayList<Observation>>() {}.type
                observationsObjectsList = Gson().fromJson<ArrayList<Observation>>(observationsListJsonString, myType)
                isInitalizedObservationsObjectsList = true
                Log.e("DataService.observationsObjectsList", "SharedPreference-values assigned")
            }
        }
    }

    // Create observation-objects and return observationTestArray
    private fun getObservationTestArray(): ArrayList<Observation>{
        var observationTestArray: ArrayList<Observation> = ArrayList()
        observationTestArray.add(Observation("Buntspecht", "12.02.2021", "Wienerberg", "Schöner Vogel"))
        observationTestArray.add(Observation("Spiegeleiqualle", "12.08.2019", "Creta", "Die schaut so lässig aus. Sie hat nur ein schwaches Nesselgift und ist für den Menschen harmlos."))
        observationTestArray.add(Observation("Rochen", "25.07.2018", "Gran Canaria", "Gut getarnt"))
        observationTestArray.add(Observation("Smaragdeidechse", "06.04.2021", "Perchtholdsdorf", "Wie die geflitzt ist"))
        observationTestArray.add(Observation("Hirschkäfer", "07.05.2019", "Kahlenberg", "Wow, rießiger Käfer mit seinem Geweih"))
        observationTestArray.add(Observation("Blindschleichen bei Paarung", "09.05.2021", "Schönwald bei Maria Gugging", "Brutal und ein bisschen verstörend der Anblick, dennoch interessant mal gesehen zu haben."))
        observationTestArray.add(Observation("Fasan", "08.05.2021", "Leopoldsdorf", "Im hohen Gras gesichtet"))
        observationTestArray.add(Observation("Europäische Sumpfschildkröte", "10.04.2021", "Lobau", "Bereits am Sonne tanken. Die Umgebungstemperatur der Eier bestimmt, ob sich aus diesen mehr Weibchen oder mehr Männchen entwickeln. Gefährdungsgrad: " +
                "vom Aussterben bedroht."))
        observationTestArray.add(Observation("Star nistet gegenüber", "25.05.2021", "Home", "Immer fleißig auf Futtersuche für die kleinen Mäuler"))
        observationTestArray.add(Observation("Stiglitz", "16.06.2021", "Home", "So tolle Farben bei genauerer Betrachtung"))
        return observationTestArray
    }

    // Write DataService.observationsObjectsList to SharedPreferences
    private fun updateSharedPreferences(mySharedPreferences: SharedPreferences){
        // Get SharedPreferences
        val mySharedPreferences = mySharedPreferences
        // Instantiate Editor for SharedPreferences
        val editor = mySharedPreferences.edit()
        // Convert observationsObjectsList to String
        val observationsListAsString = Gson().toJson(observationsObjectsList)
        // Write String to SharedPreferences
        editor.putString(PREFERENCE_OBSERVATIONS_KEY, observationsListAsString)
        editor.apply()
        Log.e("DataService.observationsObjectsList", "Saved to SharedPreferences")
    }


}