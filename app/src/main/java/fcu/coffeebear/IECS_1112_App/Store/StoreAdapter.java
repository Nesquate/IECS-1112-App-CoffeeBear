package fcu.coffeebear.IECS_1112_App.Store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.FoodItem;
import fcu.coffeebear.IECS_1112_App.model.StoreInfo;


public class StoreAdapter extends BaseAdapter {

    Context context;
    List<StoreInfo> storeInfos;

    public StoreAdapter(Context context, List<StoreInfo> storeInfos) {
        this.context = context;
        this.storeInfos = storeInfos;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.store_infomation, parent, false);
        }

        StoreInfo store = storeInfos.get(position);

        TextView tvStoreName = view.findViewById(R.id.tv_store_name);
        tvStoreName.setText(store.getStoreName());

        TextView tvStoreAddress = view.findViewById(R.id.tv_store_address);
        tvStoreAddress.setText(store.getStoreAddress());

        return view;
    }
}
