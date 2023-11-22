package com.example.mobileproject;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mobileproject.databinding.ActivityGoogaleclassMapsBinding;



public class GoogaleclassMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGoogaleclassMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGoogaleclassMapsBinding.inflate(getLayoutInflater());
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
        LatLng Kandy= new LatLng(7.285933192917198, 80.62598448261143);
        LatLng KatuKale= new LatLng(7.285939876638377, 80.627924882193 );
        LatLng Ict= new LatLng(7.290797953000159, 80.62754633219842);
        LatLng kandy= new LatLng(7.290415436805374, 80.62914328403666 );
        LatLng Dehiwala= new LatLng(6.86377766916385, 79.86389434344025 );


        mMap.addMarker(new MarkerOptions().position(Kandy).title("IMS"));
        mMap.addMarker(new MarkerOptions().position(KatuKale).title("Nipun Higher Education Institute"));
        mMap.addMarker(new MarkerOptions().position(Ict).title("ICT class"));
        mMap.addMarker(new MarkerOptions().position(kandy).title("The First Kandyan International"));
        mMap.addMarker(new MarkerOptions().position(Dehiwala).title("Scientas Institute - online learning academy"));



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







