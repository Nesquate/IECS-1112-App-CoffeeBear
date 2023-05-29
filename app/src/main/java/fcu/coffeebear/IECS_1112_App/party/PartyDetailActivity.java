package fcu.coffeebear.IECS_1112_App.party;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import fcu.coffeebear.IECS_1112_App.R;

public class PartyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_detail);

        ImageView imageView = findViewById(R.id.party_detial_image);
        TextView tvName = findViewById(R.id.party_detail_name);
        TextView tvDescription = findViewById(R.id.party_detail_description);
        TextView tvContent = findViewById(R.id.party_detail_content);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra("name"));
        tvDescription.setText(intent.getStringExtra("description"));
        tvContent.setText(intent.getStringExtra("content"));

        setTitle(intent.getStringExtra("name"));
    }
}