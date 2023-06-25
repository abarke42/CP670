package com.example.androidassignments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.Nullable;

public final class LoginActivity extends AppCompatActivity
{
    private final String tag = "LoginActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
        //Load user data
        loadUserData();
    }

    public void onLoginClicked(View v){

        //Get user input
        String new_username_entered = ((EditText) findViewById(R.id.loginInput)).getText().toString();

        //If valid e-mail address, then save it for next time
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(new_username_entered).matches()) {
            saveUserData();
            //Switch to another activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        //else ask the user to input it again
        else {
            Toast.makeText(LoginActivity.this, getString(R.string.validate_login), Toast.LENGTH_LONG).show();
        }
    }

    protected void onStart() {
        super.onStart();
        Log.i(this.tag, "Started LoginActivity.");
    }

    protected void onPause() {
        super.onPause();
        Log.i(this.tag, "Paused LoginActivity.");
    }

    protected void onResume() {
        super.onResume();
        Log.i(this.tag, "Resumed LoginActivity.");
    }

    protected void onStop() {
        super.onStop();
        Log.i(this.tag, "Stopped LoginActivity.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.tag, "Destroyed LoginActivity.");
    }

    private void loadUserData() {

        //Get shared preferences
        String file_name = getString(R.string.pref_filename);
        SharedPreferences mPrefs = getSharedPreferences(file_name, MODE_PRIVATE);

        String username_key = getString(R.string.key_username);

        //Display username email, default if none
        String new_username_value = mPrefs.getString(username_key, getString(R.string.default_email));
        ((EditText) findViewById(R.id.loginInput)).setText(new_username_value);

        //Toast.makeText(LoginActivity.this, getString(R.string.save_message), Toast.LENGTH_LONG).show();
    }


    private void saveUserData() {

        //Get shared preferences
        String file_name = getString(R.string.pref_filename);
        SharedPreferences mPrefs = getSharedPreferences(file_name, MODE_PRIVATE);

        //Save new value for username email
        SharedPreferences.Editor myEditor = mPrefs.edit();
        myEditor.clear();
        String email_key  = getString(R.string.key_username);
        String new_username_entered = ((EditText) findViewById(R.id.loginInput))
                .getText().toString();
        myEditor.putString(email_key, new_username_entered);

        myEditor.commit();

        Toast.makeText(LoginActivity.this, getString(R.string.save_message), Toast.LENGTH_LONG).show();
    }
}