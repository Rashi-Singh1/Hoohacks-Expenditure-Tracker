package com.example.expendituretracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewAmount;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.sms_name);
            this.textViewAmount = (TextView) itemView.findViewById(R.id.sms_amount);

        }
    }
        public CustomAdapter(ArrayList<DataModel> data) {
            this.dataSet = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_layout, parent, false);



            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

            TextView textViewName = holder.textViewName;
            TextView textViewAmount = holder.textViewAmount;


            textViewName.setText(dataSet.get(listPosition).getName());
            textViewAmount.setText(dataSet.get(listPosition).getAmount());

        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }
    }
