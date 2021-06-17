package com.example.natureobserver

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new_observation.*
import java.util.*

class NewObservationActivity : AppCompatActivity(), View.OnClickListener {

    private var calendar = Calendar.getInstance()
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_observation)
        Log.e("NewObservationActivity", "onCreate")

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

        // DatePicker-Listener
        dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }
        etDate.setOnClickListener(this)

        // Save new observation
        newObservationSaveBtn.setOnClickListener {
            val observation = Observation(etTitle.text.toString(), etDate.text.toString(), etLocation.text.toString(), etNotes.text.toString())
            DataService.observationsObjectsList.add(observation)
            Toast.makeText(this, getString(R.string.savedToast), Toast.LENGTH_SHORT).show()
            etTitle.setText("")
            etDate.setText("")
            etLocation.setText("")
            etNotes.setText("")
        }

        // Return to home-screen
        newObservationBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Share new observation as text
        newObservationShareBtn.setOnClickListener {
            val textToShare =
                getString(R.string.newObservationTitle) + ": \n" + etTitle.text.toString() + "\n" +
                getString(R.string.newObservationDate) + ": \n" + etDate.text.toString() + "\n" +
                getString(R.string.newObservationLocation) + ": \n" + etLocation.text.toString() + "\n" +
                getString(R.string.newObservationNotes) + ": \n" + etNotes.text.toString()
            var intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, textToShare)
            intent.type = "text/plain"
            var chooserIntent = Intent.createChooser(intent, "Observation")
            startActivity(chooserIntent)
        }

        // Intent-Filter Send: get text from incoming intent and hand over to notes-edittextview
        var incomingIntentText = intent.getStringExtra(Intent.EXTRA_TEXT)
        etNotes.setText(incomingIntentText)

    }

    // Set text in view for date in specified format
    private fun updateDateInView(){
        val myFormat = "dd.MM.yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        etDate.setText(sdf.format(calendar.time).toString())
    }

    override fun onClick(v: View?) {
        when (v!!.id){
            R.id.etDate -> {
                DatePickerDialog(this@NewObservationActivity, dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
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