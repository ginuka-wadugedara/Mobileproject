package com.example.mobileproject;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Window;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mobileproject.databinding.ActivityGoogalelibraryMapsBinding;

public class GoogalelibraryMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityGoogalelibraryMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityGoogalelibraryMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if(isLocationPermissionGranted()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
        else{
            requestLocationPermission();
        }
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
    private static final int LOCATION_PERMISSION_CODE = 101;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng Kandy= new LatLng(7.2920219519063085, 80.63556014170622);
        LatLng colombo= new LatLng(6.912806061056056, 79.85863828219253);
        LatLng kandy= new LatLng(7.317259167888586, 80.64551715520192);
        LatLng Getambe= new LatLng(7.268524276710773, 80.60258872636702);
        LatLng ELSenanayake= new LatLng(7.7467981089572655, 80.11367795050464);



        mMap.addMarker(new MarkerOptions().position(Kandy).title("D.S. Senanayake Memorial Public Library"));
        mMap.addMarker(new MarkerOptions().position(colombo).title("Colombo Public Library"));
        mMap.addMarker(new MarkerOptions().position(kandy).title("Mahaweli Uyana Public Library"));
        mMap.addMarker(new MarkerOptions().position(Getambe).title("Mahinda Rajapaksha Public Library"));
        mMap.addMarker(new MarkerOptions().position(ELSenanayake).title("E L SENANAYAKE Auditorium Children's Library"));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kandy, 18.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }

    }
    private boolean isLocationPermissionGranted(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else {
            return false;
        }
    }
    private void requestLocationPermission(){
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_CODE);
    }
}
