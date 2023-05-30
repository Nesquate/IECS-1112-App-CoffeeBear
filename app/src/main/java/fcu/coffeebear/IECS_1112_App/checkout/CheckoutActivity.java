package fcu.coffeebear.IECS_1112_App.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

import fcu.coffeebear.IECS_1112_App.R;

public class CheckoutActivity extends AppCompatActivity {

    TextView tvOrderNum;
    RadioButton rbCreditCard;
    RadioButton rbCash;
    Button btnNext;
    LinearLayout llCreditCard;

    int orderNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tvOrderNum = findViewById(R.id.tv_oder_number);
        rbCreditCard = findViewById(R.id.rb_credit_card);
        rbCash = findViewById(R.id.rb_cash);
        btnNext = findViewById(R.id.btn_next);
        llCreditCard = findViewById(R.id.ll_credit_card);

        llCreditCard.setVisibility(View.GONE);

        Random random = new Random();
        orderNum = random.nextInt(100000000) + 1;
        tvOrderNum.setText("訂單編號：#" + orderNum);


        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
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

        rbCash.setOnClickListener(listener);
        rbCreditCard.setOnClickListener(listener);
        btnNext.setOnClickListener(listener);
    }
}