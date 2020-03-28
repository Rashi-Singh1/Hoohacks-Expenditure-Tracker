package com.example.expendituretracker;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Rp on 8/30/2016.
 */
public class Fragment_First extends Fragment {

    private View view;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);



//        SMSListener.bindListener(new Common.OTPListener() {
//            @Override
//            public void onOTPReceived(String extractedOTP) {
//                TextView simpleEditText = (TextView) view.findViewById(R.id.amount1);
//                simpleEditText.setText(extractedOTP);
//
//            }
//        });


        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();


        SMSListener.bindListener(new Common.OTPListener() {
            @Override
            public void onOTPReceived(String Name, String Amount) {





                    data.add(new DataModel(Name, Amount));




                adapter = new CustomAdapter(data);
                recyclerView.setAdapter(adapter);

//                TextView simpleEditText = (TextView) view.findViewById(R.id.amount1);
//                simpleEditText.setText(extractedOTP);

            }
        });








        return view;

    }
    }
