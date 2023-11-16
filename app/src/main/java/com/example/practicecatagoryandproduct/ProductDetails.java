package com.example.practicecatagoryandproduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import io.github.sceneview.sample.armodelviewer.ARView;

public class ProductDetails extends AppCompatActivity implements PaymentResultListener {
    private Button payButton1;
    Button tryOnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ImageView productImageDetail = findViewById(R.id.productImageDetail);
        TextView productTitleDetail = findViewById(R.id.productTitleDetail);
        TextView productPriceDetail = findViewById(R.id.productPriceDetail);
        tryOnButton = findViewById(R.id.tryOnButton);


        tryOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(ProductDetails.this, ARView.class);
                startActivity(intent);

                intent.putExtra("model_path", "your_glb_file_location_here.glb");
                startActivity(intent);}
        });
// Receive the product details from the intent
        Intent intent = getIntent();
        String productTitle = intent.getStringExtra("product_title");
        String productPrice = intent.getStringExtra("product_price");
        int productImage = intent.getIntExtra("product_image", R.drawable.app_logo);

         // Assuming "product_image" is the key

// Set the product details in the detail page
        productTitleDetail.setText(productTitle);
        productPriceDetail.setText(productPrice);
        productImageDetail.setImageResource(productImage); // Set the image in ImageView

        payButton1 = findViewById(R.id.payButton1);
        // adding on click listener to our button.
        payButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String samount = productPrice;

                // rounding off the amount.
                int amount = Math.round(Float.parseFloat(samount) * 100);

                // initialize Razorpay account.
                Checkout checkout = new Checkout();

                // set your id as below
                checkout.setKeyID("rzp_test_7H8FlyhUFiwYtC");

                // set image


                // initialize json object
                JSONObject object = new JSONObject();
                try {
                    // to put name
                    object.put("name", "ARoomVue");

                    // put description
                    object.put("description", "Test payment");

                    // to set theme color
                    object.put("theme.color", "");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", "9575425576");

                    // put email
                    object.put("prefill.email", "gauravomen@gmail.com");

                    // open razorpay to checkout activity
                    checkout.open(ProductDetails.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}

        // Load and display the product image if needed
