package com.example.androidassignments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.androidassignments.R.layout;

import org.jetbrains.annotations.Nullable;

public final class ListItemsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private final String tag = "ListItemsActivity";
    Switch list_switch;
    private boolean isChecked;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_list_items);

        //Switch business
        list_switch=findViewById(R.id.list_items_switch);
        list_switch.setOnCheckedChangeListener(this);
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

    //Required to use onCheckedChanges instead of setOnCheckedChanges to implement the CompoundButton class
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked)    //Switch is on
        {
            CharSequence text = "Switch is On";// "Switch is Off"
            int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

            Toast toast = Toast.makeText(this, text, duration); //this is the ListActivity
            toast.show(); //display your message box
        }
        else    //Switch is off
        {
            CharSequence text = "Switch is Off";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }
}
