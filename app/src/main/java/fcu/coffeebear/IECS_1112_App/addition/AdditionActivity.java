package fcu.coffeebear.IECS_1112_App.addition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.AdditionRepository;

public class AdditionActivity extends AppCompatActivity implements AdditionContract.IAdditionView {
    private AdditionPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        setTitle("其他選項");

        presenter = new AdditionPresenter(this, new AdditionRepository());
        presenter.getInformation("1");
    }

//    private ArrayList<HashMap<String, String>> makeFakeData(){
//        TextView mealName = findViewById(R.id.tv_addition_meal_name);
//        mealName.setText("蛋餅");
//        TextView mealDescription = findViewById(R.id.tv_addition_meal_description);
//        mealDescription.setText("好吃的蛋餅~");
//
//        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
//
//        HashMap<String,String> titleOption = new HashMap<>();
//        titleOption.put("type", "title");
//        titleOption.put("name", "加點");
//
//        HashMap<String,String> additionOptionOne = new HashMap<>();
//        additionOptionOne.put("type", "option");
//        additionOptionOne.put("name", "加胡椒");
//        HashMap<String,String> additionOptionTwo = new HashMap<>();
//        additionOptionTwo.put("type", "option");
//        additionOptionTwo.put("name", "加醬油");
//
//        HashMap<String, String> titleFeedback = new HashMap<>();
//        titleFeedback.put("type", "title");
//        titleFeedback.put("name", "備註");
//
//        HashMap<String, String> additionFeedBackEdit = new HashMap<>();
//        additionFeedBackEdit.put("type", "edit");
//        additionFeedBackEdit.put("hint", "在這寫下你的備註...");
//
//        arrayList.add(titleOption);
//        arrayList.add(additionOptionOne);
//        arrayList.add(additionOptionTwo);
//        arrayList.add(titleFeedback);
//        arrayList.add(additionFeedBackEdit);
//
//        return arrayList;
//    }

    @Override
    public void showInfo(String name, String description) {
        if(name == null || description == null){
            throw new RuntimeException();
        }

        TextView mealName = findViewById(R.id.tv_addition_meal_name);
        mealName.setText(name);
        TextView mealDescription = findViewById(R.id.tv_addition_meal_description);
        mealDescription.setText(description);
    }

    @Override
    public void showList(ArrayList<HashMap<String, String>> dataList) {
        if(dataList != null){
            for(HashMap<String, String> map:dataList){
                System.out.printf("Key: %s, Value: %s%n",
                        map.keySet().toArray()[0],
                        map.values().toArray()[0]);
            }

            RecyclerView recyclerView = findViewById(R.id.rv_addition);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new AdditionViewAdapter(dataList));
        }

    }
}