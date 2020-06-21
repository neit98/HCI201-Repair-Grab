package com.example.repairgrab.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.repairgrab.R;
import com.example.repairgrab.activity.LoginActivity;

public class RepairerAccountFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repairer_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView settingInfor = view.findViewById(R.id.tv_setting_infor);
        final Dialog inforDialog = new Dialog(view.getContext());
        inforDialog.setContentView(R.layout.dialog_setting_infor_repairer);
        inforDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        settingInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inforDialog.show();
            }
        });

        TextView settingWork = view.findViewById(R.id.tv_setting_work);
        final  Dialog workDialog = new Dialog(view.getContext());
        workDialog.setContentView(R.layout.dialog_setting_work);
        workDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        settingWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workDialog.show();
            }
        });

        Button dangxuat = getActivity().findViewById(R.id.btn_dangxuat);
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
