package com.owenbryan.a3p971project.YelpFusion;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    /**
     * Gets the reviews of the restaurant specified.
     * @param id Business id.
     * @return ArrayList of reviews.
     */
    public ArrayList<Review> getReviews (String id)
    {
        ArrayList<Review> results = new ArrayList<>();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String searchString = BASE + "/businesses/" + id + "/reviews";
        URL url = null;
        try {
            url = new URL(searchString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;

        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer aheph9uPSckpKMjZNpz1_FnCEsBsrzsXnkWO7-e41I4QBS1IsCVEUFqLQV2sVRceXPKTD2oSWz6GB9oIDTnHGgg_bJ-1cKrpmWeaSXolPuhgIRQTUIhrglvZEPy4YXYx");
        } catch (IOException e) {
            e.printStackTrace();
        }


        String input = "";
        try {

            int code = con.getResponseCode();
            if (code == 200) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (input.compareTo("") != 0)
        {
            try {
                JSONObject object = new JSONObject(input);
                JSONArray reviews = object.getJSONArray("reviews");

                for (int i = 0; i < reviews.length(); i++) {
                    JSONObject bReview = reviews.getJSONObject(i);

                    Review review = new Review();

                    review.setId(bReview.getString("id"));
                    review.setText(bReview.getString("text"));
                    review.setUrl(bReview.getString("url"));
                    review.setRating(bReview.getInt("rating"));
                    review.setTimeCreated(bReview.getString("time_created"));

                    results.add(review);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return results;
    }

    /**
     * Gets the business details using the specified id.
     * @param id The businesses id.
     * @return The business details
     */
    public Business getBusiness (String id)
    {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String searchString = BASE + "/businesses/" + id;
        URL url = null;
        try {
            url = new URL(searchString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;

        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer aheph9uPSckpKMjZNpz1_FnCEsBsrzsXnkWO7-e41I4QBS1IsCVEUFqLQV2sVRceXPKTD2oSWz6GB9oIDTnHGgg_bJ-1cKrpmWeaSXolPuhgIRQTUIhrglvZEPy4YXYx");
        } catch (IOException e) {
            e.printStackTrace();
        }


        String input = "";
        try {

            int code = con.getResponseCode();
            if (code == 200) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Business result = new Business();

        if (input.compareTo("") != 0)
        {
            try {
                JSONObject object = new JSONObject(input);

                result.setName(object.getString("name"));
                JSONObject location = object.getJSONObject("location");
                Location location1 = new Location();
                location1.setAddress1(location.getString("address1"));
                location1.setAddress2(location.getString("address2"));
                location1.setAddress3(location.getString("address3"));
                location1.setCity(location.getString("city"));
                location1.setCountry(location.getString("country"));
                location1.setZipCode(location.getString("zip_code"));
                location1.setState(location.getString("state"));
                result.setLocation(location1);
                result.setRating(object.getDouble("rating"));
                result.setDisplayPhone(object.getString("display_phone"));


            } catch (JSONException e) {
                e.printStackTrace();
               Log.d("Error", e.toString());
            }
        }

        return result;
    }

    /**
     * Gets the restaurants via a query made to the yelp api.
     * @param query The query.
     * @return ArrayList response from the query.
     */
    public ArrayList<Business> getBusinesses (String query)
    {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String searchString = BASE + "/businesses/search?latitude=43.1176&longitude=-79.2477&title="+ query;
        URL url = null;
        try {
            url = new URL(searchString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;

        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer aheph9uPSckpKMjZNpz1_FnCEsBsrzsXnkWO7-e41I4QBS1IsCVEUFqLQV2sVRceXPKTD2oSWz6GB9oIDTnHGgg_bJ-1cKrpmWeaSXolPuhgIRQTUIhrglvZEPy4YXYx");
        } catch (IOException e) {
            e.printStackTrace();
        }


        String input = "";
        try {

            int code = con.getResponseCode();
            if (code == 200) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Business> results = new ArrayList<>();

        if (input.compareTo("") != 0)
        {
            try {
                JSONObject object = new JSONObject(input);
                JSONArray businesses = object.getJSONArray("businesses");

                for (int i = 0; i < businesses.length(); i++) {
                    JSONObject business = businesses.getJSONObject(i);

                    Business newBusiness = new Business();

                    newBusiness.setId(business.getString("id"));
                    newBusiness.setName(business.getString("name"));
                    newBusiness.setLongitude(business.getJSONObject("coordinates").getDouble("longitude"));
                    newBusiness.setLatitude(business.getJSONObject("coordinates").getDouble("latitude"));
                    results.add(newBusiness);
                }

            } catch (JSONException e) {
                e.printStackTrace();
//                Log.d("Error", e.toString());
            }
        }

        return results;
    }

    /**
     * Gets recommendations for autocomplete searching.
     * @param query The thing you want.
     * @return ArrayList of recommendations.
     */
    public ArrayList<String> autoComplete (String query)
    {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        URL url = null;
        try {
            url = new URL(BASE + "/autocomplete?latitude=43.1176&longitude=-79.2477&text=" + query);
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
                JSONArray terms = object.getJSONArray("Terms");
                JSONArray businesses = object.getJSONArray("businesses");
                JSONArray categories = object.getJSONArray("categories");

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
