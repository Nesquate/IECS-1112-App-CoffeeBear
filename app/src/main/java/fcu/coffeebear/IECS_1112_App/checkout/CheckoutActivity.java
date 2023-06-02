package fcu.coffeebear.IECS_1112_App.checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.cart.CartContract;
import fcu.coffeebear.IECS_1112_App.cart.CartViewAdapter;
import fcu.coffeebear.IECS_1112_App.store.SelectStoreActivity;

public class CheckoutActivity extends AppCompatActivity implements CartContract.ICartView {

    TextView tvOrderNum;
    TextView tvPrice;
    TextView tvStore;
    RadioButton rbCreditCard;
    RadioButton rbCash;
    Button btnNext;
    Button btnSelectStore;
    LinearLayout llCreditCard;

    int orderNum;
    private CartContract.ICartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tvOrderNum = findViewById(R.id.tv_oder_number);
        tvPrice = findViewById(R.id.tv_total_price);
        tvStore = findViewById(R.id.tv_store);
        rbCreditCard = findViewById(R.id.rb_credit_card);
        rbCash = findViewById(R.id.rb_cash);
        btnSelectStore = findViewById(R.id.btn_select_store);
        btnNext = findViewById(R.id.btn_next);
        llCreditCard = findViewById(R.id.ll_credit_card);

        llCreditCard.setVisibility(View.GONE);

        Random random = new Random();
        orderNum = random.nextInt(100000000) + 1;
        tvOrderNum.setText("訂單編號：#" + orderNum);


        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                if (v.getId() == R.id.btn_select_store) {
//                    Intent intent = new Intent(CheckoutActivity.this, SelectStoreActivity.class);
//                    startActivity(intent);
//                }
                if (v.getId() == R.id.rb_credit_card) {
                    llCreditCard.setVisibility(View.VISIBLE);
                }
                if (v.getId() == R.id.rb_cash) {
                    llCreditCard.setVisibility(View.GONE);
                }
                if (v.getId() == R.id.btn_next) {
                    Intent intent = new Intent(CheckoutActivity.this, CheckoutActivity2.class);
                    startActivity(intent);
                }
            }
        };

//        btnSelectStore.setOnClickListener(listener);
        rbCash.setOnClickListener(listener);
        rbCreditCard.setOnClickListener(listener);
        btnNext.setOnClickListener(listener);
    }

    @Override
    public void showCartList(ArrayList<HashMap<String, Object>> cartList) {
        RecyclerView recyclerView = findViewById(R.id.rv_meals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartViewAdapter(cartList));
    }

    @Override
    public void updateTotalPrice(String price) {
        tvPrice.setText("總金額：" + price + "元");
    }
}