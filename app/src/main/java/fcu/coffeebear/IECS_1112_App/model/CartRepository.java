package fcu.coffeebear.IECS_1112_App.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CartRepository {
    private final ArrayList<HashMap<String, Object>> cartList = new ArrayList<>();

    public void add(HashMap<String, Object> product){
        cartList.add(product);
    }

    public void remove(HashMap<String, Object> product){
        cartList.remove(product);
    }

    public ArrayList<HashMap<String, Object>> getCartList(){
        generateFakeData();
        return new ArrayList<>(cartList);
    }

    private void generateFakeData(){
        HashMap<String, Object> product1 = new HashMap<>();
        product1.put("name", "原味蛋餅");
        product1.put("price", "65");
        ArrayList<String> additional1 = new ArrayList<>();
        additional1.add("加醬油");
        product1.put("additional", additional1);
        add(product1);
    }
}
