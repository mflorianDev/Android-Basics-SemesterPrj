package com.example.natureobserver

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext

class ShowAllObservationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_observations)
        Log.e("ShowAllObservationsActivity", "onCreate")

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

        storedString.
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