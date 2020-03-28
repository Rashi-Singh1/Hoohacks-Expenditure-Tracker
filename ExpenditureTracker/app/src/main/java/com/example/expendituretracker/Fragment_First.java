package com.example.expendituretracker;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Rp on 8/30/2016.
 */
public class Fragment_First extends Fragment {

    private View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);

        SMSListener.bindListener(new Common.OTPListener() {
            @Override
            public void onOTPReceived(String extractedOTP) {
                TextView simpleEditText = (TextView) view.findViewById(R.id.amount1);
                simpleEditText.setText(extractedOTP);

            }
        });

        return view;

    }
    }
