package com.example.practicecatagoryandproduct;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Category extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inside your activity's onCreate() method

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button livingRoomButton = findViewById(R.id.livingRoomButton);
        Button bedRoomButton = findViewById(R.id.bedRoomButton);
        Button kitchenButton = findViewById(R.id.kitchenButton);
        Button officeButton = findViewById(R.id.officeButton);

        livingRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProductActivity("Living Room");
            }
        });

        bedRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProductActivity("Bed Room");
            }
        });

        kitchenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProductActivity("Kitchen");
            }
        });

        officeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProductActivity("Office");
            }
        });
    }

    private void startProductActivity(String category) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("selected_category", category);
        startActivity(intent);
    }
}
