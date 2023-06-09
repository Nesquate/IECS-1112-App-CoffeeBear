package fcu.coffeebear.IECS_1112_App.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.addition.AdditionActivity;
import fcu.coffeebear.IECS_1112_App.model.Repositories;

public class FoodDetailActivity extends AppCompatActivity {

    private ImageView ivFoodImage;
    private TextView tvFoodName;
    private TextView tvFoodIntro;
    private TextView tvFoodPrice;
    private TextView tvFoodNumber;
    private Button btnAdd;
    private Button btnSub;

    private Button btnAdditional;
    private Button btnAddToCart;
    private String foodName;
    private String foodPrice;

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
        btnAdditional = findViewById(R.id.btn_additional);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);

        Intent intent = getIntent();
        foodName = intent.getStringExtra("foodName");
        foodPrice = intent.getStringExtra("foodPrice");
        ivFoodImage.setImageResource(Integer.parseInt(intent.getStringExtra("foodImage")));
        ivFoodImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tvFoodName.setText(foodName);
        tvFoodIntro.setText(intent.getStringExtra("foodDescription"));
        tvFoodPrice.setText("$ " + foodPrice);
        setTitle("詳細選項");

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

        btnAdditional.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, AdditionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("foodImage", intent.getStringExtra("foodImage"));
            bundle.putString("foodName", intent.getStringExtra("foodName"));
            bundle.putString("foodDescription", intent.getStringExtra("foodDescription"));

            intent1.putExtras(bundle);

            startActivity(intent1);
        });

        btnAddToCart.setOnClickListener(v -> {
            // TODO: 待購物車實做完成後將其串連
            Repositories.CART_REPOSITORY.addToCart(foodName, foodPrice, String.valueOf(count));
            this.finish();
        });
    }
}