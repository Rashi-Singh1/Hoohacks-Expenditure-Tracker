package com.example.expendituretracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button scan_bill, add_manual_entry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan_bill = findViewById(R.id.scan_bill);
        add_manual_entry = findViewById(R.id.add_manual_entry);

        scan_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageToTextVisionAIActivity.class);
                startActivity(intent);
            }
        });

        add_manual_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityScanBill.class);
                startActivity(intent);
            }
        });
    }
}
