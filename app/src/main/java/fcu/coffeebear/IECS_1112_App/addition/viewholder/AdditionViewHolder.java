package fcu.coffeebear.IECS_1112_App.addition.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public abstract class AdditionViewHolder extends RecyclerView.ViewHolder {
    public AdditionViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(HashMap<String, String> map);
}
