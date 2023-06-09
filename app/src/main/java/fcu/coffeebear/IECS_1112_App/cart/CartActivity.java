package fcu.coffeebear.IECS_1112_App.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.CartRepository;
import fcu.coffeebear.IECS_1112_App.model.Repositories;

public class CartActivity extends AppCompatActivity implements CartContract.ICartView {
    private CartContract.ICartPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        presenter = new CartPresenter(this, Repositories.CART_REPOSITORY);
        presenter.getCartData();

        setTitle("購物車");
    }

    @Override
    public void showCartList(ArrayList<HashMap<String, Object>> cartList) {
        RecyclerView recyclerView = findViewById(R.id.list_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartViewAdapter(cartList));
    }

    @Override
    public void updateTotalPrice(String price) {
        TextView tvPrice = findViewById(R.id.tv_cart_total_price);
        tvPrice.setText(price);
    }

}