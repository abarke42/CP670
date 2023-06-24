package com.example.androidassignments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.androidassignments.R.layout;
import org.jetbrains.annotations.Nullable;

public final class LoginActivity extends AppCompatActivity {
    private final String tag = "LoginActivity";

    EditText email;
    EditText password;
    Button button;
    SharedPreferences sharedpref;
    String emailStr, passStr;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_login);

        email = findViewById(R.id.loginInput);
        password = findViewById(R.id.passwordInput);
        button = findViewById(R.id.loginButton);

        sharedpref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        //if (SharedPreferences.getString("DefaultE-mail", "default@gmail.com") = null)

        button.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View view){
             //Save username and password in shared preferences
             emailStr = email.getText().toString();
             passStr = password.getText().toString();

             SharedPreferences.Editor editor = sharedpref.edit();

             editor.putString("email", emailStr);
             editor.putString("password", passStr);
             editor.apply();
             Toast.makeText(LoginActivity.this, "User information saved", Toast.LENGTH_LONG).show();

             //Switch to another activity
             Intent intent = new Intent(LoginActivity.this, MainActivity.class);
             startActivity(intent);
         }
        });
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
}
