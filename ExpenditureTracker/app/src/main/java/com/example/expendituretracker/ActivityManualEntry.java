package com.example.expendituretracker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;

public class ActivityManualEntry extends AppCompatActivity {
    Button next, add_custom_category;
    String category = "";
    int category_count = 16;
    ArrayList<Button> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);
        categories = new ArrayList<>();
        initialize_category_buttons();
        next = findViewById(R.id.next);
        add_custom_category = findViewById(R.id.add_category);
        add_custom_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!category.equals("")) {
                    Intent intent = new Intent(ActivityManualEntry.this, AddExpenseInfo.class);
                    intent.putExtra("category", category);
                    startActivity(intent);
                    finish();
                }
                else Toast.makeText(ActivityManualEntry.this,"Please choose a category", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void openDialog() {
        AppCompatDialogFragment dialog = new PopupDialog();
    }

    public void initialize_category_buttons(){
        Button car = findViewById(R.id.car);
        Button house = findViewById(R.id.house);
        Button food = findViewById(R.id.food);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "car";
            }
        });
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "house";
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "food";
            }
        });
        categories.add(car);
        categories.add(house);
        categories.add(food);
    }

    public class PopupDialog extends AppCompatDialogFragment {
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            final EditText category_name = new EditText(getActivity());
            builder.setTitle("Add Custom Category")
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            category = category_name.getText().toString().trim();
                            if(category.equals("")){
                                Toast.makeText(getActivity(),"Please enter the category name", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                dialog.dismiss();
                            }
                        }
                    });
            builder.setView(category_name);
            builder.show();
            return builder.create();
        }
    }

}
