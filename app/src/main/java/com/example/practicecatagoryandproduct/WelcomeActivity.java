package com.example.practicecatagoryandproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView welcomeImage = findViewById(R.id.welcomeImage);


    }
    public void openCategoryActivity(View view){

        //new intent to navigate to category activity
        Intent intent = new Intent(this, Category.class);
        startActivity(intent);
    }
}