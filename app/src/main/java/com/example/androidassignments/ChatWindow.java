package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    ListView listView;
    EditText chatText;
    Button sendButton;
    ArrayList<String> chatMessageArray = new ArrayList<>();
    ChatAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        listView = findViewById(R.id.listView);
        chatText = findViewById(R.id.chatEditText);
        sendButton = findViewById(R.id.sendButton);
        messageAdapter = new ChatAdapter(this);

        sendButton.setOnClickListener(view ->
        {
            String chatMessage = chatText.getText().toString();

            chatMessageArray.add(chatMessage);

            chatMessageArray.add(chatMessage);
            messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/
            chatText.setText("");
        });
    }
    private class ChatAdapter extends ArrayAdapter {
//    ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, R.layout.activity_chat_window);
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        //private static final int resource = 0;
        //messageAdapter = new ChatAdapter(this.getContext());

        public int getCount(){
            return chatMessageArray.size();
        }
        public String getItem(int position){
            return chatMessageArray.get(position);
        }
        @SuppressLint("InflateParams")
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result;

            if(position%2 == 0) {
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            }
            else
            {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            TextView message = result.findViewById(R.id.messageText);
            message.setText(   getItem(position)  ); // get the string at position
            return result;
        }
    }
}