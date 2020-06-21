package com.example.repairgrab.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.repairgrab.R;
import com.example.repairgrab.activity.DetailErrorActivity;
import com.example.repairgrab.activity.MapCustomerActivity;
import com.example.repairgrab.activity.ViewDetailErrorActivity;

public class ListOrderFragment extends Fragment {
    LottieAnimationView mAnimationView;
    LinearLayout listOrder;
    CardView cardView, cardView2, cardView3, cardView4;
    private Dialog khachlienhe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lisr_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.tv_an);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khachlienhe.show();
            }
        });

        khachlienhe = new Dialog(view.getContext());
        khachlienhe.setContentView(R.layout.dialog_nhancuoc);
        khachlienhe.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btn_xemchitiet = khachlienhe.findViewById(R.id.btn_xemchitiet);
        btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewDetailErrorActivity.class);
                startActivity(intent);
            }
        });

        listOrder = view.findViewById(R.id.list_order);
        listOrder.setVisibility(View.INVISIBLE);

        cardView = view.findViewById(R.id.card_detail_repair);
        cardView2 = view.findViewById(R.id.card_detail_repair2);
        cardView3 = view.findViewById(R.id.card_detail_repair3);
        cardView4 = view.findViewById(R.id.card_detail_repair4);

        mAnimationView = view.findViewById(R.id.animation_view);
        mAnimationView.setVisibility(View.VISIBLE);
        mAnimationView.playAnimation();
        mAnimationView.setRepeatCount(2);
        mAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimationView.setVisibility(View.GONE);
                listOrder.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapCustomerActivity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapCustomerActivity.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapCustomerActivity.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapCustomerActivity.class);
                startActivity(intent);
            }
        });

    }
}
