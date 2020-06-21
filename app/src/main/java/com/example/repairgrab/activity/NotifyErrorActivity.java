package com.example.repairgrab.activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.repairgrab.ImageUtils;
import com.example.repairgrab.R;
import com.example.repairgrab.fragment.ImageDialogFragment;

public class NotifyErrorActivity extends AppCompatActivity implements ImageDialogFragment.ClickEventListener {

    private ImageView imageView;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_error);

        Toolbar toolbar = findViewById(R.id.toolbar_notify);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button post = findViewById(R.id.btn_post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WaitingActivity.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.imgError);

        Button uploadImg = findViewById(R.id.btn_upload_img);
        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageDialogFragment imageDialogFragment = ImageDialogFragment.newInstance();
                
                imageDialogFragment.show(getSupportFragmentManager(), "image_dialog");
            }
        });

        videoView = findViewById(R.id.vdError);
    }

    @Override
    public void onFinishedPickingImages(String imagePath, Uri imageData) {
        if (imagePath != null) {
            imageView.setVisibility(View.VISIBLE);
            ImageUtils.setPicToImageView(imageView, imagePath);
        } else if (imageData != null){
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageURI(imageData);

        }
    }

    public void uploadVideo(View view) {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri uri = data.getData();
            try{
                videoView.setVisibility(View.VISIBLE);
                videoView.setVideoURI(uri);
                videoView.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
