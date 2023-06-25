package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
ListView listView;
EditText chatText;
Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        listView = findViewById(R.id.listView);
        chatText = findViewById(R.id.chatEditText);
        sendButton = findViewById(R.id.sendButton);
        ArrayList<String> chatMessageArray = new ArrayList<>();

        sendButton.setOnClickListener(view ->
        {
            String chatMessage = chatText.getText().toString();
            chatMessageArray.add(chatMessage);
        });
    }


}