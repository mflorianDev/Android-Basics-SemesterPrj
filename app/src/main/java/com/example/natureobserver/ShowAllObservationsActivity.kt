package com.example.natureobserver

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_show_all_observations.*
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

        // RecyclerView
        rvObservations.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var observationsAdapter = rvObservationsAdapter(DataService.observationsObjectsList, this)
        rvObservations.adapter = observationsAdapter

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