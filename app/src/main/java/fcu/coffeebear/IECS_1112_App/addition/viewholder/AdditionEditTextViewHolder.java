package fcu.coffeebear.IECS_1112_App.addition.viewholder;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import fcu.coffeebear.IECS_1112_App.R;

public class AdditionEditTextViewHolder extends AdditionViewHolder{
    private EditText editText;
    public AdditionEditTextViewHolder(@NonNull View itemView) {
        super(itemView);

        editText = itemView.findViewById(R.id.et_addition);
    }

    @Override
    public void bindViewHolder(HashMap<String, String> map) {
        editText.setHint(map.get("hint"));
    }
}
