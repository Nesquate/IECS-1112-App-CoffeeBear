package fcu.coffeebear.IECS_1112_App.party;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.PartyRepository;

public class PartyActivity extends AppCompatActivity implements PartyContract.IPartyView {

    private PartyContract.IPartyPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);

        presenter = new PartyPresenter(this, new PartyRepository());
        presenter.getPartyList();

        setTitle("活動");
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getPartyList();
    }

    //    private ArrayList<HashMap<String, String>> makeFakePartyList(){
//        ArrayList<HashMap<String, String>> partyList = new ArrayList<>();
//
//        HashMap<String, String> party1 = new HashMap<>();
//        // Data structure (HashMap)
//        party1.put("id", "1"); // required
//        party1.put("image", "");
//        party1.put("name", "123"); // required
//        party1.put("description", "測試活動1");
//        party1.put("content", "餐餐有蛋！即日起，凡是購買原味蛋餅，即享有買一送一的優惠！活動只到 5/31 止，要買要快！");
//
//        HashMap<String, String> party2 = new HashMap<>();
//        party2.put("id", "2"); // required
//        party2.put("name", "456");
//        party2.put("description", "測試活動2");
//
//        partyList.add(party1);
//        partyList.add(party2);
//
//        return partyList;
//    }

    @Override
    public void showPartyList(ArrayList<HashMap<String, String>> partyList) {
        RecyclerView recyclerView = findViewById(R.id.list_party);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PartyViewAdapter(partyList));
    }
}