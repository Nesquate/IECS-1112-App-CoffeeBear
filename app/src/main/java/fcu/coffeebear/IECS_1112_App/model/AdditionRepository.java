package fcu.coffeebear.IECS_1112_App.model;

import java.util.ArrayList;
import java.util.HashMap;

public class AdditionRepository {

    public HashMap<String, String> getInformation(String id){
        // TODO: Connect with SQLite
        // fake data now

        HashMap<String, String> data = new HashMap<>();
        if(id.equals("1")){
            data.put("name", "蛋餅");
            data.put("description", "好吃的蛋餅");
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
