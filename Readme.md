# Navi _ 나만아는 비밀장소<br>

#### Navi는 전국 어디에서나 나만의 장소를 친구들과 쉽게 공유 할 수있는 새로운 형태의 SNS입니다. <br>
#### Navi-app which is Easily share your own place, where your friends have been anywhere in the country
<br><br><br>

## Description 
 
<br>![4444 (2)](https://user-images.githubusercontent.com/74412438/120944103-a5165900-c76d-11eb-99e7-b73b2c0221b4.jpg)  ![555 (1)](https://user-images.githubusercontent.com/74412438/120944254-819fde00-c76e-11eb-966d-f50fd0d1a9f0.jpg)<br>

<br>

### Navi 에서는 , <br>
 
- 사용자들이 올린 전국 장소 리뷰

- 실제 사용자들의 솔직한 리뷰

- 전국 어디든 친구들이 다녀온 장소, 나만의 장소를 손쉽게 공유

- 카페, 문화생활, 맛집 등의 추천 큐레이션

- 지도 위에 표시되는 현재 내 위치와 근처 장소들

- 사용자 위치기반 장소리스트 안내<br><br><br><br>

### 시장조사 앱과의 차별성  <br><br>

   
   - 해시태그(#)를 통한 추천장소 필터링 기능을 제공<br>
    
   - 사용자가 직접 코스를 구상하여 저장 및 공유하는 기능을 제공<br>
    
   - SNS 기능제공으로 개인 피드에 장소 공유 및 저장 <br> 
    
   - 사용자별 관심사 키워드 선택을 통한 추천장소 정렬<br><br>


### 서비스 개요 
![66661 (5)](https://user-images.githubusercontent.com/74412438/120944620-6df57700-c770-11eb-8607-445ce401074d.jpg)


<br><br>
## Environment
<br>

#### Android Studio<br>
![pasted+image+0 (1)](https://user-images.githubusercontent.com/74412438/120945850-861bc500-c775-11eb-8dd7-43c47ffb2bb9.png)
<br>
<br>
#### Google Firebase<br>
![99DA2D3359E072CD14 (1)](https://user-images.githubusercontent.com/74412438/120945977-e4e13e80-c775-11eb-8710-bed7c65b0594.png)
<br><br>
#### Kakao API<br>
![121222 (1)](https://user-images.githubusercontent.com/74412438/120946091-38538c80-c776-11eb-8d7c-60bd7f67528f.png)




<br><br><br><br>

## Prerequisite <br>
- Android Studio (4.1.1 버전 사용중)<br><br>

- Google Firebase API <br><br>

- Kakao map API (HashKey 추가) <br><br>

##### 1. 깃허브 상단의 Url 클릭후 Navi-app 설치(Clone)
##### 2. 하단의 메소드를 내려받은 Android StudioProject/Navi-app/MainActivity 에 추가 후, compile 진행
##### 3. Logcat 터미널에 나오는 Hashkey를 복사 
##### 4. [KakaoDeveloper](https://developers.kakao.com/) 에 접속
##### 5. 로그인 > 시작하기 > 애플리케이션 추가하기 클릭
##### 6. 임의의 앱 이름, 사업자명을 입력 후 저장 클릭
##### 7. 만들어진 어플리케이션을 클릭한 후 플랫폼 설정하기 클릭
##### 8. Android 플랫폼 등록 클릭 > 패키지명에 com.tennessee.project_navi 입력 > 키 해시 항목에 복사해둔 Hash Key를 붙여넣기 > 저장 클릭
##### 9. 요약 정보 > 앱 키 > 네이티브 앱 키 복사
##### 10. Android Studio > manifests > application- android:value = "" 에 복사한 네이티브 앱 키 붙여넣기

```c
main() { 
Log.i(TAG, "Key Hash Value :" + getHashKey(this as Activity);
} 

public String getKeyHashBase64(Context context) { 
PackageInfo packageInfo = Utility.getPackageInfo(context, PackageManager.GET_SIGNATURES); 
if (packageInfo == null) 
return null;

for (Signature signature : packageInfo.signatures) {
try { MessageDigest md = MessageDigest.getInstance("SHA");
md.update(signature.toByteArray());
return Base64.encodeToString(md.digest(), Base64.DEFAULT);
} catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
e.printStackTrace(); 
    }
  } 
 return null;
}


```
    
<br><br><br><br>

## Algorithm & LifeCycle <br>


#### 전체 알고리즘<br>
![image](https://user-images.githubusercontent.com/74412438/121266830-2862b680-c8f6-11eb-8e36-ce976f6937cb.png)

<br><br>

#### MainActivity - Fragment 알고리즘<br>
![알고리즘예비_Fragment11](https://user-images.githubusercontent.com/74412438/121266967-65c74400-c8f6-11eb-843e-9450a8465985.png)
<br><br>

#### FeedFragment / SearchFragment / MainFragment 알고리즘<br>
![알고리즘예비_Fragment111](https://user-images.githubusercontent.com/74412438/121267176-c060a000-c8f6-11eb-9aa9-53c2109bc93a.png)
<br><br>

#### BookmarkFragment / MypageFragment 알고리즘<br>
![알고리즘예비_Fragment1111](https://user-images.githubusercontent.com/74412438/121267208-cf475280-c8f6-11eb-95dc-b668959da579.png)
<br><br><br><br>







## How To Get Started <br><br>

#### 1. 어플리케이션 설치 확인<br>
###### Prerequisite 의 순서에 따라 App 설치 확인 
![app11 (1)](https://user-images.githubusercontent.com/74412438/121253763-77075500-c8e4-11eb-89a6-a90c1a219990.png)<br><br>


#### 2. 어플리케이션 구동 환경 설정<br>
###### 아래와 같이 APP의 Permission을 전부 allow 설정.<br>
 ![app (1)](https://user-images.githubusercontent.com/74412438/121173071-56fb7580-c893-11eb-8bbe-56fefead78e3.png)<br><br>


#### 3. 어플리케이션 실행<br> 



<br><br>

## Code to Follow<br><br>


#### AndroidManifest.xml 에서 프로젝트 진행시 필요한 환경설정을 위한 permission 진행
 
```c
     //프로젝트 진행시 필요한 환경설정을 위한 permission 진행
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.CAMERA"/>
    <uses-feature android:name="android.hardware.camera"/>
    <uses-feature android:name="android.hardware.camera.autofocus"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 
 ```

#### AndroidManifest.xml / <meta-data> 태그추가 및 Kakao맵 사용을 위한 "com.kakao.sdk.AppKey" 해쉬키 입력

```c
     <meta-data android:name="com.kakao.sdk.AppKey"
            android:value="f0161a2a261a69601640ef9fd70c9cd4"/>
 
 ```
 
 #### AndroidManifest.xml / App 실행시 최초 대기화면에서 출력되는 Splash 기능 구현을 위한 SplashActivity 생성 및 AndroidManifest에 태그추가 

```c
     <activity android:name=".SplashActivity" android:theme="@style/SplashTheme">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
 
 ```
 
 #### SplashActivity.java / SplashActivity 최초 실행 (onCreate) 시 이후 출력될 MainActivity로의 이동을 위한 코드 작성 

```c
    public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

 
 ```
 
 #### MainActivity.java / App 실행시 최초출력될 메인 Activity에 BottomNavigation 기능 및 fragment 사용을 위한 framelayout 생성 ( id : container )

```c

public class   MainActivity extends AppCompatActivity {
    private Fragment HomeFragment,SearchFragment,FeedFragment,BookmarkFragment,MypageFragment;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        FrameLayout frameLayout = findViewById(R.id.container);

        BottomNavigationView BottomNavigation = findViewById(R.id.bottomnavigation);

        BottomNavigation.setOnNavigationItemSelectedListener(listener);

        HomeFragment = new MainFragment();
        SearchFragment = new SearchFragment();
        BookmarkFragment = new BookmarkFragment();
        FeedFragment = new FeedFragment();
        MypageFragment = new MypageFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, HomeFragment).commit();
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


        // XML 레이아웃에 정의된 contentsLayout 객체 참조
        FrameLayout contentsLayout = (FrameLayout) findViewById(R.id.fragment_container_view_tag);

    // 인플레이션 수행
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        // 프래그먼트 전환 메소드
        public void replaceFragment(Fragment fragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment).commit();     // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
        }
 
}

 
 ```
 
 #### main_page.xml / MainActivity와 연동된 레이아웃단에 <FrameLayout> 과 <BottomNavigation> 만을 RelativeLayout으로 디자인 

```c
     <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@id/bottomnavigation">

    </FrameLayout>



    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomnavigation"
        android:layout_width="409dp"
        android:layout_height="66dp"
        android:layout_alignParentBottom="true"
        android:background="@color/com_kakao_button_background_press"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintVertical_bias="1.0"
        app:menu="@menu/bottom_navigation" />

</RelativeLayout>
 
 ```
 
 #### Feedfragment.java / Feedfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 UI 및 페이지 기능 구현 
 
```c
    public class FeedFragment extends Fragment {

    FloatingActionButton floatingBtn;

    private Context context;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.feed_fragment,container,false);

        floatingBtn = rootview.findViewById(R.id.floatingActionButton);
        // Inflate the layout for this fragment
        //게시글 작성버튼
        //로그인이 안되어있을시 ,
        if (user == null) {
            floatingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "로그인 후 글 작성이 가능합니다", Toast.LENGTH_LONG).show();
                }
            });
        }
        //로그인 되어있을시 ,
        if (user != null) {

            floatingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), WritePostActivity.class);
                    startActivity(intent);
                }
            });
        }
        return rootview;
    }
}
 
 ```
 
 #### Searchfragment.java / Searchfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 UI 및 페이지 기능 구현 

 
```c
     public class SearchFragment extends Fragment {





    public SearchFragment() {
        // Required empty public constructor
    }


    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.search_fragment, container, false);
    }
}
 
 ```
 
 
 #### Mainfragment.java / Mainfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 UI 및 페이지 기능 구현 

 
```c
    public class MainFragment extends Fragment implements MapView.MapViewEventListener, MapView.POIItemEventListener
        {
            private Context context;
    private static final String TAG ="HomeFragment";
            Activity activity;
    RelativeLayout mapViewContainer;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        View view = inflater.inflate(R.layout.main_fragment,container,false);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //메인 fragment 시작시, 로그인 여부에 따른 프라그먼트 전환 및 출력조건절


        // Initialize Firebase Auth : 회원가입이 안된상태일시 JoinActivity
        // -> 이 로그인 유무 조건을 통해서, 타 Activity에서도 onCreate에서 똑같이 설정후 기능을 줄수있다 !!
        //로그인 되어있을시 -> 우측하단버튼 : logout 버튼 / 로그아웃 되어있을시 -> 우측하단버튼 : login버튼
        //   startLoginActivity();


        MapView mapView =  new MapView(getActivity());
        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

       //트래킹 모드 - Kakao map에서 현재위치 출력 코드 
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode
                .TrackingModeOnWithoutHeading);
        mapView.setZoomLevel(1, true);

        //상명대학교로 나비 customMark 임의 지정 
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

        mapView.setMapViewEventListener(MainFragment.this);
        mapView.setPOIItemEventListener(MainFragment.this);



      
        return view;

    }

    //프라그먼트용으로 변경한 화면전환 메소드
            // 액티비티 : this / 프라그먼트 : getActivity()
            private void StartMyActivity(Class c){
                Intent intent = new Intent(getActivity(), c);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            @Override
            public void onAttach(Context context) {
                super.onAttach(context);

                if (context instanceof Activity)
                    activity = (Activity) context;
            }

            @Override
            public void onMapViewInitialized(MapView mapView) {

            }

            @Override
            public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

            }

            @Override
            public void onMapViewZoomLevelChanged(MapView mapView, int i) {

            }

            @Override
            public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

                MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
                MapPOIItem customMarker = new MapPOIItem();
              
                customMarker.setItemName("게시글 작성하기");
                customMarker.setTag(1);
                customMarker.setMapPoint(MapPoint.mapPointWithGeoCoord(mapPointGeo.latitude, mapPointGeo.longitude));
                customMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
                customMarker.setCustomImageResourceId(R.drawable.navi_mark);
                customMarker.setCustomImageAutoscale(false);
                customMarker.setCustomImageAnchor(0.5f, 1.0f);
                mapView.addPOIItem(customMarker);
                Toast.makeText(getActivity(), "위도 " + mapPointGeo.latitude + " 경도" + mapPointGeo.longitude, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

            }

            @Override
            public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

            }

            @Override
            public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

            }

            @Override
            public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

            }

            @Override
            public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

            }

            @Override
            public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

            }
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            @Override
            public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

                //로그인이 안되어있을시 ,
                if (user == null) {
                    Toast.makeText(context, "로그인 후 글 작성이 가능합니다", Toast.LENGTH_LONG).show();
                }
                //로그인 되어있을시 ,
                if (user != null) {

                    Intent intent = new Intent(getActivity(), WritePostActivity.class);
                    startActivity(intent);
                }


            }

            @Override
            public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

            }

            @Override
            public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

            }
        }
 ```
 
 #### Bookmarkfragment.java / Bookmarkfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 UI 및 페이지 기능 구현 

 
```c
     public class BookmarkFragment extends Fragment {



    public BookmarkFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bookmark_fragment, container, false);
    }
}
 
 ```

 #### Mypagefragment.java / Mypagefragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 UI 및 페이지 기능 구현 

 
```c
   public class MypageFragment extends Fragment {

Button logincheckBtn;
EditText IdEditText;
EditText phoneNumber;
EditText birthDayEditText;
EditText addressEditText;

    public MypageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.mypage_fragment,container,false);


        IdEditText = rootview.findViewById(R.id.IdEditText);
        phoneNumber = rootview.findViewById(R.id.phoneNumber);
        birthDayEditText = rootview.findViewById(R.id.birthDayEditText);
        addressEditText = rootview.findViewById(R.id.addressEditText);

        logincheckBtn = rootview.findViewById(R.id.logincheckBtn);

        //로그인 안되어있을시 ,
        if(user == null) {
            IdEditText.setText("로그인 후 확인가능합니다");
            IdEditText.setEnabled(false);
            phoneNumber.setText("로그인 후 확인가능합니다");
            phoneNumber.setEnabled(false);
            birthDayEditText.setText("로그인 후 확인가능합니다");
            birthDayEditText.setEnabled(false);
            addressEditText.setText("로그인 후 확인가능합니다");
            addressEditText.setEnabled(false);


            logincheckBtn.setText("로그인하기");
            logincheckBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //로그인 성공시 현재 프라그먼트 종료후 새로고침
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);

                }
            });

        }
        //로그인 되어있을시 ,
        if(user != null){

            IdEditText.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            IdEditText.setEnabled(false);
            phoneNumber.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            phoneNumber.setEnabled(false);
            birthDayEditText.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            birthDayEditText.setEnabled(false);
            addressEditText.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            addressEditText.setEnabled(false);



            logincheckBtn.setText("로그아웃하기");
            logincheckBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                }
            });
        }

        return rootview;
    }



    private void StartMyActivity(Class c){
        Intent intent = new Intent(getActivity(), c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}

 
 ```


 #### Feedfragment.xml / Feedfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 xml 레이아웃 디자인 
 
  ```c
 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".FeedFragment">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/floatingActionButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentBottom="true"
        android:layout_marginStart="340dp"
        android:layout_marginLeft="340dp"
        android:layout_marginTop="550dp"
        android:layout_marginEnd="21dp"
        android:layout_marginRight="21dp"
        android:layout_marginBottom="19dp"
        android:clickable="true"
        android:src="@drawable/ic_add_black_24dp"
        app:backgroundTint="@color/bg_login_button"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</RelativeLayout>
 
 ```
 
  #### Searchfragment.xml / Searchfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 xml 레이아웃 디자인 
 
  ```c
 
 
 ```
 
  #### Mainfragment.xml / Mainfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 xml 레이아웃 디자인 
 
  ```c
 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@id/bottomnavigation">

    </FrameLayout>



    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomnavigation"
        android:layout_width="409dp"
        android:layout_height="66dp"
        android:layout_alignParentBottom="true"
        android:background="@color/com_kakao_button_background_press"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintVertical_bias="1.0"
        app:menu="@menu/bottom_navigation" />

</RelativeLayout>

 
 ```
 
  #### Bookmarkfragment.xml / Bookmarkfragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 xml 레이아웃 디자인 
 
  ```c
 
 
 ```
 
  #### Mypagefragment.xml / Mypagefragment - 위에서 생성해준 BottomNavigaiton에 등록될 5가지의 Fragment 페이지에 대한 xml 레이아웃 디자인 
 
  ```c
 <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MypageFragment">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        tools:context=".LoginActivity">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="50dp"
            android:layout_marginBottom="50dp"
            android:text="마이페이지"
            android:textSize="27sp"
            android:textStyle="bold"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center_horizontal"
            android:orientation="vertical">

            <androidx.cardview.widget.CardView
                android:layout_width="200dp"
                android:layout_height="200dp"
                app:cardCornerRadius="100dp">

                <ImageView
                    android:id="@+id/profileImage"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    tools:src="@tools:sample/avatars" />
            </androidx.cardview.widget.CardView>

            <EditText
                android:id="@+id/IdEditText"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:ems="10"
                android:hint="이름"
                android:inputType="text"
                android:textSize="17sp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.497"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

            <EditText
                android:id="@+id/phoneNumber"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:ems="10"
                android:hint="전화번호"
                android:inputType="textPassword"
                android:textSize="17sp"
                app:layout_constraintStart_toStartOf="@+id/IdEditText"
                app:layout_constraintTop_toBottomOf="@+id/IdEditText" />

            <EditText
                android:id="@+id/birthDayEditText"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:ems="10"
                android:hint="생년월일"
                android:inputType="textPassword"
                android:textSize="17sp"
                app:layout_constraintStart_toStartOf="@+id/IdEditText"
                app:layout_constraintTop_toBottomOf="@+id/IdEditText" />

            <EditText
                android:id="@+id/addressEditText"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:ems="10"
                android:hint="주소"
                android:inputType="textPassword"
                android:textSize="17sp"
                app:layout_constraintStart_toStartOf="@+id/IdEditText"
                app:layout_constraintTop_toBottomOf="@+id/IdEditText" />

            <Button
                android:id="@+id/logincheckBtn"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="50dp"
                android:background="@drawable/icondesign"
                android:textColor="#000000"
                app:backgroundTint="#FDF07C"
                android:text="로그인" />

        </LinearLayout>


    </LinearLayout>

</FrameLayout>
 
 ```
 
 
 
   <strong>  1-1 매 주차 Discord를 이용하였으며, 평균 주 2회의 회의를 진행. </strong><br>
          다음과 같은 과정으로 프로젝트 진행.<br><br>
        - 회의 전 각 팀원별 준비자료를 종합하여 회의 간 내용 공유<br>
        - 공유한 내용을 기반으로 팀원 간 보완점 논의 <br>
        - 최종 프로젝트 구상 회의  <br><br>

![111 (1)](https://user-images.githubusercontent.com/74412438/120943536-6af78800-c76a-11eb-9e69-e65539cad924.png) <br>Discord 회의화면

<br><br>

 <strong> - 앱 개발전 프로젝트 계획기간( week05 )까지는 Discord를 통하여 실시간으로 회의 및 weekly report를 작성하였기에, 하나의 Github 계정(MinukLee1)으로 commit 하였음을 알립니다. <br><br> - 추후 앱개발단계인 week06 부터는 개발현황에따른 각 계정별 commit이 진행될 예정입니다. </strong>
        
<br><br>
     
## 2. 유사앱 시장조사 <br><br>


   - Soulpicks<br>
    < 커뮤니티 기반 도시 필터링 서비스 ><br>
    < 어디에서나 현지인처럼 느낄 수 있게 국/해외 상관없이 사용 가능 ><br>
      - 프로필에 새로운 장소를 업로드 하고 즐겨찾는 장소를 관리 및 공유 <br>
      - 취향이 비슷한 사람들을 커뮤니티에서 찾고 메모, 사진업로드, 편집 가능 <br>
      - 30개 이상의 언어로 전세계에서 호환  <br><br><br>
                 
                 
   - 방방콕콕<br>
    <국내 관광지와 주변의 다양한 맛집, 숙소, 체험, 축제를 소개 ><br>
    < 유명한 관광지 외 숨어있는 장소 정보를 제공 ><br>
      - 영화, 드라마 등에 노출된 명소 추천  <br>
      - 서울, 경기 등 지역별 명소 추천  <br> <br><br>
        

   - 와간다(WAGANDA)<br>
    < 사용자들간의 전 세계 장소 리뷰 ><br>
    < 전세계 어디든 친구들이 다녀온 장소, 나만의 장소를 손쉽게 공유 ><br>
      - 지도(MAP MODE)를 이용한 지도 위 표시되는 내 위치와 근처 장소들 <br>
      - 사용자 위치기반 장소 리스트 안내 <br>
      - 에디터들의 지역별, 카테고리별 장소 추천 스토리 <br><br><br>


 





<br><br>
     <strong>구상 및 구현계획</strong><br>
   - google map API를 이용한 위치서비스 제공 
   - 사용자 정보 및 앱 데이터 저장을 위한 DB 서버 구축 
   - UI 구현 및 디자인 구상 
   - etc..
   <br><br><br>
     
     
     




 ### 기능구현 <br>
 
 
<details>
    <summary>이민욱</summary>

<!-- summary 아래 한칸 공백 두고 내용 삽입 -->

</details>

<details>
    <summary>황성택</summary>

<!-- summary 아래 한칸 공백 두고 내용 삽입 -->

</details>

<details>
    <summary>성주현</summary>

<!-- summary 아래 한칸 공백 두고 내용 삽입 -->

</details>

<details>
    <summary>박예진</summary>

<!-- summary 아래 한칸 공백 두고 내용 삽입 -->

</details>

<details>
    <summary>최수빈</summary>

<!-- summary 아래 한칸 공백 두고 내용 삽입 -->

</details>


<br>
<br>

 ### 기대 효과 및 활용 분야 <br>




<br>
<br>




## 사용 API <br>

<br>
<br>


## Database 테이블 구조 <br>
<br>
<br>


## 5. 프로젝트 기획서 및 스토리보드 
   <br><br>
 ![image](https://user-images.githubusercontent.com/74412438/113589170-06d21e00-966c-11eb-93c1-ccde607dd079.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589185-0a65a500-966c-11eb-8846-a2351ea687ec.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589203-0fc2ef80-966c-11eb-973e-28b63ec8fdb7.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589217-13567680-966c-11eb-81b2-1dc00a3310a7.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589230-16e9fd80-966c-11eb-8b90-521744e60b7f.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589242-19e4ee00-966c-11eb-86be-9c951ed2a7e7.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589255-1baeb180-966c-11eb-9f12-e1c2f10209b5.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589262-1e110b80-966c-11eb-94d7-ca7d2acac7b7.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589268-1fdacf00-966c-11eb-9238-ef16ed1c30ae.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589274-21a49280-966c-11eb-893e-634d42849d51.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589282-236e5600-966c-11eb-8449-db4994a4a129.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589292-25d0b000-966c-11eb-97b9-4b5b4f58b731.png)<br><br>
![image](https://user-images.githubusercontent.com/74412438/113589301-279a7380-966c-11eb-8b44-42aa9668c2d9.png)<br><br><br><br>



