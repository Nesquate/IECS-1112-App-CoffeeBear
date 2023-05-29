package fcu.coffeebear.IECS_1112_App.party;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;

public class PartyViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<HashMap<String,String>> partyList;

    public PartyViewAdapter(ArrayList<HashMap<String,String>> partylist){
        this.partyList = partylist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PartyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_party,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PartyViewHolder) holder).bindViewHolder(partyList.get(position));
    }

    @Override
    public int getItemCount() {
        return partyList.size();
    }
}
