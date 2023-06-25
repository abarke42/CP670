package com.example.androidassignments;

import static android.widget.Toast.*;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Helper extends AppCompatActivity {

    public void print(String text) {
        Toast toast = makeText(this, text, LENGTH_SHORT);
        toast.show();
    }
}
