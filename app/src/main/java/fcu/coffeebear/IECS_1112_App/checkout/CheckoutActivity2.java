package fcu.coffeebear.IECS_1112_App.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.home.HomeActivity;

public class CheckoutActivity2 extends AppCompatActivity {

    RadioButton rbCarrier;
    RadioButton rbReceipt;
    Button btnConfirm;
    LinearLayout llCarrier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout2);

        rbCarrier = findViewById(R.id.rb_carrier);
        rbReceipt = findViewById(R.id.rb_receipt);
        btnConfirm = findViewById(R.id.btn_confirm);
        llCarrier = (LinearLayout) findViewById(R.id.ll_carrier);
        llCarrier.setVisibility(View.GONE);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.rb_carrier) {
                    llCarrier.setVisibility(View.VISIBLE);
                }

                if (v.getId() == R.id.rb_receipt) {
                    llCarrier.setVisibility(View.GONE);
                }

                if (v.getId() == R.id.btn_confirm) {
                    Toast.makeText(CheckoutActivity2.this,"已完成訂單",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CheckoutActivity2.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };

        rbCarrier.setOnClickListener(listener);
        rbReceipt.setOnClickListener(listener);
        btnConfirm.setOnClickListener(listener);
    }
}