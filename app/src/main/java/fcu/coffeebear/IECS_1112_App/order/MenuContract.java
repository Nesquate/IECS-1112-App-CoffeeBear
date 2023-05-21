package fcu.coffeebear.IECS_1112_App.order;

import java.util.List;

import fcu.coffeebear.IECS_1112_App.model.FoodItem;

public interface MenuContract {

    interface MenuView {
        void displayFoodItem(List<FoodItem> foodItems);
    }

    interface MenuPresenter {
        void loadFoodItems(int categoryId);
        void selectedFoodItem(int position);
    }
}
