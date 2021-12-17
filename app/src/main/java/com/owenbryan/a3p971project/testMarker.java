package com.owenbryan.a3p971project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.owenbryan.a3p971project.YelpFusion.Business;
import com.owenbryan.a3p971project.YelpFusion.Review;
import com.owenbryan.a3p971project.YelpFusion.YelpFusion;

import java.nio.channels.AsynchronousByteChannel;
import java.util.ArrayList;

public class testMarker extends AppCompatActivity {
    String url;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_marker);

        String id = getIntent().getStringExtra("id");



        new GetBusiness().execute(id);
        new GetReviews().execute(id);
    }

    public void goToYelp(View view) {

        if(url.compareTo("") != 0)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            try {
                startActivity(intent);
            }
            catch (ActivityNotFoundException e)
            {
                Toast t = Toast.makeText(this, "No web browser available", Toast.LENGTH_SHORT);
                t.show();
            }
        }

    }

    public void openPhone(View view) {
        if(phone.compareTo("") != 0)
        {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));

            try {
                startActivity(intent);
            }
            catch (ActivityNotFoundException e)
            {
                Toast t = Toast.makeText(this, "No phone app available", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    private class GetReviews extends AsyncTask <String, Void, ArrayList<Review>>
    {

        @Override
        protected ArrayList<Review> doInBackground(String... strings) {
            YelpFusion fusion = new YelpFusion();

            ArrayList<Review> results = fusion.getReviews(strings [0]);

            return results;
        }

        @Override
        protected void onPostExecute(ArrayList<Review> reviews) {
            super.onPostExecute(reviews);

            ListView lv = (ListView) findViewById(R.id.reviews);


            ArrayList<String> output = new ArrayList<>();

            for (int i = 0; i < reviews.size(); i++) {
                if (reviews.get(i).getText().compareTo("") != 0)
                {
                    output.add(reviews.get(i).getText());
                }
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(testMarker.this, android.R.layout.simple_list_item_1, output);

            lv.setAdapter(adapter);
        }
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
            TextView textView1 = (TextView) findViewById(R.id.phoneNumber);
            TextView textView2 = (TextView) findViewById(R.id.displayAddress);
            TextView rating = (TextView) findViewById(R.id.Rating);

            textView.setText(business.getName());
            textView1.setText(business.getDisplayPhone());
            textView2.setText(business.getLocation().getAddress1());
            url = business.getUrl();
            phone = business.getDisplayPhone();
            double bRating = business.getRating();
            rating.setText(bRating + "");

            if (phone.compareTo("") != 0)
            {
                Button yelp = (Button) findViewById(R.id.dial);
                yelp.setVisibility(View.VISIBLE);
            }
            if (url.compareTo("") != 0)
            {
                Button yelp = (Button) findViewById(R.id.linkYelp);
                yelp.setVisibility(View.VISIBLE);
            }

        }
    }
}