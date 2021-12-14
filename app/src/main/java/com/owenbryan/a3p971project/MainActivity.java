package com.owenbryan.a3p971project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void searchForBusinesses(View view) {

        Intent intent = new Intent(this, MapActivity.class);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.business);

        String query = textView.getText().toString();
        intent.putExtra("query", query);

        startActivity (intent);

    }
}
