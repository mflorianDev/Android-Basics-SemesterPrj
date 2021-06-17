package com.example.natureobserver

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_new_observation.*
import kotlinx.android.synthetic.main.activity_show_all_observations.*
import kotlinx.android.synthetic.main.activity_show_all_observations.newObservationBackBtn
import org.json.JSONObject

class ShowAllObservationsActivity : AppCompatActivity() {

    private lateinit var mySharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_observations)
        Log.e("ShowAllObservationsActivity", "onCreate")

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

        // Create and add observation-objects to observationsObjectsList
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
        DataService.observationsObjectsList.addAll(observationTestArray)

        // RecyclerView
        val myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var myAdapter = RvObservationAdapter(DataService.observationsObjectsList)
        val divider = DividerItemDecoration(this, myLayoutManager.orientation)
        rvObservations.adapter = myAdapter
        rvObservations.layoutManager = myLayoutManager
        rvObservations.addItemDecoration(divider)

        // Return Button ClickListener
        newObservationBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Store data to Shared Preferences
        var context: Context = this
        val sharedPref = context.getSharedPreferences(
            "observations", Context.MODE_PRIVATE)?: return
        with (sharedPref.edit()) {
            putString("greeting", "Servus di Wadln")
            apply()
        }

        // Read data from Shared Preferences
        val storedString = sharedPref.getString("greeting", "defaultValue")
        Log.e("sharedPref", storedString.toString())

        // simple JSON
        var data = "{'name': 'Franz'}, {'radl': 'BMX'}"
        // JSONObject creates an object out of a JSON-String
        val dataJSON = JSONObject(data)
        // opt searches for matching 'name' and returns value or null
        val nameFromJson = dataJSON.optString("name")
        Log.e("JSON: ", nameFromJson)

    }

    override fun onStart() {
        super.onStart()
        Log.e("ShowAllObservationsActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ShowAllObservationsActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("ShowAllObservationsActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("ShowAllObservationsActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ShowAllObservationsActivity", "onDestroy")
    }
}