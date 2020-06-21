package com.example.repairgrab.activity;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.repairgrab.R;

public class WaitingCustomerAcceptActivity extends AppCompatActivity {

    LottieAnimationView mAnimationView, mAnimationCheck;
    private TextView phanhoi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_customer_accept);

        phanhoi = findViewById(R.id.tv_phanhoi);

        mAnimationView = findViewById(R.id.animation_waiting_customer);
        mAnimationView.setVisibility(View.VISIBLE);
        mAnimationView.playAnimation();
        mAnimationView.setRepeatCount(2);

        mAnimationCheck = findViewById(R.id.animation_success_customer);

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

        mAnimationCheck.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                phanhoi.setText("Khách hàng đã đồng ý sửa chữa");
                mAnimationCheck.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(), MovingToCustomerActivity.class);
                startActivity(intent);
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
