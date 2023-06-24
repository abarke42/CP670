package com.example.androidassignments;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidassignments.R.layout;

import org.jetbrains.annotations.Nullable;

public final class ListItemsActivity extends AppCompatActivity {
    private final String tag = "ListItemsActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_list_items);
    }

    protected void onStart() {
        super.onStart();
        Log.i(this.tag, "Started ListItemsActivity.");
    }

    protected void onPause() {
        super.onPause();
        Log.i(this.tag, "Paused ListItemsActivity.");
    }

    protected void onResume() {
        super.onResume();
        Log.i(this.tag, "Resumed ListItemsActivity.");
    }

    protected void onStop() {
        super.onStop();
        Log.i(this.tag, "Stopped ListItemsActivity.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.tag, "Destroyed ListItemsActivity.");
    }
}
