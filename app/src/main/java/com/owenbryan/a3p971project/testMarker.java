package com.owenbryan.a3p971project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.owenbryan.a3p971project.YelpFusion.Business;
import com.owenbryan.a3p971project.YelpFusion.YelpFusion;

import java.nio.channels.AsynchronousByteChannel;

public class testMarker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_marker);

        String id = getIntent().getStringExtra("id");

        TextView textView = (TextView) findViewById(R.id.testM);

        textView.setText(id);

        new GetBusiness().execute(id);
    }

    private class GetBusiness extends AsyncTask <String, Void, Business>
    {

        @Override
        protected Business doInBackground(String... strings) {
            YelpFusion fusion = new YelpFusion();
            Business b = fusion.getBusiness(strings[0]);

            return b;

        }

        @Override
        protected void onPostExecute(Business business) {
            super.onPostExecute(business);

            TextView textView = (TextView) findViewById(R.id.testM);

            textView.setText(business.getName());
        }
    }
}