package fcu.coffeebear.IECS_1112_App.addition.viewholder;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;

public class AdditionOptionViewHolder extends AdditionViewHolder {
    private CheckBox checkBox;
    public AdditionOptionViewHolder(@NonNull View itemView) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.cb_addition);
    }

    @Override
    public void bindViewHolder(HashMap<String, String> map) {
        checkBox.setText(map.get("name"));
    }
}
