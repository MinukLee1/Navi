package com.tennessee.project_navi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    MapView mapView;
    RelativeLayout mapViewContainer;

    Button btntest,btnboard,btnuser,btnbmark,btnlogout, btnlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);


        // Initialize Firebase Auth : 회원가입이 안된상태일시 JoinActivity
        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            startLoginActivity();

        }

        mapViewContainer = findViewById(R.id.map_view);
        mapView = new MapView(this);
        mapViewContainer.addView(mapView);

        btntest = findViewById(R.id.btntest);
        btnboard = findViewById(R.id.btnboard);
        btnuser = findViewById(R.id.btnuser);
        btnbmark = findViewById(R.id.btnbmark);
        btnlogout = findViewById(R.id.btnlogout);

        //위치 켜기 끄기
        btnlocation = findViewById(R.id.btnlocation);
        btnlogout = findViewById(R.id.btnlogout);

        //해쉬키 가져오기 위해 추가한 코드
        Log.e("getKeyHash", ""+ getKeyHash(this));

        //현재 위치 가져오기
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);

        //현재 위치에 마커 찍어주기
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        //marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        //marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        //트랙킹모드
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode
                .TrackingModeOnWithHeading);

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


    // 해쉬키 코드
    private String getKeyHash(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(context.getPackageName(),
                    PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.w(TAG, "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }

    private void startLoginActivity(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}