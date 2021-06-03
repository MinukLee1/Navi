package com.tennessee.project_navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Fragment HomeFragment,SearchFragment,FeedFragment,BookmarkFragment,MypageFragment;
    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        FrameLayout frameLayout = findViewById(R.id.container);

        BottomNavigationView BottomNavigation = findViewById(R.id.bottomnavigation);

        BottomNavigation.setOnNavigationItemSelectedListener(listener);

        HomeFragment = new HomeFragment();
        SearchFragment = new SearchFragment();
        BookmarkFragment = new BookmarkFragment();
        FeedFragment = new FeedFragment();
        MypageFragment = new MypageFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, SearchFragment).commit();
    }
private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feed:
                replaceFragment(FeedFragment);
                return true;
            case R.id.search:
                replaceFragment(SearchFragment);
                return true;
            case R.id.main:
                replaceFragment(HomeFragment);
                return true;
            case R.id.bookmark:
                replaceFragment(BookmarkFragment);
                return true;
            case R.id.mypage:
                replaceFragment(MypageFragment);
                return true;

        }

        return false;
    }
};


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.container, HomeFragment).commit();






        //로그아웃
       /* btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
               StartMyActivity(LoginActivity.class);
                finish();
           }
        });*/

        public void replaceFragment(Fragment fragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
        }


}
