package com.example.repairgrab.activity;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.repairgrab.R;

public class WaitingRepairActivity extends AppCompatActivity {

    LottieAnimationView mAnimationView, mAnimationViewCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_repair);

        mAnimationView = findViewById(R.id.animation_waiting_repair);
        mAnimationViewCheck = findViewById(R.id.animation_check);
        mAnimationView.setVisibility(View.VISIBLE);
        mAnimationView.playAnimation();
        mAnimationView.setRepeatCount(2);

        final TextView tv_contact = findViewById(R.id.tv_contact);

        mAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                tv_contact.setText("Thợ đã nhận được tin nhăn, chuẩn bị đễn chỗ bạn");
                mAnimationView.cancelAnimation();
                mAnimationView.setVisibility(View.GONE);
                mAnimationViewCheck.setVisibility(View.VISIBLE);
                mAnimationViewCheck.playAnimation();
                mAnimationViewCheck.setRepeatCount(1);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mAnimationViewCheck.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(getApplicationContext(), RepairMovingActivity.class);
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
