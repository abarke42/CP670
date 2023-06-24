package com.example.androidassignments;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import com.example.androidassignments.R.layout;

import org.jetbrains.annotations.Nullable;
public final class MainActivity extends ComponentActivity {
    private final String tag = "MainActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Log.i(this.tag, "Started MainActivity.");
    }

    protected void onPause() {
        super.onPause();
        Log.i(this.tag, "Paused MainActivity.");
    }

    protected void onResume() {
        super.onResume();
        Log.i(this.tag, "Resumed MainActivity.");
    }

    protected void onStop() {
        super.onStop();
        Log.i(this.tag, "Stopped MainActivity.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.tag, "Destroyed MainActivity+.");
    }
}
