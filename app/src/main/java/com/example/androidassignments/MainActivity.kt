package com.example.androidassignments

import android.os.Bundle
import androidx.activity.ComponentActivity

//Main activity to launch the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Calls activity_main.xml
        setContentView(R.layout.activity_main)
    }
}
