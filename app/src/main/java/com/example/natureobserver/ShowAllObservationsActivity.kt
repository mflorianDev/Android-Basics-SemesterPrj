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
        observationTestArray.add(Observation("Braunbär", "06.02.2020", "Lungau", "Was für ein Erlebnis"))
        observationTestArray.add(Observation("Rochen", "25.07.2020", "La Palma", "Gut getarnt"))
        observationTestArray.add(Observation("Smaragdeidechse", "06.04.2021", "Perchtholdsdorf", "Wie die geflitzt ist"))
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