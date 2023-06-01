package fcu.coffeebear.IECS_1112_App.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.model.CartRepository;

public class CartPresenter implements CartContract.ICartPresenter {

    private CartContract.ICartView view;
    private CartRepository repository;

    public CartPresenter(CartContract.ICartView view ,CartRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getCartData() {
        ArrayList<HashMap<String, Object>> cartList = repository.getCartList();
        int totalPrice = 0;
        for (HashMap<String, Object> value : cartList){
            if(value.containsKey("price")){
                totalPrice += Integer.parseInt((String) Objects.requireNonNull(value.get("price")));
            }
        }
        view.showCartList(cartList);
        view.updateTotalPrice("$"+totalPrice);
    }
}
