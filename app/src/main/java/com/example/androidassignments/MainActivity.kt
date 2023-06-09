package com.example.androidassignments

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

//Main activity to launch the app
class MainActivity : ComponentActivity() {

    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Calls activity_main.xml
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "Started MainActivity.")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "Paused MainActivity.")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "Resumed MainActivity.")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "Stopped MainActivity.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "Destroyed MainActivity.")
    }
}
