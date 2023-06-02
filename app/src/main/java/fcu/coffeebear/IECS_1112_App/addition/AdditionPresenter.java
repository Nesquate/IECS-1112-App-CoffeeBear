package fcu.coffeebear.IECS_1112_App.addition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.model.AdditionRepository;

public class AdditionPresenter implements AdditionContract.IAdditionPresenter{

    private AdditionRepository repository;
    private AdditionContract.IAdditionView view;

    public AdditionPresenter(AdditionContract.IAdditionView view, AdditionRepository repository){
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getInformation(String id) {
        HashMap<String, String> data = repository.getInformation(id);

        if(data == null || data.size() == 0){
            throw new RuntimeException();
        }

        if(!Objects.equals(data.get("image"), "") && data.get("image") != null){
            view.showImage(Integer.parseInt(Objects.requireNonNull(data.get("image"))));
        }

        view.showInfo(data.get("name"), data.get("description"));
        view.showList(getClassAndOptions(id));
    }

    @Override
    public ArrayList<String> getAdditionClass(String id) {
        return repository.getClassList();
    }

    @Override
    public ArrayList<HashMap<String, String>> getAdditionOptions(String id, String type) {
        return repository.getOptionsList(type);
    }

    @Override
    public ArrayList<HashMap<String, String>> getClassAndOptions(String id) {
        ArrayList<String> typeList = getAdditionClass(id);
        if(typeList == null){
            throw new RuntimeException();
        }

        ArrayList<HashMap<String, String>> mergeList = new ArrayList<>();

        for(String typeName: typeList){
            String typeKey = "";
            String optionKey = "";
            ArrayList<HashMap<String, String>> options = getAdditionOptions(id, typeName);
            if(options == null){
                throw new RuntimeException();
            }

            if(typeName.equals("加點")){
                typeKey = "option";
                optionKey = "name";
            } else if(typeName.equals("備註")){
                typeKey = "edit";
                optionKey = "hint";
            }

            HashMap<String, String> typeMap = new HashMap<>();
            typeMap.put("type", "title");
            typeMap.put("name", typeName);
            mergeList.add(typeMap);

            for(HashMap<String, String> option: options){
                String value = option.get("option");
                HashMap<String, String> optionMap = new HashMap<>();
                optionMap.put("type", typeKey);
                optionMap.put(optionKey, value);
                mergeList.add(optionMap);
            }
        }

        return mergeList;
    }
}
