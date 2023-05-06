package fcu.coffeebear.IECS_1112_App.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fcu.coffeebear.IECS_1112_App.FoodItem;
import fcu.coffeebear.IECS_1112_App.MenuViewHolder;
import fcu.coffeebear.IECS_1112_App.R;

public class FoodAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    Context context;
    List<FoodItem> foodItems;

    public FoodAdapter(Context context, List<FoodItem> lsFoods) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(context).inflate(R.layout.food_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        holder.imageId.setImageResource(foodItems.get(position).getImageId());
        holder.foodName.setText(foodItems.get(position).getFoodName());
        holder.foodIntro.setText(foodItems.get(position).getFoodIntro());
        holder.foodPrice.setText(foodItems.get(position).getFoodPrice());
    }

    @Override
    public int getItemCount() {
        if(foodItems==null)
            return 0;
        return foodItems.size();
    }
}
