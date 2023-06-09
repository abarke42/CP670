package com.example.androidassignments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val tag = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "Started LoginActivity.")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "Paused LoginActivity.")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "Resumed LoginActivity.")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "Stopped LoginActivity.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "Destroyed LoginActivity.")
    }
}