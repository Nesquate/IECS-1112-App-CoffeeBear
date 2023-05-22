package fcu.coffeebear.IECS_1112_App.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.FoodItem;

public class FoodPresenter implements MenuContract.MenuPresenter {

    List<FoodItem> foodItems;
    MenuContract.MenuView menuView;
    private Context context;

    public FoodPresenter(MenuContract.MenuView menuView,Context context) {
        foodItems = new ArrayList<>();
        this.menuView = menuView;
        this.context = context;
    }

    @Override
    public void loadFoodItems(int categoryId) {
        foodItems.clear();
        switch (categoryId) {
            case 1: //eggroll
                foodItems.add(new FoodItem(R.drawable.original_eggroll, "原味蛋餅", "Q彈餅皮配上濃郁蛋香", 30));
                foodItems.add(new FoodItem(R.drawable.corn_eggroll, "玉米蛋餅", "香甜玉米粒搭配蛋餅", 35));
                foodItems.add(new FoodItem(R.drawable.hotdog_eggroll, "熱狗蛋餅", "熱狗搭配蛋餅", 35));
                foodItems.add(new FoodItem(R.drawable.cheese_eggroll, "起司蛋餅", "鹹香起司搭配蛋餅", 40));
                foodItems.add(new FoodItem(R.drawable.bacon_eggroll, "培根蛋餅", "焦脆培根搭配蛋餅", 40));
                foodItems.add(new FoodItem(R.drawable.hash_brown_eggroll, "薯餅蛋餅", "酥脆薯餅搭配蛋餅", 45));
                break;
            case 2: //burger
                foodItems.add(new FoodItem(R.drawable.bacon_eggroll, "培根蛋餅", "焦脆培根搭配蛋餅", 40));
                foodItems.add(new FoodItem(R.drawable.hash_brown_eggroll, "薯餅蛋餅", "酥脆薯餅搭配蛋餅", 45));
                break;
            case 3: //toast
                foodItems.add(new FoodItem(R.drawable.hotdog_eggroll, "熱狗蛋餅", "熱狗搭配蛋餅", 35));
                break;
            case 4: //snack
                foodItems.add(new FoodItem(R.drawable.hotdog_eggroll, "熱狗蛋餅", "熱狗搭配蛋餅", 35));
                break;
            case 5: //drink
                foodItems.add(new FoodItem(R.drawable.hotdog_eggroll, "熱狗蛋餅", "熱狗搭配蛋餅", 35));
                break;
        }

        menuView.displayFoodItem(foodItems);
    }


    @Override
    public void selectedFoodItem(int position) {
        Intent intent = new Intent(context, FoodDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("foodImage", String.valueOf(foodItems.get(position).getImageId()));
        bundle.putString("foodName", foodItems.get(position).getFoodName());
        bundle.putString("foodDescription", foodItems.get(position).getFoodIntro());
        String price = Integer.toString(foodItems.get(position).getFoodPrice());
        bundle.putString("foodPrice", price);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
