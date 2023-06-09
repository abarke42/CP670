package com.example.androidassignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ListItemsActivity : AppCompatActivity() {
    private val tag = "ListItemsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "Started ListItemsActivity.")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "Paused ListItemsActivity.")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "Resumed ListItemsActivity.")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "Stopped ListItemsActivity.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "Destroyed ListItemsActivity.")
    }
}