package fcu.coffeebear.IECS_1112_App.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;

public class CartViewAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private ArrayList<HashMap<String, Object>> cartList;

    public CartViewAdapter(ArrayList<HashMap<String, Object>> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.item_cart_cartitem,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        ((CartViewHolder) holder).bindViewHolder(cartList.get(position));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
