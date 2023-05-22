package fcu.coffeebear.IECS_1112_App.addition;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.addition.viewholder.AdditionEditTextViewHolder;
import fcu.coffeebear.IECS_1112_App.addition.viewholder.AdditionOptionViewHolder;
import fcu.coffeebear.IECS_1112_App.addition.viewholder.AdditionTitleViewHolder;
import fcu.coffeebear.IECS_1112_App.addition.viewholder.AdditionViewHolder;
import fcu.coffeebear.IECS_1112_App.addition.viewholder.AdditionViewType;

public class AdditionViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<HashMap<String, String>> additionList;

    public AdditionViewAdapter(ArrayList<HashMap<String, String>> additionList){
        this.additionList = additionList;
    }

    @Override
    public int getItemViewType(int position) {
        String type = Objects.requireNonNull(additionList.get(position).get("type"));

        if(type.equals("title")){
            return AdditionViewType.TITLE.ordinal();
        }

        if(type.equals("option")){
            return AdditionViewType.OPTIONAL.ordinal();
        }

        if(type.equals("edit")){
            return AdditionViewType.EDIT.ordinal();
        }

        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == AdditionViewType.TITLE.ordinal()){
            return new AdditionTitleViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(
                                    R.layout.item_addition_title,
                                    parent,
                                    false
                            )
            );
        } else if (viewType == AdditionViewType.EDIT.ordinal()){
            return new AdditionEditTextViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(
                                    R.layout.item_addition_feedback,
                                    parent,
                                    false
                            )
            );
        } else if (viewType == AdditionViewType.OPTIONAL.ordinal()){
            return new AdditionOptionViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(
                                    R.layout.item_addition_options,
                                    parent,false
                            )
            );
        } else {
            return new AdditionOptionViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(
                                    R.layout.item_addition_options,
                                    parent,false
                            )
            );
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AdditionViewHolder) holder).bindViewHolder(additionList.get(position));
    }

    @Override
    public int getItemCount() {
        return additionList.size();
    }
}
