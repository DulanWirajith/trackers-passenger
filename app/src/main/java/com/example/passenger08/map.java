package com.example.passenger08;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class map extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 2;
    private FusedLocationProviderClient fusedLocationClient = null;
    static Location mCurrentLocation;

    GoogleMap map;


    public map() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        check_gps_status();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        get_the_last_known_location();

        if (mCurrentLocation != null) {
            map = googleMap;
            double lon = mCurrentLocation.getLongitude();
            System.out.println(lon);
            double lat = mCurrentLocation.getLatitude();
            System.out.println(lat);
            LatLng pp = new LatLng(lat, lon);
            System.out.println("test" + mCurrentLocation);


            MarkerOptions option = new MarkerOptions();
            option.position(pp).title("Mihinthale");
            map.addMarker(option);
            map.moveCamera(CameraUpdateFactory.newLatLng(pp));
            map.animateCamera(CameraUpdateFactory.zoomTo(16.0f));



        }
//marker
        map=googleMap;
//        Polyline line = map.addPolyline(new PolylineOptions()
//                .add(new LatLng(51.5, -0.1), new LatLng(40.7, -74.0))
//                .width(5)
//                .color(Color.RED));
        LatLng ppp=new LatLng(8.352865,80.502446);
        map.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        map.getUiSettings().setZoomControlsEnabled(true);

        MarkerOptions mihinthale =new MarkerOptions();
                mihinthale.position(ppp)
                .title("Mihinthale")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .snippet("Predicted time: 01245"+"\n"+"Rating:4/5");


        map.addMarker(mihinthale);
        map.moveCamera(CameraUpdateFactory.newLatLng(ppp));
        map.animateCamera( CameraUpdateFactory.zoomTo( 16.0f ) );

        //WIndow
        map.setOnInfoWindowClickListener(this);

    }

    //    GPS on karalada kiyala balanna
    public void check_gps_status() {
        LocationManager service = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);

// check if enabled and if not send user to the GSP settings
        if (!enabled) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
            builder1.setMessage("To use this service you have to enable GPS. Would you like to enable GPS?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else {
            Toast.makeText(getActivity(), "GPS Provider is Enabled", LENGTH_SHORT).show();
        }
    }


    private void get_the_last_known_location() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());

            fusedLocationClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        mCurrentLocation = location;
                        System.out.println("loca" + location);
                    } else {
                        System.out.println("location is null");
                    }
                }
            });
        } else {
            System.out.println("no permission granted");
//            rewquesting Permissions
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
            System.out.println(MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);


        }
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        System.out.println("clicked");

    }




}
