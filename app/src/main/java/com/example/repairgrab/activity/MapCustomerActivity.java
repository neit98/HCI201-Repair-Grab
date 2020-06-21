package com.example.repairgrab.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.repairgrab.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MapCustomerActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final List<LatLng> arrLocation = new ArrayList<>();

    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_customer);
        initialLocation();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_customer);
        mapFragment.getMapAsync(this);
        LinearLayout layout = findViewById(R.id.layout_custom);
        ((View)layout.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

        LinearLayout ln_detail = findViewById(R.id.ln_detail);
        ln_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailErrorActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initialLocation() {
        arrLocation.add(new LatLng(10.852993, 106.626394));
        arrLocation.add(new LatLng(10.852926, 106.626432));
        arrLocation.add(new LatLng(10.852954, 106.626566));
        arrLocation.add(new LatLng(10.852931, 106.626705));
        arrLocation.add(new LatLng(10.852911, 106.626814));
        arrLocation.add(new LatLng(10.853013, 106.626994));
        arrLocation.add(new LatLng(10.852799, 106.627143));
        arrLocation.add(new LatLng(10.852630, 106.627305));
        arrLocation.add(new LatLng(10.852429, 106.627596));
        arrLocation.add(new LatLng(10.852325, 106.627814));
        arrLocation.add(new LatLng(10.852257, 106.628070));
        arrLocation.add(new LatLng(10.852257, 106.628399));
        arrLocation.add(new LatLng(10.852290, 106.628723));
        arrLocation.add(new LatLng(10.852340, 106.628936));
        arrLocation.add(new LatLng(10.852446, 106.629174));
        arrLocation.add(new LatLng(10.852717, 106.629039));



    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng myLocation  = new LatLng(10.852963, 106.626373);
        LatLng cusLocation  = new LatLng(10.852667, 106.629065);

        mMap.addMarker(new MarkerOptions().position(myLocation).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMylocationMarker(MapCustomerActivity.this,0,"")))).setTitle("");
        mMap.addMarker(new MarkerOptions().position(cusLocation).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMarker(MapCustomerActivity.this,R.drawable.ic_settings)))).setTitle("Ready");

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 30));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
        PolylineOptions polyLineOptions1 = new PolylineOptions().clickable(true).color(0xff0033cc).width(7);
        polyLineOptions1.add(new LatLng(10.852963, 106.626373));
        for (int i = 0; i < arrLocation.size(); i++) {
            polyLineOptions1.add(arrLocation.get(i));
        }
        mMap.addPolyline(polyLineOptions1);

    }

    public static Bitmap createCustomMarker(Context context, @DrawableRes int resource) {

        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker_layout, null);

        CircleImageView markerImage =  marker.findViewById(R.id.user_dp);
        markerImage.setImageResource(resource);
        //TextView txt_name = marker.findViewById(R.id.name);
        //txt_name.setText(_name);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        marker.setLayoutParams(new ViewGroup.LayoutParams(50, ViewGroup.LayoutParams.WRAP_CONTENT));
        marker.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(marker.getMeasuredWidth(), marker.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        marker.draw(canvas);


        return bitmap;
    }


    public static Bitmap createCustomMylocationMarker(Context context, @DrawableRes int resource, String _name) {

        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_mylocation_marker_layout, null);

        CircleImageView markerImage =  marker.findViewById(R.id.user_dp);
        markerImage.setImageResource(resource);
        //TextView txt_name = marker.findViewById(R.id.name);
        //txt_name.setText(_name);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        marker.setLayoutParams(new ViewGroup.LayoutParams(50, ViewGroup.LayoutParams.WRAP_CONTENT));
        marker.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(marker.getMeasuredWidth(), marker.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        marker.draw(canvas);

        return bitmap;
    }

}
