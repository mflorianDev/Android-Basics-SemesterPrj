package com.example.natureobserver

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var mySharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate")

        // Get Data from SharedPreferences, convert to jsonObject and save result to Dataservice.observations
        mySharedPreferences = getSharedPreferences(DataService.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val observationsString: String? = mySharedPreferences.getString(DataService.PREFERENCE_OBSERVATIONS_KEY, "{}")
        DataService.observations = JSONObject(observationsString)
        var jsonObj = JSONObject()
        jsonObj.put("name", "Peter")
        jsonObj.put("id", 35)
        jsonObj.put("list", "[{'person': 'Hannes'},{'person': 'Caudia'}]")
        DataService.observations = jsonObj
        Log.e("SharedPreferences", "loaded")
        Log.e("Observations", DataService.observations.toString())


        newObservationBtn.setOnClickListener {
            val intent = Intent(this, NewObservationActivity::class.java)
            startActivity(intent)
            finish()
        }
        showAllObservationsBtn.setOnClickListener {
            val intent = Intent(this, ShowAllObservationsActivity::class.java)
            startActivity(intent)
            finish()
        }
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