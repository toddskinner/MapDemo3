package com.example.android.mapsdemo3;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    boolean mapReady = false;

    MarkerOptions renton;
    MarkerOptions kirkland;
    MarkerOptions everett;
    MarkerOptions lynnwood;
    MarkerOptions montlake;
    MarkerOptions kent;
    MarkerOptions showare;

    LatLng rentonLatLong = new LatLng(47.489805, -122.120502);
    LatLng kirklandLatLong = new LatLng(47.7301986, -122.1768858);
    LatLng everettLatLong = new LatLng(47.978748, -122.202001);
    LatLng lynnwoodLatLong = new LatLng(47.819533, -122.32288);
    LatLng montlakeLatLong = new LatLng(47.7973733, -122.3281771);
    LatLng kentLatLong = new LatLng(47.385938, -122.258212);
    LatLng showareLatLong = new LatLng(47.38702, -122.23986);

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        renton = new MarkerOptions()
                .position(new LatLng(47.489805, -122.120502))
                .title("Renton")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        kirkland = new MarkerOptions()
                .position(new LatLng(47.7301986, -122.1768858))
                .title("Kirkland")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        everett = new MarkerOptions()
                .position(new LatLng(47.978748, -122.202001))
                .title("Everett")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        lynnwood = new MarkerOptions()
                .position(new LatLng(47.819533, -122.32288))
                .title("Lynnwood")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        montlake = new MarkerOptions()
                .position(new LatLng(47.7973733, -122.3281771))
                .title("Montlake")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        kent = new MarkerOptions()
                .position(new LatLng(47.385938, -122.258212))
                .title("Kent")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        showare = new MarkerOptions()
                .position(new LatLng(47.38702, -122.23986))
                .title("Showare")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapReady = true;

        mMap.addMarker(renton);
        mMap.addMarker(kirkland);
        mMap.addMarker(everett);
        mMap.addMarker(lynnwood);
        mMap.addMarker(montlake);
        mMap.addMarker(kent);
        mMap.addMarker(showare);

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(rentonLatLong)
                .add(kirklandLatLong)
                .add(everettLatLong)
                .add(lynnwoodLatLong)
                .add(montlakeLatLong)
                .add(kentLatLong)
                .add(showareLatLong)
        );

        mMap.addCircle(new CircleOptions()
        .center(rentonLatLong)
        .radius(5000)
        .strokeColor(Color.GRAY)
        .fillColor(Color.LTGRAY));

        flyTo(SEATTLE);
    }

    private void flyTo(CameraPosition target){
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 1000, null);
    }
}
