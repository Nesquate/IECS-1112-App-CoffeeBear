package fcu.coffeebear.IECS_1112_App;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<FoodItem> listFood;

    public ListViewAdapter(Context context, List<FoodItem> listFood) {
        this.context = context;
        this.listFood = listFood;
    }

    @Override
    public int getCount() {
        return listFood.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.food_item_layout, viewGroup, false);
        }

        FoodItem food = listFood.get(i);

        ImageView iv = view.findViewById(R.id.iv_food_image);
        iv.setImageResource(food.getImageId());
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setAdjustViewBounds(true);

        TextView tvFoodName = view.findViewById(R.id.tv_food_name);
        tvFoodName.setText(food.getFoodName());

        TextView tvFoodIntro = view.findViewById(R.id.tv_food_intro);
        tvFoodIntro.setText(food.getFoodIntro());

        TextView tvFoodPrice = view.findViewById(R.id.tv_food_price);
        tvFoodPrice.setText("$ " + String.valueOf(food.getFoodPrice()));

        return view;
    }
}
