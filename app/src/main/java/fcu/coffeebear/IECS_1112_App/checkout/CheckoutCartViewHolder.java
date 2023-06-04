package fcu.coffeebear.IECS_1112_App.checkout;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;

public class CheckoutCartViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView price;
    private TextView count;

    public CheckoutCartViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_checkout_name);
        price = itemView.findViewById(R.id.tv_checkout_price);
        count = itemView.findViewById(R.id.tv_checkout_count);
    }

    public void bindViewHolder(HashMap<String, Object> product) {
        String mealName = (String) product.get("name");
        String mealPrice = (String) product.get("price");
        String mealCount = (String) product.get("count");

        name.setText(mealName);
        count.setText("x" + mealCount);
        price.setText("$" + mealPrice);
    }
}
