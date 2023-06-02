package fcu.coffeebear.IECS_1112_App.model;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.addition.AdditionActivity;

public class AdditionRepository {

    private Bundle bundle;

    public AdditionRepository(Bundle bundle){
        this.bundle = bundle;
    }

    public AdditionRepository(){}

    public HashMap<String, String> getInformation(String id){
        // TODO: Connect with SQLite
        // fake data now

        HashMap<String, String> data = new HashMap<>();
        if(id.equals("1")){
            if(bundle == null){
                data.put("name", "蛋餅");
                data.put("description", "好吃的蛋餅");
                data.put("image", "");
            }else{
                data.put("name", bundle.getString("foodName"));
                data.put("description", bundle.getString("foodDescription"));
                data.put("image", bundle.getString("foodImage"));
            }
        }

        return data;
    }

    public ArrayList<String> getClassList(){
        // TODO: Connect with SQLite
        // fake data now
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("加點");
        arrayList.add("備註");

        return arrayList;
    }

    public ArrayList<HashMap<String,String>> getOptionsList(String type){
        // TODO: Connect with SQLite
        // fake data now
        ArrayList<HashMap<String, String>> optionList = new ArrayList<>();
        if(type.equals("加點")){
            HashMap<String,String> option1 = new HashMap<>();
            option1.put("option", "加胡椒");
            HashMap<String,String> option2 = new HashMap<>();
            option2.put("option", "加胡椒");


            optionList.add(option1);
            optionList.add(option2);
        } else if(type.equals("備註")){
            HashMap<String,String> option1 = new HashMap<>();
            option1.put("option", "在這寫下你的備註...");
            optionList.add(option1);
        }

        return optionList;
    }
}
