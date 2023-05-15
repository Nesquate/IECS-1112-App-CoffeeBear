package fcu.coffeebear.IECS_1112_App.home;

import java.util.ArrayList;
import java.util.HashMap;

public interface HomeContract {
    interface IHomeView{
        void showBanner(ArrayList<Integer> bannerList);
        void showMemberBar(HashMap<String, String> memberInfo);
    }

    interface IHomePresenter{
        void getBanner();
        void getMemberBar();
    }
}
