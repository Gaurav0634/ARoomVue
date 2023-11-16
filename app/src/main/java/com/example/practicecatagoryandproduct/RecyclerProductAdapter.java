package com.example.practicecatagoryandproduct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {

    Context context;
    ArrayList<ProductModel> arrProducts;

    RecyclerProductAdapter(Context context, ArrayList<ProductModel> arrProducts) {
        this.context = context;
        this.arrProducts = arrProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.productImage.setImageResource(arrProducts.get(position).img);
        holder.producTitle.setText(arrProducts.get(position).title);
        holder.productPrice.setText(arrProducts.get(position).price);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                ProductModel product = arrProducts.get(position);
                openProductDetailActivity(product);
            }
        });
    }

    private void openProductDetailActivity(ProductModel product) {
        Intent intent = new Intent(context, ProductDetails.class);
        intent.putExtra("product_title", product.title);
        intent.putExtra("product_price", product.price);
        intent.putExtra("product_image",product.img);
        // Inside ProductActivity where you start ARView activity
        intent.putExtra("model_path", product.glbFileLocation); // Replace "sofa_chair.glb" with the actual GLB file path
        // You can also pass other product details here
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return arrProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView producTitle, productPrice;
        ImageView productImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            producTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);

        }
    }
}
