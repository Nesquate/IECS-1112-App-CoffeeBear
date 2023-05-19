package fcu.coffeebear.IECS_1112_App.model;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.api.general.MemberApi;
import fcu.coffeebear.IECS_1112_App.model.api.home.BannerApi;

public class HomeRepository {
    private MemberApi memberApi = new MemberApi();
    private BannerApi bannerApi = new BannerApi();

    public ArrayList<Integer> getBanner(){
        // Fake data here
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.banner_activity);
        arrayList.add(R.drawable.banner_newest_meal);

        return arrayList;
    }

    public HashMap<String, String> getMemberShortInfo(){
        // Fake data here
        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("isLogin", "false");

        // Use for testing after login situation
        hashMap.put("isLogin", "true");
        hashMap.put("accountName", "User");
        hashMap.put("accountPoint", "48763");

        return hashMap;
    }
}
