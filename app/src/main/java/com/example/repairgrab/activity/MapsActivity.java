package com.example.repairgrab.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.repairgrab.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class  MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Dialog myDialog, reviewDialog;
    private CircleImageView avatar;
    private TextView repairName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //dialog
        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.dialog_contact_2);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //review dialog
        reviewDialog = new Dialog(this);
        reviewDialog.setContentView(R.layout.dialog_review);
        reviewDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        avatar = myDialog.findViewById(R.id.repairer_avatar);
        repairName = myDialog.findViewById(R.id.txt_dialog_name);

        Button btnCall = myDialog.findViewById(R.id.btn_dialog_call2);
        //Button btnClose = myDialog.findViewById(R.id.btnClose);
        Button btnReview = myDialog.findViewById(R.id.btn_review2);
        Button btnCloseReview = reviewDialog.findViewById(R.id.btn_close_review);

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewDialog.show();
            }
        });
        btnCloseReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewDialog.cancel();
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WaitingRepairActivity.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Add a marker in Sydney and move the camera
        LatLng myLocation  = new LatLng(10.852667, 106.629065);
        //add repairer
        LatLng repaier1 = new LatLng(10.852963, 106.626373);
        LatLng repaier2 = new LatLng(10.852098, 106.630644);
        LatLng repaier3 = new LatLng(10.855554, 106.628713);

        //mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.addMarker(new MarkerOptions().position(myLocation).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMylocationMarker(MapsActivity.this,0,"")))).setTitle("");
        mMap.addMarker(new MarkerOptions().position(repaier1).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMarker(MapsActivity.this,R.drawable.ic_repaier)))).setTitle("Ready");
        mMap.addMarker(new MarkerOptions().position(repaier2).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMarker(MapsActivity.this,R.drawable.ic_repaier)))).setTitle("Ready2");
        mMap.addMarker(new MarkerOptions().position(repaier3).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMarker(MapsActivity.this,R.drawable.ic_repaier)))).setTitle("Ready3");


        //LatLngBound will cover all your marker on Google Maps
//        LatLngBounds.Builder builder = new LatLngBounds.Builder();
//        builder.include(myLocation);
//        builder.include(repaier1);
//        LatLngBounds bounds = builder.build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 30));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("Ready")) {
                    avatar.setImageDrawable(getResources().getDrawable(R.drawable.tinh));
                    repairName.setText("Lâm Thanh Phát");
                    myDialog.show();                } else if (marker.getTitle().equals("Ready2")) {
                    avatar.setImageDrawable(getResources().getDrawable(R.drawable.quankun));
                    repairName.setText("Nguyễn Triệu Duy");
                    myDialog.show();
                } else if (marker.getTitle().equals("Ready3")) {
                    avatar.setImageDrawable(getResources().getDrawable(R.drawable.duy));
                    repairName.setText("Trần Sang");
                    myDialog.show();
                }
                return true;
            }
        });


    }

    public static Bitmap createCustomMarker(Context context, @DrawableRes int resource) {

        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker_layout, null);

        CircleImageView markerImage =  marker.findViewById(R.id.user_dp);
        markerImage.setImageResource(resource);
        //TextView txt_name = marker.findViewById(R.id.name);
        //txt_name.setText(_name);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        marker.setLayoutParams(new ViewGroup.LayoutParams(60, ViewGroup.LayoutParams.WRAP_CONTENT));
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
