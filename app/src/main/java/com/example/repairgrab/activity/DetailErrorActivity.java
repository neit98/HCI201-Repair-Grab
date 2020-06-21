package com.example.repairgrab.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.repairgrab.R;

public class DetailErrorActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private Dialog baogiaDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_error);

        Toolbar toolbar = findViewById(R.id.toolbar_detail_error);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        videoView = findViewById(R.id.video_view);
        if (mediaController == null) {
            mediaController = new MediaController(DetailErrorActivity.this);

            // Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(videoView);


            // Sét đặt bộ điều khiển cho VideoView.
            videoView.setMediaController(mediaController);
        }


        try {
            // ID của file video.
            int id = this.getRawResIdByName("beptu");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            //Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();

        // Sự kiện khi file video sẵn sàng để chơi.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView.start();


                // Khi màn hình Video thay đổi kích thước
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        baogiaDialog = new Dialog(this);
        baogiaDialog.setContentView(R.layout.dialog_baogia);
        baogiaDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button baogia = baogiaDialog.findViewById(R.id.btn_baogia);
        Button baogiasau = baogiaDialog.findViewById(R.id.btn_baogiasau);

        baogia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WaitingCustomerAcceptActivity.class);
                startActivity(intent);
            }
        });

        baogiasau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WaitingCustomerAcceptActivity.class);
                startActivity(intent);
            }
        });
    }

    // Tìm ID ứng với tên của file nguồn (Trong thư mục raw).
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        //Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    public void acceptRepair(View view) {
        baogiaDialog.show();
    }


}
