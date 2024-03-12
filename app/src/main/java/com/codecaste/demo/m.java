package com.codecaste.random;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class m extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<ProductItem> productItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productItemList = new ArrayList<>();
        productAdapter = new ProductAdapter(productItemList);
        recyclerView.setAdapter(productAdapter);

        fetchProductData();
    }

    private void fetchProductData() {
        // Replace "your_product_api_url" with your actual product API endpoint
        String apiUrl = "https://dummyjson.com/products/1";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                apiUrl,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parseProductApiResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(m.this, "Error fetching product data", Toast.LENGTH_SHORT).show();
                        Log.e("ProductData", "Error fetching product data: " + error.toString());
                    }
                });

        queue.add(jsonObjectRequest);
    }

    private void parseProductApiResponse(JSONObject response) {
        try {
            int id = response.getInt("id");
            String title = response.getString("title");
            String description = response.getString("description");
            double price = response.getDouble("price");
            double discountPercentage = response.getDouble("discountPercentage");
            double rating = response.getDouble("rating");
            int stock = response.getInt("stock");
            String brand = response.getString("brand");
            String category = response.getString("category");
            String thumbnail = response.getString("thumbnail");
            List<String> images = parseImages(response.getJSONArray("images"));

            ProductItem productItem = new ProductItem(id, title, description, price, discountPercentage,
                    rating, stock, brand, category, thumbnail, images);

            productItemList.add(productItem);
            productAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(m.this, "Error parsing product JSON", Toast.LENGTH_SHORT).show();
        }
    }

    private List<String> parseImages(JSONArray imagesArray) throws JSONException {
        List<String> imagesList = new ArrayList<>();
        for (int i = 0; i < imagesArray.length(); i++) {
            imagesList.add(imagesArray.getString(i));
        }
        return imagesList;
    }
}
