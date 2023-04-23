package fcu.coffeebear.IECS_1112_App;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ListView lvFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_menu);

        lvFood = findViewById(R.id.lv_food);

        List<FoodItem> lsFoods = new ArrayList<FoodItem>();
        lsFoods.add(new FoodItem(R.drawable.original_eggroll,"原味蛋餅","Q彈餅皮配上濃郁蛋香",30));
        lsFoods.add(new FoodItem(R.drawable.corn_eggroll,"玉米蛋餅","香甜玉米粒搭配蛋餅",35));
        lsFoods.add(new FoodItem(R.drawable.hotdog_eggroll,"熱狗蛋餅","熱狗搭配蛋餅",35));
        lsFoods.add(new FoodItem(R.drawable.cheese_eggroll,"起司蛋餅","鹹香起司搭配蛋餅",40));
        lsFoods.add(new FoodItem(R.drawable.bacon_eggroll,"培根蛋餅","焦脆培根搭配蛋餅",40));
        lsFoods.add(new FoodItem(R.drawable.hash_brown_eggroll,"薯餅蛋餅","酥脆薯餅搭配蛋餅",45));

        ListViewAdapter adapter = new ListViewAdapter(this,lsFoods);
        lvFood.setAdapter(adapter);
    }
}