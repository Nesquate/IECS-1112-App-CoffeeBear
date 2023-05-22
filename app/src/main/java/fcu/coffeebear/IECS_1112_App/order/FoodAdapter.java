package fcu.coffeebear.IECS_1112_App.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fcu.coffeebear.IECS_1112_App.model.FoodItem;
import fcu.coffeebear.IECS_1112_App.R;

public class FoodAdapter extends BaseAdapter{
    Context context;
    List<FoodItem> foodItems;

    public FoodAdapter(Context context, List<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @Override
    public int getCount() {
        if (foodItems == null)
            return 0;
        return foodItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.food_item_layout, parent, false);
        }

        FoodItem food = foodItems.get(position);

        ImageView iv = view.findViewById(R.id.iv_food_image);
        iv.setImageResource(food.getImageId());
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setAdjustViewBounds(true);

        TextView tvFoodName = view.findViewById(R.id.tv_food_name);
        tvFoodName.setText(food.getFoodName());

        TextView tvFoodPrice = view.findViewById(R.id.tv_food_price);
        tvFoodPrice.setText("$ "+String.valueOf(food.getFoodPrice()));

        return view;
    }

    public void updateFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
        notifyDataSetChanged();
    }
}