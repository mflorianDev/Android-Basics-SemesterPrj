package com.example.natureobserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NewObservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_observation)
        Log.e("NewObservationActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("NewObservationActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("NewObservationActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("NewObservationActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("NewObservationActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("NewObservationActivity", "onDestroy")
    }

}