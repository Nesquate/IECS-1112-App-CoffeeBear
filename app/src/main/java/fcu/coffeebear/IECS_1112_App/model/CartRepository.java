package fcu.coffeebear.IECS_1112_App.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CartRepository {
    private final ArrayList<HashMap<String, Object>> cartList = new ArrayList<>();

    private void add(HashMap<String, Object> product){
        cartList.add(product);
    }

    public void remove(HashMap<String, Object> product){
        cartList.remove(product);
    }

    public void addToCart(String foodName, String foodPrice, String foodCount){
        Integer count = Integer.parseInt(foodCount);
        Integer price = Integer.parseInt(foodPrice);
        price = price * count;

        HashMap<String, Object> product = new HashMap<>();
        product.put("name", foodName);
        product.put("count", foodCount);
        product.put("price", String.valueOf(price));

        add(product);
    }

    public ArrayList<HashMap<String, Object>> getCartList(){
        generateFakeData();
        return new ArrayList<>(cartList);
    }

    public Integer getCount(){
        return cartList.size();
    }

    private void generateFakeData(){
        addToCart("原味蛋餅", "65", "2");
//        HashMap<String, Object> product1 = new HashMap<>();
//        product1.put("name", "原味蛋餅");
//        product1.put("count", "2");
//        product1.put("price", "65");
//        ArrayList<String> additional1 = new ArrayList<>();
//        additional1.add("加醬油");
//        product1.put("additional", additional1);
//        add(product1);
    }
}
