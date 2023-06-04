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
import android.widget.Toast;

import java.util.Random;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.home.HomeActivity;
import fcu.coffeebear.IECS_1112_App.model.Repositories;

public class CheckoutActivity extends AppCompatActivity {

    TextView tvOrderNum;
    TextView tvPrice;
    RadioButton rbCreditCard;
    RadioButton rbCash;
    LinearLayout llCreditCard;
    RadioButton rbCarrier;
    RadioButton rbReceipt;
    Button btnConfirm;
    LinearLayout llCarrier;
    RecyclerView recyclerView;

    int orderNum;
    int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tvOrderNum = findViewById(R.id.tv_oder_number);
        recyclerView = findViewById(R.id.rv_meals);
        tvPrice = findViewById(R.id.tv_total_price);
        rbCreditCard = findViewById(R.id.rb_credit_card);
        rbCash = findViewById(R.id.rb_cash);
        rbCarrier = findViewById(R.id.rb_carrier);
        rbReceipt = findViewById(R.id.rb_receipt);
        btnConfirm = findViewById(R.id.btn_confirm);
        llCarrier = (LinearLayout) findViewById(R.id.ll_carrier);
        llCarrier.setVisibility(View.GONE);
        llCreditCard = findViewById(R.id.ll_credit_card);

        llCreditCard.setVisibility(View.GONE);

        Random random = new Random();
        orderNum = random.nextInt(100000000) + 1;
        tvOrderNum.setText("訂單編號：#" + orderNum);

        CheckoutCartAdapter adapter = new CheckoutCartAdapter(Repositories.CART_REPOSITORY.getCartList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        totalPrice = adapter.getTotalPrice();
        tvPrice.setText("總金額：" + totalPrice + "元");

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.rb_credit_card) {
                    llCreditCard.setVisibility(View.VISIBLE);
                }
                if (v.getId() == R.id.rb_cash) {
                    llCreditCard.setVisibility(View.GONE);
                }
                if (v.getId() == R.id.rb_carrier) {
                    llCarrier.setVisibility(View.VISIBLE);
                }

                if (v.getId() == R.id.rb_receipt) {
                    llCarrier.setVisibility(View.GONE);
                }

                if (v.getId() == R.id.btn_confirm) {
                    Toast.makeText(CheckoutActivity.this,"已完成訂單",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CheckoutActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };

        rbCash.setOnClickListener(listener);
        rbCreditCard.setOnClickListener(listener);
        rbCarrier.setOnClickListener(listener);
        rbReceipt.setOnClickListener(listener);
        btnConfirm.setOnClickListener(listener);
    }
}