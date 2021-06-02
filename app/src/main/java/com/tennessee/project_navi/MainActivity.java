package com.tennessee.project_navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import net.daum.mf.map.api.MapView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    MapView mapView;
    RelativeLayout mapViewContainer;

    Button btnSearch,btnFeed,btnMain,btnBookmark,btnMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Initialize Firebase Auth : 회원가입이 안된상태일시 JoinActivity
        // -> 이 로그인 유무 조건을 통해서, 타 Activity에서도 onCreate에서 똑같이 설정후 기능을 줄수있다 !!
        //로그인 되어있을시 -> 우측하단버튼 : logout 버튼 / 로그아웃 되어있을시 -> 우측하단버튼 : login버튼
        //   startLoginActivity();
        if(user == null){
            StartMyActivity(JoinActivity.class);
        }else {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference docRef = db.collection("users").document(user.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if(document != null) {
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                            } else {
                                // 사용자 정보입력을 안했으면, -> 입력창으로 감
                                Log.d(TAG, "No such document");
                                StartMyActivity(UserInitActivity.class);
                            }
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });

        }

        mapViewContainer = findViewById(R.id.map_view);
        mapView = new MapView(this);
        mapViewContainer.addView(mapView);


        btnFeed = findViewById(R.id.btnFeed);
        btnSearch = findViewById(R.id.btnSearch);
        btnMain = findViewById(R.id.btnMain);
        btnBookmark = findViewById(R.id.btnBookmark);
        btnMypage = findViewById(R.id.btnMypage);


        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        //로그아웃
        //  btnFeed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                StartMyActivity(LoginActivity.class);
//                finish();
//            }
//        });

    }

    private void StartMyActivity(Class c){
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
