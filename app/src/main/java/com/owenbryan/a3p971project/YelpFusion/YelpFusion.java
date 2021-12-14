package com.owenbryan.a3p971project.YelpFusion;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class YelpFusion {

    private final String BASE = "https://api.yelp.com/v3";

    public YelpFusion () {}

    public ArrayList<String> getBusinesses (String query)
    {
        String searchString = BASE + "/businesses/search?title="+query;
        URL url = null;
        try {
            url = new URL(BASE + "/autocomplete");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;

        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer <aheph9uPSckpKMjZNpz1_FnCEsBsrzsXnkWO7-e41I4QBS1IsCVEUFqLQV2sVRceXPKTD2oSWz6GB9oIDTnHGgg_bJ-1cKrpmWeaSXolPuhgIRQTUIhrglvZEPy4YXYx>");
        } catch (IOException e) {
            e.printStackTrace();
        }


        String input = "";
        if (con != null) {
            try {
                StringBuffer content;
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                content = new StringBuffer();

                while ((input = in.readLine()) != null) {
                    content.append(input);
                }
                in.close();

                con.disconnect();

                input = content.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> results = new ArrayList<>();

        if (input.compareTo("") != 0)
        {
            try {
                JSONObject object = new JSONObject(input);
                JSONArray businesses = new JSONArray(object.getJSONArray("businesses"));

                for (int i = 0; i < businesses.length(); i++) {
                    JSONObject business = businesses.getJSONObject(i);
                    results.add(business.getString("name"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    public ArrayList<String> autoComplete ()
    {
        URL url = null;
        try {
            url = new URL(BASE + "/autocomplete");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;

        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer <aheph9uPSckpKMjZNpz1_FnCEsBsrzsXnkWO7-e41I4QBS1IsCVEUFqLQV2sVRceXPKTD2oSWz6GB9oIDTnHGgg_bJ-1cKrpmWeaSXolPuhgIRQTUIhrglvZEPy4YXYx>");
        } catch (IOException e) {
            e.printStackTrace();
        }


        String input = "";
        if (con != null) {
            try {
                StringBuffer content;
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    content = new StringBuffer();

                    while ((input = in.readLine()) != null) {
                        content.append(input);
                    }
                    in.close();

                con.disconnect();

                input = content.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        ArrayList<String> results = new ArrayList<>();

        if (input.compareTo("") != 0)
        {
            try {
                JSONObject object = new JSONObject(input);
                JSONArray terms = new JSONArray(object.getJSONArray("Terms"));
                JSONArray businesses = new JSONArray(object.getJSONArray("Terms"));
                JSONArray categories = new JSONArray(object.getJSONArray("Terms"));

                for (int i = 0; i < terms.length(); i++) {
                    results.add(terms.getString(i));
                }
                for (int i = 0; i < businesses.length(); i++) {
                    JSONObject business = businesses.getJSONObject(i);
                    results.add(business.getString("text"));
                }
                for (int i = 0; i < categories.length(); i++) {
                    JSONObject category = categories.getJSONObject(i);
                    results.add(category.getString("title"));
                }
                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        results.add("Chinese");
        results.add("Indian");
        results.add("Pizza");

        return  results;
    }
}
