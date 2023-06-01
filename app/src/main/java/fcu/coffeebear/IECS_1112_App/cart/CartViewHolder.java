package fcu.coffeebear.IECS_1112_App.cart;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.R;

public class CartViewHolder extends RecyclerView.ViewHolder {
    private RadioButton radioButton;
    private TextView price;
    private TextView additional;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        radioButton = itemView.findViewById(R.id.rb_cart_item);
        price = itemView.findViewById(R.id.tv_cart_price);
        additional = itemView.findViewById(R.id.tv_cart_addition);
    }

    public void bindViewHolder(HashMap<String, Object> product){
        String productName = (String)Objects.requireNonNull(product.get("name"));
        String productPrice = (String)Objects.requireNonNull(product.get("price"));
        ArrayList<String> productAdditional = (ArrayList<String>)product.get("additional");
        System.out.printf("DEBUG: %s %s%n",productName, productPrice);

        radioButton.setText(productName);
        price.setText("$"+productPrice);

        if(productAdditional != null){
            StringBuilder builder = new StringBuilder();

            for(String additional: productAdditional){
                builder.append("+").append(additional).append("\n");
            }
            additional.setText(builder.toString());
        } else{
            additional.setVisibility(View.GONE);
        }
    }
}
