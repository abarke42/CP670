package com.example.androidassignments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidassignments.R.layout;

import org.jetbrains.annotations.Nullable;

public final class ListItemsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private final String tag = "ListItemsActivity";
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    Switch list_switch;
    ImageButton list_imageButton;
    @SuppressLint("QueryPermissionsNeeded")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_list_items);

        //Camera business for image button
        list_imageButton = this.findViewById(R.id.list_imageButton);
        list_imageButton.setOnClickListener(view -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });

        //Switch business
        list_switch=findViewById(R.id.list_items_switch);
        list_switch.setOnCheckedChangeListener(this);

        //Checkbox business
        CheckBox list_checkBox = findViewById( R.id.list_items_checkBox);
        list_checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
            builder.setMessage(R.string.dialog_message)

                    .setTitle(R.string.dialog_title)
                    .setPositiveButton(R.string.ok, (dialog, id) -> {
                        // Yes to ending the activity
                        Intent resultIntent = new Intent(  );
                        resultIntent.putExtra("Response", "Here is my response");
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> {
                        // User cancelled the dialog
                    })
                    .show();
        });
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

    //finish() method calls the onDestroy method, not onFinish()
    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.tag, "Finished ListItemsActivity.");
    }

    //When OK is selected after taking a picture, image is saved on the button.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageButton btnImg = findViewById(R.id.list_imageButton);
            btnImg.setImageBitmap(imageBitmap);
        }
    }

    //Required to use onCheckedChanges instead of setOnCheckedChanges to implement the CompoundButton class
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked)    //Switch is on
        {
            Toast toast = Toast.makeText(this, R.string.switch_on, Toast.LENGTH_SHORT); //this is the ListActivity
            toast.show(); //display your message box
        }
        else    //Switch is off
        {
            Toast toast = Toast.makeText(this, R.string.switch_off, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
