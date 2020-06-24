package com.example.testgooglemap;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsPage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MyLocation myLocation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_maps);

        myLocation = new MyLocation();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    MarkerOptions place1, place2;

    float zoomMiktari;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        zoomMiktari=9f; //30-40-50-60-70km

        if(Math.round(myLocation.mesafe) == 1)
            zoomMiktari=14f;

        if(myLocation.mesafe > 0.0 && myLocation.mesafe < 0.2)
            zoomMiktari=17f;

        if(myLocation.mesafe >= 0.2 && myLocation.mesafe < 0.4)
            zoomMiktari=16f;

        if(myLocation.mesafe >= 0.4 && myLocation.mesafe <= 0.6)
            zoomMiktari=15f;

        if(Math.round(myLocation.mesafe) == 2)
            zoomMiktari=13f;
        if(Math.round(myLocation.mesafe) == 3)
            zoomMiktari= 12f;
        if((Math.round(myLocation.mesafe) == 4)||
                ((Math.round(myLocation.mesafe) == 10) && (Math.round(myLocation.mesafe) <= 14)))//14,
            zoomMiktari=11f;
        if((Math.round(myLocation.mesafe) == 5) || ((Math.round(myLocation.mesafe) >= 15) && (Math.round(myLocation.mesafe) <= 19)))
            zoomMiktari=10f;
        if((Math.round(myLocation.mesafe) == 6)|| ((Math.round(myLocation.mesafe) >= 20) && (Math.round(myLocation.mesafe) == 70)))
            zoomMiktari = 9f;
        if((Math.round(myLocation.mesafe) == 7) || ((Math.round(myLocation.mesafe) > 70) && (Math.round(myLocation.mesafe) <= 80)))//80km
            zoomMiktari= 8f;
        if((Math.round(myLocation.mesafe) == 8)|| ((Math.round(myLocation.mesafe) > 80) && (Math.round(myLocation.mesafe) <= 210)))
            zoomMiktari=7f;
        if((Math.round(myLocation.mesafe) == 9) || ((Math.round(myLocation.mesafe) > 210) && (Math.round(myLocation.mesafe) <=550)))
            zoomMiktari=6f;
        if(((Math.round(myLocation.mesafe) > 550) && (Math.round(myLocation.mesafe) <=700)))
            zoomMiktari=5f;
        if(((Math.round(myLocation.mesafe) > 700) && (Math.round(myLocation.mesafe) <=1000)))
            zoomMiktari=4f;
        if(((Math.round(myLocation.mesafe) > 1000) && (Math.round(myLocation.mesafe) <=1500)))
            zoomMiktari=3.5f;

        //wsden gelen konum bilgisi
        if( Constants._getLatitude != 0.0 && Constants._getLongitude != 0.0){
            MarkerOptions markerOptions1 = new MarkerOptions();
            LatLng atm = new LatLng( Constants._getLatitude,Constants._getLongitude);
            place1 = markerOptions1.icon((BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(atm, zoomMiktari));
            mMap.addMarker(markerOptions1.position(atm).title("Konumunuz"));
        }

        //Şuanki bulunduğu konumu göster
       /* MarkerOptions markerOptions2 = new MarkerOptions();
        LatLng loc = new LatLng(38.7233174,35.3301031);
        LatLng loc = new LatLng(Constants._getLatitude,Constants._getLongitude);
        mMap.addMarker(new MarkerOptions().position(loc).title("R.string.location"));
        place2 = markerOptions2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, zoomMiktari));
        mMap.setMinZoomPreference(mesafe);*/
    }
}

