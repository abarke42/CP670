package com.example.androidassignments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import com.example.androidassignments.R.layout;

import org.jetbrains.annotations.Nullable;
public final class MainActivity extends ComponentActivity {
    private final String tag = "MainActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);

        Button main_button = findViewById(R.id.main_button);

        main_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //Switch to another activity
                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 10);
            }
        });
        //starts the ListItemsActivity activity using startActivityForResult( ). Use 10 for the request code.
    }

    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode, responseCode, data);
        if(requestCode == 10)
        {
            Log.i("ACTIVITY_NAME", "Returned to MainActivity.onActivityResult");
        }
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
