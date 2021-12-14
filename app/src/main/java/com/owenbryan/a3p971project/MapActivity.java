package com.owenbryan.a3p971project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();

        String query = intent.getStringExtra("query");

        TextView textView = (TextView) findViewById(R.id.test);

        textView.setText(query);
    }
}