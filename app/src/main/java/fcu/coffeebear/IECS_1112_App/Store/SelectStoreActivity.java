package fcu.coffeebear.IECS_1112_App.Store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.StoreInfo;

public class SelectStoreActivity extends AppCompatActivity {

    private ListView lvStore;
    private StoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_store);

        lvStore = findViewById(R.id.lv_store);

        List<StoreInfo> info = new ArrayList<StoreInfo>();

        info.add(new StoreInfo("逢甲店","台中市西屯區福星路100號"));
        info.add(new StoreInfo("興大店","台中市南區興大路53號"));
        info.add(new StoreInfo("新竹店","新竹市東區公道五路124號"));
        info.add(new StoreInfo("嘉義店","嘉義市東區民權路97號"));
        info.add(new StoreInfo("台南店","台南市永康區中山路33號"));

        adapter = new StoreAdapter(this,info);
        lvStore.setAdapter(adapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Bundle bundle;
            }
        };
        lvStore.setOnItemClickListener(onItemClickListener);
    }
}