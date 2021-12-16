package com.owenbryan.a3p971project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void searchForBusinesses(View view) {

        Intent intent = new Intent(this, MapsActivity.class);
        TextView business = (TextView) findViewById(R.id.business);
        TextView location = (TextView) findViewById(R.id.location);

        String query = business.getText().toString();

        if (query.trim().compareTo("") != 0)
        {

            intent.putExtra("query", query);



            String queryLocation = location.getText().toString();

            if (queryLocation.trim().compareTo("") != 0)
            {
                intent.putExtra("location", queryLocation);
            }
            else
            {
                intent.putExtra("location", "St. Catharines, ON");
            }

            startActivity (intent);
        }



    }
}
