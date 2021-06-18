package com.example.natureobserver

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate")

        // Remove Status Bar
        if (Build.VERSION.SDK_INT < 30) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        } else {
            window.setDecorFitsSystemWindows(false)
            val controller = window.insetsController
            if (controller != null) {
                controller.hide(WindowInsets.Type.statusBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }

        // Initialize observationsObjectsList from SharedPreferences/TestArray
        initObservationsObjectsList()

        // Navigation to NewObservationActivity
        newObservationBtn.setOnClickListener {
            val intent = Intent(this, NewObservationActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Navigation to ShowAllObservationsActivity
        showAllObservationsBtn.setOnClickListener {
            val intent = Intent(this, ShowAllObservationsActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    // Initialize observationsObjectsList from SharedPreferences/TestArray
    private fun initObservationsObjectsList(){
        if (DataService.isInitalizedObservationsObjectsList == false){
            Log.e("already initialized", DataService.isInitalizedObservationsObjectsList.toString())
            val mySharedPreferences = getSharedPreferences(DataService.PREFERENCE_NAME, Context.MODE_PRIVATE)
            val observationsListJsonString = mySharedPreferences.getString(DataService.PREFERENCE_OBSERVATIONS_KEY, "")
            if (observationsListJsonString.isNullOrEmpty()) {   // Initialize with Testarray
                val observationTestArray = getObservationTestArray()
                DataService.observationsObjectsList.addAll(observationTestArray)
                DataService.isInitalizedObservationsObjectsList = true
                Log.e("DataService.observationsObjectsList", "observationTestArray assigned")
            } else {    // Initialize with SharedPreferences
                val myType = object : TypeToken<ArrayList<Observation>>() {}.type
                DataService.observationsObjectsList = Gson().fromJson<ArrayList<Observation>>(observationsListJsonString, myType)
                DataService.isInitalizedObservationsObjectsList = true
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

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy")
    }
}