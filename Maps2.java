package com.example.antoine.projet_contact;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng pos;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);

        int i =1;
        pos = new LatLng(-34, 151);
        Intent myIntent = getIntent();
        String newString= myIntent.getStringExtra("name");

        for (i=0;i<Data.nameArray.length;i++)
        {
            if (newString.equals(Data.fnameArray[i]))
            {
                j = i;
            }
        }

        //pos = Data.pos[i];


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = pos;
        Marker syd = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        pos = Data.pos[j];
        mMap.addMarker(new MarkerOptions().position(pos).title("Marker in your friend home !"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
        syd.remove();
    }
}
