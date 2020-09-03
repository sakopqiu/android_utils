package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message == null) {
            message = intent.getStringExtra(Intent.EXTRA_TEXT).toString();
        }

        setContentView(R.layout.activity_receive_message);

        TextView text = findViewById(R.id.message);
        text.setText(message);

        final ListView list = findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean is = parent == list;
                System.out.println(is);
            }
        });
    }
}