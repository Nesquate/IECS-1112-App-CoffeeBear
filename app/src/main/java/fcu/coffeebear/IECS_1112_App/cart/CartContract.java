package fcu.coffeebear.IECS_1112_App.cart;

import java.util.ArrayList;
import java.util.HashMap;

public interface CartContract {
    interface ICartView{
        void showCartList(ArrayList<HashMap<String, Object>> cartList);
        void updateTotalPrice(String price);
    }
    interface ICartPresenter{
        void getCartData();
    }
}
