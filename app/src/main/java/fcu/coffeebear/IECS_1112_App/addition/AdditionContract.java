package fcu.coffeebear.IECS_1112_App.addition;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdditionContract {
    interface IAdditionView {
        void showInfo(String name, String description);
        void showList(ArrayList<HashMap<String, String>> dataList);
        void showImage(Integer imageId);
    }

    interface IAdditionPresenter {
        void getInformation(String id);
        ArrayList<String> getAdditionClass(String id);
        ArrayList<HashMap<String, String>> getAdditionOptions(String id, String type);
        ArrayList<HashMap<String, String>> getClassAndOptions(String id);
    }
}