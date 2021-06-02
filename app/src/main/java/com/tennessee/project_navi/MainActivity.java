package com.tennessee.project_navi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MainActivity extends AppCompatActivity {

    MapView mapView;
    RelativeLayout mapViewContainer;

    Button btntest,btnboard,btnuser,btnbmark,btnlogout;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);


        // Initialize Firebase Auth : 회원가입이 안된상태일시 JoinActivity
        // -> 이 로그인 유무 조건을 통해서, 타 Activity에서도 onCreate에서 똑같이 설정후 기능을 줄수있다 !!
        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            startLoginActivity();
          //로그인 되어있을시 -> 우측하단버튼 : logout 버튼 / 로그아웃 되어있을시 -> 우측하단버튼 : login버튼
            //   startLoginActivity();

        }

        mapViewContainer = findViewById(R.id.map_view);
        mapView = new MapView(this);
        mapViewContainer.addView(mapView);

        //트랙킹모드
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode
                .TrackingModeOnWithoutHeading);
        mapView.setZoomLevel(1, true);


        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(36.8336012, 127.1791657);

        MapPOIItem customMarker = new MapPOIItem();
        customMarker.setItemName("상명대학교");
        customMarker.setTag(1);
        customMarker.setMapPoint(mapPoint);
        customMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        customMarker.setCustomImageResourceId(R.drawable.navi_mark);
        customMarker.setCustomImageAutoscale(false);
        customMarker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(customMarker);


        btntest = findViewById(R.id.btntest);
        btnboard = findViewById(R.id.btnboard);
        btnuser = findViewById(R.id.btnuser);
        btnbmark = findViewById(R.id.btnbmark);
        btnlogout = findViewById(R.id.btnlogout);

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivity(intent);
            }
        });

        btnbmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookmarkActivity.class);
                startActivity(intent);
            }
        });

        //로그아웃
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startLoginActivity();
                finish();
            }
        });
    }

    private void startLoginActivity(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    private void onPOIItemSelected(MapView mapView, MapPOIItem poiItem){

    }
}