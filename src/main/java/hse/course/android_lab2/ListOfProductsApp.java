package hse.course.android_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hse.course.android_lab2.adapter.ProductsAdapter;

public class ListOfProductsApp extends AppCompatActivity {

    private ProductsAdapter productsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.list_of_products_app_layout);

        RecyclerView recyclerView = findViewById(R.id.productsRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        productsAdapter = new ProductsAdapter(new ArrayList<>());
        recyclerView.setAdapter(productsAdapter);

        super.onCreate(savedInstanceState);
    }

    public void saveProduct(View view) {
        EditText productEditText = findViewById(R.id.productEditText);
        String productName = productEditText.getText().toString();
        productEditText.setText("");

        productsAdapter.addNewProduct(productName);
    }

    public void clearAllProducts(View view) {
        productsAdapter.clearAllProducts();
    }
}
