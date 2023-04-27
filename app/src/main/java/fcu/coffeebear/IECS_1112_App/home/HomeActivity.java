package fcu.coffeebear.IECS_1112_App.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fcu.coffeebear.IECS_1112_App.R;
import fcu.coffeebear.IECS_1112_App.model.HomeRepository;

public class HomeActivity extends AppCompatActivity implements HomeContract.IHomeView {

    private HomeRepository repository;
    private HomeContract.IHomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        repository = new HomeRepository();
        presenter = new HomePresenter(this, repository);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_home_bottom);

        presenter.getBanner();
        presenter.getMemberBar();
    }

    @Override
    public void showBanner(ArrayList<Integer> bannerList) {
        LinearLayout homeBannerLayout = findViewById(R.id.home_banner_layout);
        homeBannerLayout.removeAllViews(); // clear previous view first

        for(Integer item: bannerList){ // add view from data
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(item);
            imageView.setAdjustViewBounds(true);
            homeBannerLayout.addView(imageView);
        }
    }

    @Override
    public void showMemberBar(HashMap<String, String> memberInfo) {
        boolean isLogin = Boolean.parseBoolean(memberInfo.get("isLogin"));

        if(isLogin){
            LinearLayout memberInfoLayout = findViewById(R.id.member_info_layout);
            memberInfoLayout.removeAllViews();

            TextView welcomeTextView = new TextView(this);
            TextView memberPointTextView = new TextView(this);

            welcomeTextView.setText("歡迎，"+memberInfo.get("accountName"));
            welcomeTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
            welcomeTextView.setTextSize(18);

            memberPointTextView.setText("點數："+memberInfo.get("accountPoint"));
            memberPointTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
            memberPointTextView.setTextSize(18);

            memberInfoLayout.addView(welcomeTextView);
            memberInfoLayout.addView(memberPointTextView);

        }
    }
}