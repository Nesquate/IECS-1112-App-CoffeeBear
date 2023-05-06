package fcu.coffeebear.IECS_1112_App.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.adapter.FoodAdapter;

public class MenuActivity extends AppCompatActivity {

    private ListView lvFoods;
    private Button btnEggroll;
    private Button btnBurger;
    private Button btnToast;
    private Button btnSnack;
    private Button btnDrink;
    private Button btnCart;
    private Button btnCheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_menu);

        lvFoods = findViewById(R.id.lv_foods);
        btnEggroll = findViewById(R.id.btn_eggroll);
        btnBurger = findViewById(R.id.btn_burger);
        btnToast = findViewById(R.id.btn_toast);
        btnSnack = findViewById(R.id.btn_snack);
        btnDrink = findViewById(R.id.btn_drink);

        List<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems.add(new FoodItem(R.drawable.original_eggroll, "原味蛋餅", "Q彈餅皮配上濃郁蛋香", 30));
        foodItems.add(new FoodItem(R.drawable.corn_eggroll, "玉米蛋餅", "香甜玉米粒搭配蛋餅", 35));
        foodItems.add(new FoodItem(R.drawable.hotdog_eggroll, "熱狗蛋餅", "熱狗搭配蛋餅", 35));
        foodItems.add(new FoodItem(R.drawable.cheese_eggroll, "起司蛋餅", "鹹香起司搭配蛋餅", 40));
        foodItems.add(new FoodItem(R.drawable.bacon_eggroll, "培根蛋餅", "焦脆培根搭配蛋餅", 40));
        foodItems.add(new FoodItem(R.drawable.hash_brown_eggroll, "薯餅蛋餅", "酥脆薯餅搭配蛋餅", 45));


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_burger:
                        foodItems.clear();
                        foodItems.add(new FoodItem(R.drawable.original_eggroll, "原味蛋餅", "Q彈餅皮配上濃郁蛋香", 30));
                        foodItems.add(new FoodItem(R.drawable.corn_eggroll, "玉米蛋餅", "香甜玉米粒搭配蛋餅", 35));
                        break;
                    case R.id.btn_toast:
                        foodItems.add(new FoodItem(R.drawable.cheese_eggroll, "起司蛋餅", "鹹香起司搭配蛋餅", 40));
                        break;
                }
            }
        };

        btnEggroll.setOnClickListener(listener);
        btnBurger.setOnClickListener(listener);
        btnToast.setOnClickListener(listener);

        FoodAdapter adapter = new FoodAdapter(this, foodItems);
        lvFoods.setAdapter(adapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MenuActivity.this, FoodDetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("foodName", foodItems.get(position).getFoodName());
                bundle.putString("foodDescription", foodItems.get(position).getFoodIntro());
                String price = Integer.toString(foodItems.get(position).getFoodPrice());
                bundle.putString("foodPrice", price);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        lvFoods.setOnItemClickListener(onItemClickListener);
    }
}