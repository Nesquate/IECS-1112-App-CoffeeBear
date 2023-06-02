package fcu.coffeebear.IECS_1112_App.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.checkout.CheckoutActivity;
import fcu.coffeebear.IECS_1112_App.model.FoodItem;
import fcu.coffeebear.IECS_1112_App.model.Repositories;

public class MenuActivity extends AppCompatActivity implements MenuContract.MenuView {

    private ListView lvFoods;
    private Button btnEggroll;
    private Button btnBurger;
    private Button btnToast;
    private Button btnSnack;
    private Button btnDrink;
    private Button btnCart;
    private Button btnCheckOut;

    private FoodAdapter adapter;
    private TextView tvFoodNumberOrders;

    int categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_menu);

        lvFoods = findViewById(R.id.lv_food);
        btnEggroll = findViewById(R.id.category_eggroll);
        btnBurger = findViewById(R.id.category_burger);
        btnToast = findViewById(R.id.category_toast);
        btnSnack = findViewById(R.id.category_snack);
        btnDrink = findViewById(R.id.category_drinks);
        btnCheckOut = findViewById(R.id.btn_checkout);
        tvFoodNumberOrders = findViewById(R.id.tv_number_orders);

        List<FoodItem> foodItems = new ArrayList<FoodItem>();
        MenuContract.MenuPresenter menuPresenter = new FoodPresenter(this,MenuActivity.this);
        adapter = new FoodAdapter(this, foodItems);
        lvFoods.setAdapter(adapter);

        if (categoryId <= 0 || categoryId > 5)
            categoryId = 1;
        menuPresenter.loadFoodItems(categoryId);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.category_eggroll:
                        categoryId = 1;
                        menuPresenter.loadFoodItems(categoryId);
                        break;
                    case R.id.category_burger:
                        categoryId = 2;
                        menuPresenter.loadFoodItems(categoryId);
                        break;
                    case R.id.category_toast:
                        categoryId = 3;
                        menuPresenter.loadFoodItems(categoryId);
                        break;
                    case R.id.category_snack:
                        categoryId = 4;
                        menuPresenter.loadFoodItems(categoryId);
                        break;
                    case R.id.category_drinks:
                        categoryId = 5;
                        menuPresenter.loadFoodItems(categoryId);
                        break;
                    case R.id.btn_checkout:
                        Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);
                        startActivity(intent);
                }
            }
        };

        btnEggroll.setOnClickListener(listener);
        btnBurger.setOnClickListener(listener);
        btnToast.setOnClickListener(listener);
        btnSnack.setOnClickListener(listener);
        btnDrink.setOnClickListener(listener);
        btnCheckOut.setOnClickListener(listener);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menuPresenter.selectedFoodItem(position);
            }
        };

        lvFoods.setOnItemClickListener(onItemClickListener);
        tvFoodNumberOrders.setText("購物車內有"+ Repositories.CART_REPOSITORY.getCount() + "個餐點");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvFoodNumberOrders.setText("購物車內有"+ Repositories.CART_REPOSITORY.getCount() + "個餐點");
    }

    @Override
    public void displayFoodItem(List<FoodItem> foodItems) {
        adapter.updateFoodItems(foodItems);
    }

}