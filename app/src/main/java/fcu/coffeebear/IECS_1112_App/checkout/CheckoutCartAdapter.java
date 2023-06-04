package fcu.coffeebear.IECS_1112_App.checkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.cart.CartViewHolder;

public class CheckoutCartAdapter extends RecyclerView.Adapter<CheckoutCartViewHolder> {
    private ArrayList<HashMap<String, Object>> cartList;

    public CheckoutCartAdapter(ArrayList<HashMap<String, Object>> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CheckoutCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkout_cartitem, parent, false);
        return new CheckoutCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutCartViewHolder holder, int position) {
//        HashMap<String, Object> cartItem = cartList.get(position);
//        holder.bindViewHolder(cartItem);

        ((CheckoutCartViewHolder) holder).bindViewHolder(cartList.get(position));
    }


    @Override
    public int getItemCount() {
        if (cartList.size() == 0)
            return 0;
        return cartList.size();
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (HashMap<String, Object> cartItem : cartList) {
            String price = (String) cartItem.get("price");
            totalPrice += Integer.parseInt(price);
        }
        return totalPrice;
    }
}
