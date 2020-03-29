package com.example.expendituretracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddExpenseInfo extends AppCompatActivity {
    String category_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense_info);
        Intent intent = getIntent();
        category_name = intent.getStringExtra("category");

    }
}
