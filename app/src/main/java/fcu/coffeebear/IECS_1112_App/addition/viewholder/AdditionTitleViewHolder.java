package fcu.coffeebear.IECS_1112_App.addition.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;

public class AdditionTitleViewHolder extends AdditionViewHolder {

    private TextView textView;
    public AdditionTitleViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_addition);
    }

    @Override
    public void bindViewHolder(HashMap<String, String> map) {
        textView.setText(map.get("name"));
    }
}
