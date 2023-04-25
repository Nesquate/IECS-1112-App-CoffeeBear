package fcu.coffeebear.IECS_1112_App.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).hide();

        ImageView imageViewActivity = findViewById(R.id.iv_banner_activity);
        ImageView imageViewMeal = findViewById(R.id.iv_banner_meal);

        imageViewActivity.setImageResource(R.drawable.banner_activity);
        imageViewMeal.setImageResource(R.drawable.banner_newest_meal);

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_home_bottom);
    }
}