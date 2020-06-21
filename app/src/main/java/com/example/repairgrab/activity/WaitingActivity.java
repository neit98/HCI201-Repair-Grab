package com.example.repairgrab.activity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.repairgrab.R;

public class WaitingActivity extends AppCompatActivity {

    LottieAnimationView mAnimationView, mAnimationCheck;
    private Dialog thobaogia, review;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        textView = findViewById(R.id.txt_waiting);

        mAnimationView = findViewById(R.id.animation_waiting);
        mAnimationView.setVisibility(View.VISIBLE);
        mAnimationView.playAnimation();
        mAnimationView.setRepeatCount(8);

        mAnimationCheck = findViewById(R.id.animation_success);

        thobaogia = new Dialog(this);
        thobaogia.setContentView(R.layout.dialog_thobaogia);
        thobaogia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        review = new Dialog(this);
        review.setContentView(R.layout.dialog_review);
        review.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button dongy = thobaogia.findViewById(R.id.btn_chapnhan);
        dongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RepairMovingActivity.class);
                startActivity(intent);
            }
        });

        Button tuchoi = thobaogia.findViewById(R.id.btn_tuchoi);
        tuchoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thobaogia.cancel();
            }
        });

        Button danhgia = thobaogia.findViewById(R.id.btn_xemdanhgia);
        danhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review.show();
            }
        });

        Button close = review.findViewById(R.id.btn_close_review);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review.cancel();
            }
        });

        mAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimationView.setVisibility(View.GONE);
                mAnimationCheck.setVisibility(View.VISIBLE);
                mAnimationCheck.playAnimation();
                mAnimationCheck.setRepeatCount(1);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        Button find = findViewById(R.id.btn_find_myselft);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mAnimationCheck.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                textView.setText("Có thợ nhận sửa chữa cho bạn");
                mAnimationCheck.setVisibility(View.GONE);
                thobaogia.show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
