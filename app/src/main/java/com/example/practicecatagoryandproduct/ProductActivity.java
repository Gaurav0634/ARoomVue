package com.example.practicecatagoryandproduct;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ArrayList<ProductModel> arrProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();
        String selectedCategory = intent.getStringExtra("selected_category");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Depending on the selected category, populate arrProducts with appropriate data
        populateProductData(selectedCategory);

        RecyclerProductAdapter adapter = new RecyclerProductAdapter(this, arrProducts);
        recyclerView.setAdapter(adapter);
    }

    private void populateProductData(String category) {
        // Clear the existing data
        arrProducts.clear();

        // Add product data based on the selected category
        if ("Living Room".equals(category)) {
            arrProducts.add(new ProductModel("Comfortable 3-Seater Sofa in Elegant Steel Grey Fabric", "299.99", R.drawable.sofa, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Modern Coffee Table with Sleek Design for Stylish Living Spaces", "99.99", R.drawable.coffee_table, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Cozy Accent Chair for Relaxing in Contemporary Home Settings", "59.99", R.drawable.chair, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("L-Shaped Sectional Sofa for Versatile and Trendy Living Rooms", "100.99", R.drawable.sectional_sofa, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Sleek TV Stand with Minimalist Aesthetics for Entertainment Areas", "9.99", R.drawable.tv_stand, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Stylish Book Shelves for Organizing and Displaying Your Literary Collection", "478.99", R.drawable.bookshelves, "sofa_chair.glb"));

            // Add more living room products as needed
        } else if ("Bed Room".equals(category)) {
            arrProducts.add(new ProductModel("Bed", "399.99", R.drawable.sofa, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Nightstand", "49.99", R.drawable.sofa, "sofa_chair.glb"));
            // Add more bedroom products as needed
        } else if ("Kitchen".equals(category)) {
            arrProducts.add(new ProductModel("Dining Table", "199.99", R.drawable.sofa, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Chairs", "39.99", R.drawable.sofa, "sofa_chair.glb"));
            // Add more kitchen products as needed
        } else if ("Office".equals(category)) {
            arrProducts.add(new ProductModel("Desk", "149.99", R.drawable.sofa, "sofa_chair.glb"));
            arrProducts.add(new ProductModel("Office Chair", "79.99", R.drawable.sofa, "sofa_chair.glb"));
            // Add more office products as needed
        }
    }
}
