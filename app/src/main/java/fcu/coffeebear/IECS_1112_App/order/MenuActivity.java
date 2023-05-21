package fcu.coffeebear.IECS_1112_App.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.FoodItem;

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

        List<FoodItem> foodItems = new ArrayList<FoodItem>();
        MenuContract.MenuPresenter menuPresenter = new FoodPresenter(this,MenuActivity.this);
        adapter = new FoodAdapter(this, foodItems);
        lvFoods.setAdapter(adapter);

        menuPresenter.loadFoodItems(1);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.category_eggroll:
                        menuPresenter.loadFoodItems(1);
                        break;
                    case R.id.category_burger:
                        menuPresenter.loadFoodItems(2);
                        break;
                    case R.id.category_toast:
                        menuPresenter.loadFoodItems(3);
                        break;
                    case R.id.category_snack:
                        menuPresenter.loadFoodItems(4);
                        break;
                    case R.id.category_drinks:
                        menuPresenter.loadFoodItems(5);
                        break;
                }

            }
        };

        btnEggroll.setOnClickListener(listener);
        btnBurger.setOnClickListener(listener);
        btnToast.setOnClickListener(listener);
        btnSnack.setOnClickListener(listener);
        btnDrink.setOnClickListener(listener);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                menuPresenter.selectedFoodItem(position);
            }
        };


        lvFoods.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void displayFoodItem(List<FoodItem> foodItems) {
        adapter.updateFoodItems(foodItems);
    }

}