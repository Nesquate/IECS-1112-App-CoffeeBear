package fcu.coffeebear.IECS_1112_App.party;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.R;

public class PartyViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView nameTextView;
    private TextView descriptionTextView;

    public PartyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.party_image);
        nameTextView = itemView.findViewById(R.id.party_name);
        descriptionTextView = itemView.findViewById(R.id.party_description);
    }

    public void bindViewHolder(HashMap<String,String> partyInfo){
        String id = Objects.requireNonNull(partyInfo.get("id")); // ?
        String imageFileName = partyInfo.get("image");
        String name = Objects.requireNonNull(partyInfo.get("name"));
        String description = partyInfo.get("description");
        String content = partyInfo.get("content");

        // TODO: Read file into bitmap

        nameTextView.setText(name);
        descriptionTextView.setText(description);

        itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("image", imageFileName);
            bundle.putString("name", name);
            bundle.putString("description", description);
            bundle.putString("content", content);

            Intent intent = new Intent(itemView.getContext(), PartyDetailActivity.class);
            intent.putExtras(bundle);

            itemView.getContext().startActivity(intent);
        });
    }
}
