package com.example.androidassignments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidassignments.R.layout;

import org.jetbrains.annotations.Nullable;

import java.io.FileOutputStream;
import java.util.Date;

public final class ListItemsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private final String tag = "ListItemsActivity";
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private Activity activity;
    private AlertDialog dialog;

    Switch list_switch;
    ImageButton list_imageButton;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_list_items);

        //Camera for image button
        list_imageButton = this.findViewById(R.id.list_imageButton);
        list_imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                /*if (takePictureIntent.resolveActivity(ListItemsActivity.getPackageManager()) != null) {
                    ListItemsActivity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }*/
            }
        });

        //Switch business
        list_switch=findViewById(R.id.list_items_switch);
        list_switch.setOnCheckedChangeListener(this);

        //Checkbox business
        CheckBox list_checkBox = ( CheckBox ) findViewById( R.id.list_items_checkBox);
        list_checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.dialog_message)

                        .setTitle(R.string.dialog_title)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Yes to ending the activity
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        })
                        .show();
            }
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

   /* public void saveImage(Bitmap imageBitmap) {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        java.text.DateFormat dateFormat =
                new java.text.SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);

        try {
            FileOutputStream outputStream =
                    anActivity.openFileOutput(formattedDate, Context.MODE_PRIVATE);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
        }
    }*/

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
