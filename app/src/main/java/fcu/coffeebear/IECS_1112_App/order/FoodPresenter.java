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
            case 1: //egg roll
                foodItems.add(new FoodItem(R.drawable.original_eggroll, "原味蛋餅", "Q彈餅皮配上濃郁蛋香", 30));
                foodItems.add(new FoodItem(R.drawable.corn_eggroll, "玉米蛋餅", "香甜玉米粒搭配蛋餅", 35));
                foodItems.add(new FoodItem(R.drawable.hotdog_eggroll, "熱狗蛋餅", "熱狗搭配蛋餅", 35));
                foodItems.add(new FoodItem(R.drawable.cheese_eggroll, "起司蛋餅", "鹹香起司搭配蛋餅", 40));
                foodItems.add(new FoodItem(R.drawable.bacon_eggroll, "培根蛋餅", "焦脆培根搭配蛋餅", 40));
                foodItems.add(new FoodItem(R.drawable.hash_brown_eggroll, "薯餅蛋餅", "酥脆薯餅搭配蛋餅", 45));
                foodItems.add(new FoodItem(R.drawable.bacon_eggroll, "鮪魚蛋餅", "營養鮪魚搭配蛋餅", 45));
                break;
            case 2: //burger
                foodItems.add(new FoodItem(R.drawable.pork_burger, "豬肉漢堡", "鬆軟漢堡，簡單調味的豬肉，配上清爽生菜", 35));
                foodItems.add(new FoodItem(R.drawable.chicken_burger, "香雞漢堡", "鬆軟漢堡，酥脆雞肉，配上清爽生菜", 35));
                foodItems.add(new FoodItem(R.drawable.bacon_burger, "培根漢堡", "鬆軟漢堡，焦脆培根，配上清爽生菜", 45));
                foodItems.add(new FoodItem(R.drawable.smoked_chicken_burger, "燻雞漢堡", "鬆軟漢堡，煙燻雞肉，配上清爽生菜", 45));
                foodItems.add(new FoodItem(R.drawable.crispy_chicken_burger, "卡拉雞腿堡", "漢堡搭配酥脆的雞腿排，配上清爽生菜解膩", 60));
                foodItems.add(new FoodItem(R.drawable.beef_burger, "牛肉漢堡", "鬆軟漢堡，香煎牛肉，配上清爽生菜", 65));
                break;
            case 3: //toast
                foodItems.add(new FoodItem(R.drawable.chocolate_toast, "巧克力吐司", "烤到微焦吐司，抹上香甜巧克力醬", 20));
                foodItems.add(new FoodItem(R.drawable.strawberry_tosat, "草莓吐司", "烤到微焦吐司，抹上酸甜草莓醬", 20));
                foodItems.add(new FoodItem(R.drawable.peanut_toast, "花生吐司", "烤到微焦吐司，抹上濃郁花生醬", 20));
                foodItems.add(new FoodItem(R.drawable.pork_toast, "豬肉吐司", "烤到微焦吐司，簡單調味的豬肉，配上清爽生菜", 35));
                foodItems.add(new FoodItem(R.drawable.chicken_toast, "香雞吐司", "烤到微焦吐司，酥脆雞肉，配上清爽生菜", 35));
                foodItems.add(new FoodItem(R.drawable.floss_toast, "肉鬆吐司", "烤到微焦吐司，配上肉鬆清爽生菜", 40));
                foodItems.add(new FoodItem(R.drawable.bacon_toast, "培根吐司", "烤到微焦吐司，焦脆培根，配上清爽生菜", 45));
                foodItems.add(new FoodItem(R.drawable.smoked_chicken_toast, "燻雞吐司", "烤到微焦吐司，煙燻雞肉，配上清爽生菜", 45));
                foodItems.add(new FoodItem(R.drawable.crispy_chicken_toast, "卡拉雞腿吐司", "烤到微焦吐司搭配酥脆的雞腿排，配上清爽解膩的生菜", 60));
                break;
            case 4: //snack
                foodItems.add(new FoodItem(R.drawable.hash_brown, "薯餅", "酥脆薯餅", 20));
                foodItems.add(new FoodItem(R.drawable.hotdog, "小熱狗", "一份4條", 30));
                foodItems.add(new FoodItem(R.drawable.dumpling, "煎餃", "一份5顆", 35));
                foodItems.add(new FoodItem(R.drawable.french_fried, "薯條", "香酥的外衣，鬆軟的馬鈴薯", 35));
                foodItems.add(new FoodItem(R.drawable.white_radish_cake, "蘿蔔糕", "外酥內軟的蘿蔔糕", 35));
                foodItems.add(new FoodItem(R.drawable.chicken_nugget, "雞塊", "一份5塊", 40));
                break;
            case 5: //drink
                foodItems.add(new FoodItem(R.drawable.black_tea, "紅茶", "古早味紅茶", 20));
                foodItems.add(new FoodItem(R.drawable.soymilk, "豆漿", "濃郁滑順的豆漿", 20));
                foodItems.add(new FoodItem(R.drawable.green_tea, "綠茶", "清新茶香", 20));
                foodItems.add(new FoodItem(R.drawable.milk_tea, "奶茶", "茶香與奶香完美融合", 25));
                foodItems.add(new FoodItem(R.drawable.peanut_rice_milk, "米漿", "濃醇米漿", 25));
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
