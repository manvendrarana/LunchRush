package com.owenbryan.a3p971project;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.owenbryan.a3p971project.YelpFusion.Business;
import com.owenbryan.a3p971project.YelpFusion.YelpFusion;
import com.owenbryan.a3p971project.databinding.ActivityMapsBinding;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private double lng = 0;
    private double lat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        String query = getIntent().getStringExtra("query");
        String queryLocation = getIntent().getStringExtra("location");
        try {
            query = URLEncoder.encode(query, "UTF-8");
            queryLocation = URLEncoder.encode(queryLocation, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        new GetResteraunts().execute(query, queryLocation);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(this);



        LatLng brock = new LatLng(43.1176, -79.2477);
        Marker brockMaker = mMap.addMarker(new MarkerOptions().position(brock).title("Marker on Brock"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(brock));
//        mMap.setMinZoomPreference(12);
        brockMaker.remove();

    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {
        String id = (String) marker.getTag ();

        Intent intent = new Intent(this, BusinessDetails.class);

        intent.putExtra("id", id);

        startActivity(intent);

    }


    private class GetResteraunts extends AsyncTask <String, Void, ArrayList<Business>>
    {

        @Override
        protected ArrayList<Business> doInBackground(String... strings) {
            YelpFusion fusion = new YelpFusion();
            ArrayList<Business> result = null;

            result = fusion.getBusinesses(strings [0], strings [1]);

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Business> businesses) {
            super.onPostExecute(businesses);

            for (Business b :
                    businesses) {
                LatLng place = new LatLng(b.getLatitude(), b.getLongitude());

                Marker marker = mMap.addMarker(new MarkerOptions().position(place).title(b.getName()));
                marker.setTag(b.getId());
//                Log.d("b", b.getName());
            }
        }
    }
}