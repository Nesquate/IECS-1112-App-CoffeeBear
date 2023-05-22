package fcu.coffeebear.IECS_1112_App.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fcu.coffeebear.IECS_1112_App.R;

public class FoodDetailActivity extends AppCompatActivity {

    private ImageView ivFoodImage;
    private TextView tvFoodName;
    private TextView tvFoodIntro;
    private TextView tvFoodPrice;
    private TextView tvFoodNumber;
    private Button btnAdd;
    private Button btnSub;

    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        ivFoodImage = findViewById(R.id.iv_food_image_detail);
        tvFoodName = findViewById(R.id.tv_food_name_detail);
        tvFoodIntro = findViewById(R.id.tv_food_description_detail);
        tvFoodPrice = findViewById(R.id.tv_food_price_detail);
        tvFoodNumber = findViewById(R.id.tv_food_num);
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);

        Intent intent = getIntent();
        ivFoodImage.setImageResource(Integer.parseInt(intent.getStringExtra("foodImage")));
        ivFoodImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tvFoodName.setText(intent.getStringExtra("foodName"));
        tvFoodIntro.setText(intent.getStringExtra("foodDescription"));
        tvFoodPrice.setText("$ " + intent.getStringExtra("foodPrice"));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_add) {
                    count++;
                    tvFoodNumber.setText(Integer.toString(count));
                } else if (v.getId() == R.id.btn_sub) {
                    count--;
                    if (count < 1)
                        count = 1;
                    tvFoodNumber.setText(Integer.toString(count));
                }
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
    }
}