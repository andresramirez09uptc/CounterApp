package com.example.counterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterTextView = findViewById<TextView>(R.id.counterTextView)

        val sharedPref = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        var counter = sharedPref.getInt("counter", 0)

        counter++

        counterTextView.text = counter.toString()

        with(sharedPref.edit()) {
            putInt("counter", counter)
            apply()
        }
    }
}