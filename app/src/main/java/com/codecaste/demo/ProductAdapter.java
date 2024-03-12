package com.codecaste.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductItem> productItemList;

    public ProductAdapter(List<ProductItem> productItemList) {
        this.productItemList = productItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_api, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem productItem = productItemList.get(position);

        holder.textTitle.setText(productItem.getTitle());
        holder.textDescription.setText(productItem.getDescription());
        holder.textPrice.setText(String.format("$%.2f", productItem.getPrice()));
        holder.textRating.setText(String.format("%.2f", productItem.getRating()));
        holder.textStock.setText(String.format("Stock: %d", productItem.getStock()));

        // Load thumbnail image using Picasso library
        Picasso.get().load(productItem.getThumbnail()).into(holder.imageThumbnail);

    }

    @Override
    public int getItemCount() {
        return productItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textDescription, textPrice, textRating, textStock;
        ImageView imageThumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            textPrice = itemView.findViewById(R.id.textPrice);
            textRating = itemView.findViewById(R.id.textRating);
            textStock = itemView.findViewById(R.id.textStock);
            imageThumbnail = itemView.findViewById(R.id.imageThumbnail);
        }
    }
}
