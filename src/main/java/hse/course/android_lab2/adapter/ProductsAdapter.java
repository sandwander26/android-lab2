package hse.course.android_lab2.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hse.course.android_lab2.R;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    private final List<String> products;

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {

        private final TextView product;

        private final Button removeProductButton;

        public ProductsViewHolder(View view) {
            super(view);
            product = (TextView) view.findViewById(R.id.product);
            removeProductButton = (Button) view.findViewById(R.id.removeProductButton);
        }

        public TextView getProduct() {
            return product;
        }

        public Button getRemoveProductButton() {
            return removeProductButton;
        }
    }

    public ProductsAdapter(List<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getProduct().setText(products.get(position));
        holder.getRemoveProductButton().setOnClickListener(v -> removeProduct(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addNewProduct(String productName) {
        if (productName == null || productName.isEmpty()) {
            return;
        }
        products.add(productName);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void removeProduct(int position) {
        products.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearAllProducts() {
        products.clear();
        notifyDataSetChanged();
    }
}