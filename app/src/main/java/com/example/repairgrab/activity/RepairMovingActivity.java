package com.example.repairgrab.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repairgrab.LocationRunnable;
import com.example.repairgrab.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RepairMovingActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final List<LatLng> arrLocation = new ArrayList<>();
    private final LatLng startPos = new LatLng(10.852993, 106.626394);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_moving);
        initialLocation();
        // Build the map.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_move);
        mapFragment.getMapAsync(this);
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

    private void repairmanMovingToCustomer() {
        try {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.setTrafficEnabled(false);
            mMap.setIndoorEnabled(false);
            mMap.setBuildingsEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(startPos));
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                    .target(mMap.getCameraPosition().target)
                    .zoom(18)
                    .bearing(30)
                    .tilt(45)
                    .build()));
            final Marker repairManMarker = mMap.addMarker(new MarkerOptions()
                    .position(startPos)
                    .icon(BitmapDescriptorFactory.fromBitmap(
                            createCustomMarker(RepairMovingActivity.this,R.drawable.ic_repaier)))
                    .title("Repairman"));
//            final Marker customerLocationMarker = mMap.addMarker(new MarkerOptions()
//                    .position(desPos)
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.customersign))
//                    .title("Customer Location"));
            createThreadRMTC(repairManMarker);
//            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//                @Override
//                public boolean onMarkerClick(Marker arg0) {
//                    createThreadRMTC(repairManMarker);
//                    return true;
//                }
//            });

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void createThreadRMTC(final Marker M1) {
        final Handler handler = new Handler();
        // duration by milliseconds
        final float durationInMs = 2000;
        LocationRunnable threadLocation = new LocationRunnable() {
            long elapsed;
            float t;
            Polyline mPolyline1 = null;
            Polyline mPolyline2 = null;

            @Override
            public void run() {
                int i = getI();
                // Calculate progress using interpolator
                elapsed = SystemClock.uptimeMillis() - getStart();
                t = elapsed / durationInMs;
                LatLng currentPosition = new LatLng(
                        arrLocation.get(i).latitude * (1 - t) + arrLocation.get(i + 1).latitude * t,
                        arrLocation.get(i).longitude * (1 - t) + arrLocation.get(i + 1).longitude * t);
                M1.setPosition(currentPosition);

                // draw routes
                PolylineOptions polyLineOptions1 = new PolylineOptions().clickable(true).color(0xff0033cc).width(7);
                //polyLineOptions1.
                polyLineOptions1.add(currentPosition);
                for (int j = i + 1; j < arrLocation.size(); j++) {
                    polyLineOptions1.add(arrLocation.get(j));
                }


                if (mPolyline1 != null && mPolyline2 != null) {
                    mPolyline1.remove();
                    mPolyline1 = mMap.addPolyline(polyLineOptions1);
                    mPolyline2.remove();
                    mPolyline2 = mMap.addPolyline(polyLineOptions1);
                } else {
                    mPolyline1 = mMap.addPolyline(polyLineOptions1);
                    mPolyline2 = mMap.addPolyline(polyLineOptions1);
                }


                //
                mMap.moveCamera(CameraUpdateFactory.newLatLng(currentPosition));

                // Repeat till progress is complete.
                if (t < 1) {
                    // Post again 10ms later.
                    handler.postDelayed(this, 10);
                } else {

                    if ((i + 1) < arrLocation.size() - 1) {
                        setI(i + 1);
                        setStart(SystemClock.uptimeMillis());
                        handler.postDelayed(this, 10);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        handler.post(threadLocation);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng myLocation  = new LatLng(10.852667, 106.629065);
        mMap.addMarker(new MarkerOptions().position(myLocation).
                icon(BitmapDescriptorFactory.fromBitmap(
                        createCustomMylocationMarker(RepairMovingActivity.this,0,"")))).setTitle("");
        repairmanMovingToCustomer();

    }
}
