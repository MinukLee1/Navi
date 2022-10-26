# Navi _ 나만아는 비밀장소<br>

#### Navi는 전국 어디에서나 나만의 장소를 친구들과 쉽게 공유 할 수있는 새로운 형태의 SNS이다. <br>
#### Navi-app which is Easily share your own place, where your friends have been anywhere in the country<br><br>

<br><br>

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
    
<br><br>

- App내 Google Ad 추가를 위한 설정 <br><br>
##### Manifest 에 하단의 Meta-data 태그  추가 
```c
<meta-data android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="@string/admob_app_id"/>
```

![1111](https://user-images.githubusercontent.com/74412438/121509578-c010f380-ca21-11eb-99ec-a1278402fa05.png)

<br><br>

- App 내 사용된 이미지 파일 원본 <br>
![feed](https://user-images.githubusercontent.com/74412438/121339601-9db3a300-c959-11eb-8297-e882f6b831e4.png)
![search](https://user-images.githubusercontent.com/74412438/121339622-a1dfc080-c959-11eb-852e-7e47c0288d78.png)
![navi](https://user-images.githubusercontent.com/74412438/121339764-cb005100-c959-11eb-9549-530ea651e621.png)
![bookmark](https://user-images.githubusercontent.com/74412438/121339781-ce93d800-c959-11eb-82df-7c0aa941775b.png)
![mypage](https://user-images.githubusercontent.com/74412438/121339791-d18ec880-c959-11eb-8243-cf4bd1540c25.png) 
![navi111](https://user-images.githubusercontent.com/74412438/121339946-f97e2c00-c959-11eb-881b-2bfc7f3a92b9.png)

<br><br>




<br><br><br><br>

## Algorithm & LifeCycle <br>


#### 전체 플로우차트<br>
![image](https://user-images.githubusercontent.com/74412438/121266830-2862b680-c8f6-11eb-8e36-ce976f6937cb.png)

<br><br>

#### MainActivity - Fragment 플로우차트<br>
![알고리즘예비_Fragment11](https://user-images.githubusercontent.com/74412438/121266967-65c74400-c8f6-11eb-843e-9450a8465985.png)
<br><br>

#### FeedFragment / SearchFragment / MainFragment 플로우차트<br>
![알고리즘예비_Fragment111](https://user-images.githubusercontent.com/74412438/121267176-c060a000-c8f6-11eb-9aa9-53c2109bc93a.png)
<br><br>

#### BookmarkFragment / MypageFragment 플로우차트<br>
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


#### 

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
 
   #### WriteInfo.java / Feedfragment 와 Mainfragment 에서 구현된 글쓰기 버튼을 클릭시 WritePostActivity.java 의 생성자 및 참조코드 작성 
 
  ```c
 public class WriteInfo {
    private String title;
    private ArrayList<String> Contents;
    private String publisher;
    private Date date;

    public WriteInfo(String title, ArrayList<String> Contents, String publisher, Date date){
        this.title = title;
        this.Contents = Contents;
        this.publisher = publisher;
        this.date = date;

    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public ArrayList<String> getContents(){
        return this.Contents;
    }
    public void setContents(ArrayList<String> Contents){
        this.Contents = Contents;
    }

    public String getPublisher(){
        return this.publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date = date;
    }



}

 
 ```
 
 
  #### WritePostActivity.java / 위 WriteInfo에서 참조된 액티비티로, 게시글 작성시 노출되는 페이지 기능구현 코드 ( Camera와 Gallery 참조 부분은 바로아래 설명 )
 
  ```c
 public class WritePostActivity extends Activity {
    private static final String TAG = "WritePostActivity";
    private FirebaseUser user;
    private ArrayList<String> pathList = new ArrayList<>();
    private LinearLayout parent;
    private int pathCount, successCount;
    private RelativeLayout btnBackLayout, loaderLayout;
    private ImageView selectedImageView;
    private EditText selectedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        parent = findViewById(R.id.contentsLayout);
        btnBackLayout = findViewById(R.id.btnBackLayout);
        loaderLayout = findViewById(R.id.loaderLayout);

        btnBackLayout.setOnClickListener(onClickListener);
        findViewById(R.id.btncheck).setOnClickListener(onClickListener);
        findViewById(R.id.btnImage).setOnClickListener(onClickListener);
        findViewById(R.id.btnVideo).setOnClickListener(onClickListener);
        findViewById(R.id.imageModify).setOnClickListener(onClickListener);
        findViewById(R.id.videoModify).setOnClickListener(onClickListener);
        findViewById(R.id.delete).setOnClickListener(onClickListener);
        findViewById(R.id.contentsEditText).setOnFocusChangeListener(onFocusChangeListener);
        findViewById(R.id.titleEditText).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    selectedEditText = null;
                }
            }
        });
    }

    @Override
    public void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == Activity.RESULT_OK){
                    String profilePath = data.getStringExtra("profilePath");
                    pathList.add(profilePath);

                    ViewGroup.LayoutParams layoutParams =
                            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                    LinearLayout linearLayout = new LinearLayout(WritePostActivity.this);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);

                    if (selectedEditText == null){
                        parent.addView(linearLayout);
                    }else {
                        for (int i=0; i < parent.getChildCount(); i++){
                            if (parent.getChildAt(i) == selectedEditText.getParent()){
                                parent.addView(linearLayout, i + 1);
                                break;
                            }
                        }
                    }

                    ImageView imageView = new ImageView(WritePostActivity.this);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnBackLayout.setVisibility(View.VISIBLE);
                            selectedImageView = (ImageView) v;
                        }
                    });
                    Glide.with(this).load(profilePath).override(1000).into(imageView);
                    linearLayout.addView(imageView);

                    EditText editText = new EditText(WritePostActivity.this);
                    editText.setLayoutParams(layoutParams);
                    editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_CLASS_TEXT);
                    editText.setHint("내용");
                    editText.setOnFocusChangeListener(onFocusChangeListener);
                    linearLayout.addView(editText);
                }
                break;
            case 1:
                if (resultCode == Activity.RESULT_OK){
                String profilePath = data.getStringExtra("profilePath");
                Glide.with(this).load(profilePath).override(1000).into(selectedImageView);
            }
                break;
            }
        }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btncheck:
                    storageUploader();
                    break;
                case R.id.btnImage:
                    StartMyActivity(GalleryActivity.class, "image",0);
                    break;
                case R.id.btnVideo:
                    StartMyActivity(GalleryActivity.class, "video",0);
                    break;
                case R.id.btnBackLayout:
                    if (btnBackLayout.getVisibility() == View.VISIBLE){
                        btnBackLayout.setVisibility(View.GONE);
                    }
                    break;
                case  R.id.imageModify:
                    StartMyActivity(GalleryActivity.class, "imageModify",1);
                    btnBackLayout.setVisibility(View.GONE);
                    break;
                case  R.id.videoModify:
                    StartMyActivity(GalleryActivity.class, "videoModify",1);
                    btnBackLayout.setVisibility(View.GONE);
                    break;
                case  R.id.delete:
                    parent.removeView((View) selectedImageView.getParent());
                    btnBackLayout.setVisibility(View.GONE);
                    break;
            }
        }
    };

    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                selectedEditText = (EditText) v;
            }
        }
    };

    private void storageUploader() {
        final String title = ((EditText) findViewById(R.id.titleEditText)).getText().toString();

        if (title.length() > 0) {
            loaderLayout.setVisibility(View.VISIBLE);
            ArrayList<String> contentsList = new ArrayList<>();
            user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            final DocumentReference documentReference = firebaseFirestore.collection("feeds").document();

            for (int i=0; i < parent.getChildCount(); i++){
                LinearLayout linearLayout = (LinearLayout) parent.getChildAt(i);
                for (int ii = 0; ii < linearLayout.getChildCount(); ii++){
                    View view = linearLayout.getChildAt(ii);
                    if (view instanceof EditText){
                        String text = ((EditText)view).getText().toString();
                        if (text.length() > 0){
                            contentsList.add(text);
                        }
                    }else {
                        contentsList.add(pathList.get(pathCount));
                        final StorageReference mountainImagesRef = storageRef.child("feeds/" + documentReference.getId() + "/"+pathCount+".jpg");

                        try {
                            InputStream stream = new FileInputStream(new File(pathList.get(pathCount)));
                            StorageMetadata metadata = new StorageMetadata.Builder().setCustomMetadata("index",""+(contentsList.size()-1)).build();
                            UploadTask uploadTask = mountainImagesRef.putStream(stream, metadata);
                            uploadTask.addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    //
                                }
                            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    final int index = Integer.parseInt(taskSnapshot.getMetadata().getCustomMetadata("index"));
                                    mountainImagesRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            contentsList.set(index, uri.toString());
                                            successCount++;
                                            if (pathList.size() == successCount){
                                                //완료
                                                WriteInfo writeInfo = new WriteInfo(title, contentsList, user.getUid(), new Date());
                                                Uploader(documentReference, writeInfo);
                                                startToast("게시글 등록에 성공하였습니다");
                                            }
                                        }
                                    });
                                }
                            });
                        }catch (FileNotFoundException e){
                            Log.e("로그","에러: " + e.toString());
                        }
                        pathCount++;
                    }
                }
            }
            if (pathList.size() == 0){
                WriteInfo writeInfo = new WriteInfo(title, contentsList, user.getUid(), new Date());
                Uploader(documentReference, writeInfo);
                startToast("게시글 등록에 성공하였습니다");
            }

            }
        else {
            startToast("제목,내용,카테고리는 필수입력항목입니다");
        }
    }

    private void Uploader(DocumentReference documentReference, WriteInfo writeInfo) {
        documentReference.set(writeInfo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG,"DocumentSnapshot successfully written!");
                        loaderLayout.setVisibility(View.GONE);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG,"Error writing document", e);
                        loaderLayout.setVisibility(View.GONE);
                    }
                });
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c, String media, int requestCode){
        Intent intent = new Intent(this, c);
        intent.putExtra("media", media);
        startActivityForResult(intent,requestCode);
    }
}

 
 ```
 
    #### activity_write_post.xml / WritePostActivity 에 대한 레이아웃 디자인 코드 작업 
 
  ```c
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white">

    <include
        layout="@layout/view_loader"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="gone"
        tools:layout_editor_absoluteX="181dp"
        tools:layout_editor_absoluteY="634dp" />


    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="350dp"
        android:foregroundGravity="center_horizontal">


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            android:orientation="vertical">

            <androidx.constraintlayout.utils.widget.ImageFilterView
                android:id="@+id/imageFilterView"
                android:layout_width="98dp"
                android:layout_height="101dp"
                android:layout_marginStart="155dp"
                android:layout_marginLeft="155dp"
                android:layout_marginTop="38dp"
                android:layout_marginEnd="155dp"
                android:layout_marginRight="155dp"
                app:srcCompat="@drawable/navi_mark" />

            <EditText
                android:id="@+id/titleEditText"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:ems="10"
                android:hint="제목"
                android:inputType="textPersonName" />

            <LinearLayout
                android:id="@+id/contentsLayout"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">


                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="vertical">

                    <EditText
                        android:id="@+id/contentsEditText"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:ems="10"
                        android:gravity="top"
                        android:hint="내용"
                        android:inputType="textMultiLine"
                        tools:layout_editor_absoluteX="3dp"
                        tools:layout_editor_absoluteY="260dp" />
                </LinearLayout>

            </LinearLayout>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">

                <Button
                    android:id="@+id/btnImage"
                    android:layout_width="34dp"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center|center_horizontal"
                    android:layout_margin="8dp"
                    android:layout_weight="1"
                    android:background = "@drawable/icondesign"
                    android:text="이미지"
                    android:textColor="#000000"
                    app:backgroundTint="#FDF07C"
                    app:iconTint="#FDF07C" />

                <Button
                    android:id="@+id/btnVideo"
                    android:layout_width="34dp"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center|center_horizontal"
                    android:layout_margin="8dp"
                    android:layout_weight="1"
                    android:background="@drawable/icondesign"
                    android:text="비디오"
                    android:textColor="#000000"
                    app:backgroundTint="#FDF07C"
                    app:iconTint="#FDF07C"/>

            </LinearLayout>

            <Button
                android:id="@+id/btncheck"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center|center_horizontal"
                android:background="@drawable/icondesign"
                android:text="확인"
                android:textColor="#000000"
                app:backgroundTint="#FDF07C"
                app:iconTint="#FDF07C" />
        </LinearLayout>

    </ScrollView>

    <RelativeLayout
        android:id="@+id/btnBackLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="gone">

        <androidx.cardview.widget.CardView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:elevation="10dp"
            app:cardCornerRadius="15dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:padding="5dp">

                <Button
                    android:id="@+id/imageModify"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/icondesign"
                    android:text="이미지 수정"
                    android:textColor="#000000"
                    app:backgroundTint="#FDF07C"
                    app:iconTint="#FFFFFF"/>

                <Button
                    android:id="@+id/videoModify"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/icondesign"
                    android:text="비디오 수정"
                    android:textColor="#000000"
                    app:backgroundTint="#FDF07C"
                    app:iconTint="#FFFFFF"/>

                <Button
                    android:id="@+id/delete"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/icondesign"
                    android:text="삭제"
                    android:textColor="#000000"
                    app:backgroundTint="#FDF07C"
                    app:iconTint="#FFFFFF"/>
            </LinearLayout>
        </androidx.cardview.widget.CardView>
    </RelativeLayout>

</RelativeLayout>
 
 ```
 
 
 
 
  #### CameraActivity.java / 게시글 작성 및 사용자 회원가입시 사진 선택 및 DB 저장을 위한 카메라 기능 구현  

 
```c
 public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

}
```
 
 
  #### Camera2BasicFragment.java / CameraActiviry 접속시 상단 framelayout에서 실시간으로 띄워줄 카메라 출력 코드   

 
```c
public class Camera2BasicFragment extends Fragment
        implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {

    /**
     * Conversion from screen rotation to JPEG orientation.
     */
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private static final String FRAGMENT_DIALOG = "dialog";

    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    /**
     * Tag for the {@link Log}.
     */
    private static final String TAG = "Camera2BasicFragment";

    /**
     * Camera state: Showing camera preview.
     */
    private static final int STATE_PREVIEW = 0;

    /**
     * Camera state: Waiting for the focus to be locked.
     */
    private static final int STATE_WAITING_LOCK = 1;

    /**
     * Camera state: Waiting for the exposure to be precapture state.
     */
    private static final int STATE_WAITING_PRECAPTURE = 2;

    /**
     * Camera state: Waiting for the exposure state to be something other than precapture.
     */
    private static final int STATE_WAITING_NON_PRECAPTURE = 3;

    /**
     * Camera state: Picture was taken.
     */
    private static final int STATE_PICTURE_TAKEN = 4;

    /**
     * Max preview width that is guaranteed by Camera2 API
     */
    private static final int MAX_PREVIEW_WIDTH = 1920;

    /**
     * Max preview height that is guaranteed by Camera2 API
     */
    private static final int MAX_PREVIEW_HEIGHT = 1080;

    /**
     * {@link TextureView.SurfaceTextureListener} handles several lifecycle events on a
     * {@link TextureView}.
     */
    private final TextureView.SurfaceTextureListener mSurfaceTextureListener
            = new TextureView.SurfaceTextureListener() {

        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture texture, int width, int height) {
            openCamera(width, height);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture texture, int width, int height) {
            configureTransform(width, height);
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture texture) {
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture texture) {
        }

    };

    /**
     * ID of the current {@link CameraDevice}.
     */
    private String mCameraId;

    /**
     * An {@link AutoFitTextureView} for camera preview.
     */
    private AutoFitTextureView mTextureView;

    /**
     * A {@link CameraCaptureSession } for camera preview.
     */
    private CameraCaptureSession mCaptureSession;

    /**
     * A reference to the opened {@link CameraDevice}.
     */
    private CameraDevice mCameraDevice;

    /**
     * The {@link android.util.Size} of camera preview.
     */
    private Size mPreviewSize;

    /**
     * 전면/후면 카메라 id
       */
    private int facingid = 0;
    /**
     * 자동 포커스 체크 id
     */
    private boolean mAutoFocusSupported;

    /**
     * {@link CameraDevice.StateCallback} is called when {@link CameraDevice} changes its state.
     */
    private final CameraDevice.StateCallback mStateCallback = new CameraDevice.StateCallback() {

        @Override
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            // This method is called when the camera is opened.  We start camera preview here.
            mCameraOpenCloseLock.release();
            mCameraDevice = cameraDevice;
            createCameraPreviewSession();
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            mCameraOpenCloseLock.release();
            cameraDevice.close();
            mCameraDevice = null;
        }

        @Override
        public void onError(@NonNull CameraDevice cameraDevice, int error) {
            mCameraOpenCloseLock.release();
            cameraDevice.close();
            mCameraDevice = null;
            Activity activity = getActivity();
            if (null != activity) {
                activity.finish();
            }
        }

    };

    /**
     * An additional thread for running tasks that shouldn't block the UI.
     */
    private HandlerThread mBackgroundThread;

    /**
     * A {@link Handler} for running tasks in the background.
     */
    private Handler mBackgroundHandler;

    /**
     * An {@link ImageReader} that handles still image capture.
     */
    private ImageReader mImageReader;

    /**
     * This is the output file for our picture.
     */
    private File mFile;

    /**
     * This a callback object for the {@link ImageReader}. "onImageAvailable" will be called when a
     * still image is ready to be saved.
     */
    private final ImageReader.OnImageAvailableListener mOnImageAvailableListener
            = new ImageReader.OnImageAvailableListener() {

        @Override
        public void onImageAvailable(ImageReader reader) {
            mBackgroundHandler.post(new ImageUploader(reader.acquireNextImage()));
        }

    };

    /**
     * {@link CaptureRequest.Builder} for the camera preview
     */
    private CaptureRequest.Builder mPreviewRequestBuilder;

    /**
     * {@link CaptureRequest} generated by {@link #mPreviewRequestBuilder}
     */
    private CaptureRequest mPreviewRequest;

    /**
     * The current state of camera state for taking pictures.
     *
     * @see #mCaptureCallback
     */
    private int mState = STATE_PREVIEW;

    /**
     * A {@link Semaphore} to prevent the app from exiting before closing the camera.
     */
    private Semaphore mCameraOpenCloseLock = new Semaphore(1);

    /**
     * Whether the current camera device supports Flash or not.
     */
    private boolean mFlashSupported;

    /**
     * Orientation of the camera sensor
     */
    private int mSensorOrientation;

    /**
     * A {@link CameraCaptureSession.CaptureCallback} that handles events related to JPEG capture.
     */
    private CameraCaptureSession.CaptureCallback mCaptureCallback
            = new CameraCaptureSession.CaptureCallback() {

        private void process(CaptureResult result) {
            switch (mState) {
                case STATE_PREVIEW: {
                    // We have nothing to do when the camera preview is working normally.
                    break;
                }
                case STATE_WAITING_LOCK: {
                    Integer afState = result.get(CaptureResult.CONTROL_AF_STATE);
                    if (afState == null) {
                        captureStillPicture();
                    } else if (CaptureResult.CONTROL_AF_STATE_FOCUSED_LOCKED == afState ||
                            CaptureResult.CONTROL_AF_STATE_NOT_FOCUSED_LOCKED == afState) {
                        // CONTROL_AE_STATE can be null on some devices
                        Integer aeState = result.get(CaptureResult.CONTROL_AE_STATE);
                        if (aeState == null ||
                                aeState == CaptureResult.CONTROL_AE_STATE_CONVERGED) {
                            mState = STATE_PICTURE_TAKEN;
                            captureStillPicture();
                        } else {
                            runPrecaptureSequence();
                        }
                    }
                    break;
                }
                case STATE_WAITING_PRECAPTURE: {
                    // CONTROL_AE_STATE can be null on some devices
                    Integer aeState = result.get(CaptureResult.CONTROL_AE_STATE);
                    if (aeState == null ||
                            aeState == CaptureResult.CONTROL_AE_STATE_PRECAPTURE ||
                            aeState == CaptureRequest.CONTROL_AE_STATE_FLASH_REQUIRED) {
                        mState = STATE_WAITING_NON_PRECAPTURE;
                    }
                    break;
                }
                case STATE_WAITING_NON_PRECAPTURE: {
                    // CONTROL_AE_STATE can be null on some devices
                    Integer aeState = result.get(CaptureResult.CONTROL_AE_STATE);
                    if (aeState == null || aeState != CaptureResult.CONTROL_AE_STATE_PRECAPTURE) {
                        mState = STATE_PICTURE_TAKEN;
                        captureStillPicture();
                    }
                    break;
                }
            }
        }

        @Override
        public void onCaptureProgressed(@NonNull CameraCaptureSession session,
                                        @NonNull CaptureRequest request,
                                        @NonNull CaptureResult partialResult) {
            process(partialResult);
        }

        @Override
        public void onCaptureCompleted(@NonNull CameraCaptureSession session,
                                       @NonNull CaptureRequest request,
                                       @NonNull TotalCaptureResult result) {
            process(result);
        }

    };

    /**
     * Shows a {@link Toast} on the UI thread.
     *
     * @param text The message to show
     */
    private void showToast(final String text) {
        final Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * Given {@code choices} of {@code Size}s supported by a camera, choose the smallest one that
     * is at least as large as the respective texture view size, and that is at most as large as the
     * respective max size, and whose aspect ratio matches with the specified value. If such size
     * doesn't exist, choose the largest one that is at most as large as the respective max size,
     * and whose aspect ratio matches with the specified value.
     *
     * @param choices           The list of sizes that the camera supports for the intended output
     *                          class
     * @param textureViewWidth  The width of the texture view relative to sensor coordinate
     * @param textureViewHeight The height of the texture view relative to sensor coordinate
     * @param maxWidth          The maximum width that can be chosen
     * @param maxHeight         The maximum height that can be chosen
     * @param aspectRatio       The aspect ratio
     * @return The optimal {@code Size}, or an arbitrary one if none were big enough
     */
    private static Size chooseOptimalSize(Size[] choices, int textureViewWidth,
            int textureViewHeight, int maxWidth, int maxHeight, Size aspectRatio) {

        // Collect the supported resolutions that are at least as big as the preview Surface
        List<Size> bigEnough = new ArrayList<>();
        // Collect the supported resolutions that are smaller than the preview Surface
        List<Size> notBigEnough = new ArrayList<>();
        int w = aspectRatio.getWidth();
        int h = aspectRatio.getHeight();
        for (Size option : choices) {
            if (option.getWidth() <= maxWidth && option.getHeight() <= maxHeight &&
                    option.getHeight() == option.getWidth() * h / w) {
                if (option.getWidth() >= textureViewWidth &&
                    option.getHeight() >= textureViewHeight) {
                    bigEnough.add(option);
                } else {
                    notBigEnough.add(option);
                }
            }
        }

        // Pick the smallest of those big enough. If there is no one big enough, pick the
        // largest of those not big enough.
        if (bigEnough.size() > 0) {
            return Collections.min(bigEnough, new CompareSizesByArea());
        } else if (notBigEnough.size() > 0) {
            return Collections.max(notBigEnough, new CompareSizesByArea());
        } else {
            Log.e(TAG, "Couldn't find any suitable preview size");
            return choices[0];
        }
    }

    public static Camera2BasicFragment newInstance() {
        return new Camera2BasicFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera2_basic, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        view.findViewById(R.id.picture).setOnClickListener(this);
        view.findViewById(R.id.change).setOnClickListener(this);
        mTextureView = (AutoFitTextureView) view.findViewById(R.id.texture);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFile = new File(getActivity().getExternalFilesDir(null), "pic.jpg");
    }

    @Override
    public void onResume() {
        super.onResume();
        startBackgroundThread();

        // When the screen is turned off and turned back on, the SurfaceTexture is already
        // available, and "onSurfaceTextureAvailable" will not be called. In that case, we can open
        // a camera and start preview from here (otherwise, we wait until the surface is ready in
        // the SurfaceTextureListener).
        if (mTextureView.isAvailable()) {

        } else {
            mTextureView.setSurfaceTextureListener(mSurfaceTextureListener);
        }
    }

    @Override
    public void onPause() {
        closeCamera();
        stopBackgroundThread();
        super.onPause();
    }

    private void requestCameraPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            new ConfirmationDialog().show(getChildFragmentManager(), FRAGMENT_DIALOG);
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length != 1 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                ErrorDialog.newInstance(getString(R.string.request_permission))
                        .show(getChildFragmentManager(), FRAGMENT_DIALOG);
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /**
     * Sets up member variables related to camera.
     *
     * @param width  The width of available size for camera preview
     * @param height The height of available size for camera preview
     */
    @SuppressWarnings("SuspiciousNameCombination")
    private void setUpCameraOutputs(int width, int height,int facingid) {
        Activity activity = getActivity();
        CameraManager manager = (CameraManager) activity.getSystemService(Context.CAMERA_SERVICE);
        try {
            for (String cameraId : manager.getCameraIdList()) {
                CameraCharacteristics characteristics
                        = manager.getCameraCharacteristics(cameraId);

                int[] afAvailableModes = characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);

                if (afAvailableModes.length == 0 || (afAvailableModes.length == 1
                        && afAvailableModes[0] == CameraMetadata.CONTROL_AF_MODE_OFF)) {
                    mAutoFocusSupported = false;
                } else {
                    mAutoFocusSupported = true;
                }

                //전면 카메라
                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (facing != null && facing == facingid) {
                    StreamConfigurationMap map = characteristics.get(
                            CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    if (map == null) {
                        continue;
                    }

                    // For still image captures, we use the largest available size.
                    Size largest = Collections.max(
                            Arrays.asList(map.getOutputSizes(ImageFormat.JPEG)),
                            new CompareSizesByArea());
                    mImageReader = ImageReader.newInstance(largest.getWidth(), largest.getHeight(),
                            ImageFormat.JPEG, /*maxImages*/2);
                    mImageReader.setOnImageAvailableListener(
                            mOnImageAvailableListener, mBackgroundHandler);

                    // Find out if we need to swap dimension to get the preview size relative to sensor
                    // coordinate.
                    int displayRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                    //noinspection ConstantConditions
                    mSensorOrientation = characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                    boolean swappedDimensions = false;
                    switch (displayRotation) {
                        case Surface.ROTATION_0:
                        case Surface.ROTATION_180:
                            if (mSensorOrientation == 90 || mSensorOrientation == 270) {
                                swappedDimensions = true;
                            }
                            break;
                        case Surface.ROTATION_90:
                        case Surface.ROTATION_270:
                            if (mSensorOrientation == 0 || mSensorOrientation == 180) {
                                swappedDimensions = true;
                            }
                            break;
                        default:
                            Log.e(TAG, "Display rotation is invalid: " + displayRotation);
                    }

                    Point displaySize = new Point();
                    activity.getWindowManager().getDefaultDisplay().getSize(displaySize);
                    int rotatedPreviewWidth = width;
                    int rotatedPreviewHeight = height;
                    int maxPreviewWidth = displaySize.x;
                    int maxPreviewHeight = displaySize.y;

                    if (swappedDimensions) {
                        rotatedPreviewWidth = height;
                        rotatedPreviewHeight = width;
                        maxPreviewWidth = displaySize.y;
                        maxPreviewHeight = displaySize.x;
                    }

                    if (maxPreviewWidth > MAX_PREVIEW_WIDTH) {
                        maxPreviewWidth = MAX_PREVIEW_WIDTH;
                    }

                    if (maxPreviewHeight > MAX_PREVIEW_HEIGHT) {
                        maxPreviewHeight = MAX_PREVIEW_HEIGHT;
                    }

                    // Danger, W.R.! Attempting to use too large a preview size could  exceed the camera
                    // bus' bandwidth limitation, resulting in gorgeous previews but the storage of
                    // garbage capture data.
                    mPreviewSize = chooseOptimalSize(map.getOutputSizes(SurfaceTexture.class),
                            rotatedPreviewWidth, rotatedPreviewHeight, maxPreviewWidth,
                            maxPreviewHeight, largest);

                    // We fit the aspect ratio of TextureView to the size of preview we picked.
                    int orientation = getResources().getConfiguration().orientation;
                    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        mTextureView.setAspectRatio(
                                mPreviewSize.getWidth(), mPreviewSize.getHeight());
                    } else {
                        mTextureView.setAspectRatio(
                                mPreviewSize.getHeight(), mPreviewSize.getWidth());
                    }

                    // Check if the flash is supported.
                    Boolean available = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                    mFlashSupported = available == null ? false : available;

                    mCameraId = cameraId;
                    return;
                }


            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            // Currently an NPE is thrown when the Camera2API is used but not supported on the
            // device this code runs.
            ErrorDialog.newInstance(getString(R.string.camera_error))
                    .show(getChildFragmentManager(), FRAGMENT_DIALOG);
        }
    }

    /**
     * Opens the camera specified by {@link Camera2BasicFragment#mCameraId}.
     */
    private void openCamera(int width, int height) {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();
            return;
        }
        setUpCameraOutputs(width, height, facingid);//openCamera CameraCharacteristics.LENS_FACING_FRONT
        configureTransform(width, height);
        Activity activity = getActivity();
        CameraManager manager = (CameraManager) activity.getSystemService(Context.CAMERA_SERVICE);
        try {
            if (!mCameraOpenCloseLock.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                throw new RuntimeException("Time out waiting to lock camera opening.");
            }
            manager.openCamera(mCameraId, mStateCallback, mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e);
        }
    }


    /**
     * Closes the current {@link CameraDevice}.
     */
    private void closeCamera() {
        try {
            mCameraOpenCloseLock.acquire();
            if (null != mCaptureSession) {
                mCaptureSession.close();
                mCaptureSession = null;
            }
            if (null != mCameraDevice) {
                mCameraDevice.close();
                mCameraDevice = null;
            }
            if (null != mImageReader) {
                mImageReader.close();
                mImageReader = null;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
        } finally {
            mCameraOpenCloseLock.release();
        }
    }

    /**
     * Starts a background thread and its {@link Handler}.
     */
    private void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("CameraBackground");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    /**
     * Stops the background thread and its {@link Handler}.
     */
    private void stopBackgroundThread() {
        mBackgroundThread.quitSafely();
        try {
            mBackgroundThread.join();
            mBackgroundThread = null;
            mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new {@link CameraCaptureSession} for camera preview.
     */
    private void createCameraPreviewSession() {
        try {
            SurfaceTexture texture = mTextureView.getSurfaceTexture();
            assert texture != null;

            // We configure the size of default buffer to be the size of camera preview we want.
            texture.setDefaultBufferSize(mPreviewSize.getWidth(), mPreviewSize.getHeight());

            // This is the output Surface we need to start preview.
            Surface surface = new Surface(texture);

            // We set up a CaptureRequest.Builder with the output Surface.
            mPreviewRequestBuilder
                    = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            mPreviewRequestBuilder.addTarget(surface);

            // Here, we create a CameraCaptureSession for camera preview.
            mCameraDevice.createCaptureSession(Arrays.asList(surface, mImageReader.getSurface()),
                    new CameraCaptureSession.StateCallback() {

                        @Override
                        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                            // The camera is already closed
                            if (null == mCameraDevice) {
                                return;
                            }

                            // When the session is ready, we start displaying the preview.
                            mCaptureSession = cameraCaptureSession;
                            try {
                                // Auto focus should be continuous for camera preview.
                                mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE,
                                        CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
                                // Flash is automatically enabled when necessary.
                                setAutoFlash(mPreviewRequestBuilder);

                                // Finally, we start displaying the camera preview.
                                mPreviewRequest = mPreviewRequestBuilder.build();
                                mCaptureSession.setRepeatingRequest(mPreviewRequest,
                                        mCaptureCallback, mBackgroundHandler);
                            } catch (CameraAccessException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onConfigureFailed(
                                @NonNull CameraCaptureSession cameraCaptureSession) {
                          //  showToast("Failed");
                        }
                    }, null
            );
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Configures the necessary {@link android.graphics.Matrix} transformation to `mTextureView`.
     * This method should be called after the camera preview size is determined in
     * setUpCameraOutputs and also the size of `mTextureView` is fixed.
     *
     * @param viewWidth  The width of `mTextureView`
     * @param viewHeight The height of `mTextureView`
     */
    private void configureTransform(int viewWidth, int viewHeight) {
        Activity activity = getActivity();
        if (null == mTextureView || null == mPreviewSize || null == activity) {
            return;
        }
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        Matrix matrix = new Matrix();
        RectF viewRect = new RectF(0, 0, viewWidth, viewHeight);
        RectF bufferRect = new RectF(0, 0, mPreviewSize.getHeight(), mPreviewSize.getWidth());
        float centerX = viewRect.centerX();
        float centerY = viewRect.centerY();
        if (Surface.ROTATION_90 == rotation || Surface.ROTATION_270 == rotation) {
            bufferRect.offset(centerX - bufferRect.centerX(), centerY - bufferRect.centerY());
            matrix.setRectToRect(viewRect, bufferRect, Matrix.ScaleToFit.FILL);
            float scale = Math.max(
                    (float) viewHeight / mPreviewSize.getHeight(),
                    (float) viewWidth / mPreviewSize.getWidth());
            matrix.postScale(scale, scale, centerX, centerY);
            matrix.postRotate(90 * (rotation - 2), centerX, centerY);
        } else if (Surface.ROTATION_180 == rotation) {
            matrix.postRotate(180, centerX, centerY);
        }
        mTextureView.setTransform(matrix);
    }

    /**
     * Initiate a still image capture.
     */
    private void takePicture(){
    if (mAutoFocusSupported) {
        lockFocus();
    } else {
        captureStillPicture();
    }
}

    /**
     * Lock the focus as the first step for a still image capture.
     */
    private void lockFocus() {
        try {
            // This is how to tell the camera to lock focus.
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                    CameraMetadata.CONTROL_AF_TRIGGER_START);
            // Tell #mCaptureCallback to wait for the lock.
            mState = STATE_WAITING_LOCK;
            mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback,
                    mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run the precapture sequence for capturing a still image. This method should be called when
     * we get a response in {@link #mCaptureCallback} from {@link #lockFocus()}.
     */
    private void runPrecaptureSequence() {
        try {
            // This is how to tell the camera to trigger.
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER,
                    CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER_START);
            // Tell #mCaptureCallback to wait for the precapture sequence to be set.
            mState = STATE_WAITING_PRECAPTURE;
            mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback,
                    mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Capture a still picture. This method should be called when we get a response in
     * {@link #mCaptureCallback} from both {@link #lockFocus()}.
     */
    private void captureStillPicture() {
        try {
            final Activity activity = getActivity();
            if (null == activity || null == mCameraDevice) {
                return;
            }
            // This is the CaptureRequest.Builder that we use to take a picture.
            final CaptureRequest.Builder captureBuilder =
                    mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            captureBuilder.addTarget(mImageReader.getSurface());

            // Use the same AE and AF modes as the preview.
            captureBuilder.set(CaptureRequest.CONTROL_AF_MODE,
                    CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
            setAutoFlash(captureBuilder);

            // Orientation
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, getOrientation(rotation));

            CameraCaptureSession.CaptureCallback CaptureCallback
                    = new CameraCaptureSession.CaptureCallback() {

                @Override
                public void onCaptureCompleted(@NonNull CameraCaptureSession session,
                                               @NonNull CaptureRequest request,
                                               @NonNull TotalCaptureResult result) {
                   // showToast("Saved: " + mFile);
                    Log.d(TAG, mFile.toString());
                    unlockFocus();
                }
            };

            mCaptureSession.stopRepeating();
            mCaptureSession.abortCaptures();
            mCaptureSession.capture(captureBuilder.build(), CaptureCallback, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the JPEG orientation from the specified screen rotation.
     *
     * @param rotation The screen rotation.
     * @return The JPEG orientation (one of 0, 90, 270, and 360)
     */
    private int getOrientation(int rotation) {
        // Sensor orientation is 90 for most devices, or 270 for some devices (eg. Nexus 5X)
        // We have to take that into account and rotate JPEG properly.
        // For devices with orientation of 90, we simply return our mapping from ORIENTATIONS.
        // For devices with orientation of 270, we need to rotate the JPEG 180 degrees.
        return (ORIENTATIONS.get(rotation) + mSensorOrientation + 270) % 360;
    }

    /**
     * Unlock the focus. This method should be called when still image capture sequence is
     * finished.
     */
    private void unlockFocus() {
        try {
            // Reset the auto-focus trigger
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                    CameraMetadata.CONTROL_AF_TRIGGER_CANCEL);
            setAutoFlash(mPreviewRequestBuilder);
            mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback,
                    mBackgroundHandler);
            // After this, the camera will go back to the normal state of preview.
            mState = STATE_PREVIEW;
            mCaptureSession.setRepeatingRequest(mPreviewRequest, mCaptureCallback,
                    mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.picture: {
                takePicture();
                break;
            }
            case R.id.change:
                if(facingid == CameraCharacteristics.LENS_FACING_FRONT ){
                    facingid = CameraCharacteristics.LENS_FACING_BACK;
                }else{
                    facingid = CameraCharacteristics.LENS_FACING_FRONT;
                }
                closeCamera();;
                openCamera(mTextureView.getWidth(), mTextureView.getHeight());
                break;

        }
    }

    private void setAutoFlash(CaptureRequest.Builder requestBuilder) {
        if (mFlashSupported) {
            requestBuilder.set(CaptureRequest.CONTROL_AE_MODE,
                    CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);
        }
    }

    /**
     * Saves a JPEG {@link Image} into the specified {@link File}.
     */

    /**
     * 이미지를 서버로 저장시켜주는 부분
     */
    private static class ImageUploader implements Runnable {

        /**
         * The JPEG image
         */
        private final Image mImage;
        /**
         * The file we save the image into.
         */

        ImageUploader(Image image) {
            mImage = image;
        }

        @Override
        public void run() {
            ByteBuffer buffer = mImage.getPlanes()[0].getBuffer();
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            //사용자 UID에 따른 사진 저장 (경로 및 저장아이디)설정
            final StorageReference mountainImagesRef = storageRef.child("images/"+user.getUid()+"/profileImage.jpg");

            UploadTask uploadTask = mountainImagesRef.putBytes(bytes);



                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            Log.e("실패1","실패");
                            throw task.getException();
                        }

                        // Continue with the task to get the download URL
                        return mountainImagesRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            Log.e("성공","성공" + downloadUri);

                        } else {
                            // Handle failures
                            // ...
                            Log.e("실패2","실패");
                        }
                    }
                });
        }
    }
    /**
     * Compares two {@code Size}s based on their areas.
     */
    static class CompareSizesByArea implements Comparator<Size> {

        @Override
        public int compare(Size lhs, Size rhs) {
            // We cast here to ensure the multiplications won't overflow
            return Long.signum((long) lhs.getWidth() * lhs.getHeight() -
                    (long) rhs.getWidth() * rhs.getHeight());
        }

    }

    /**
     * Shows an error message dialog.
     */
    public static class ErrorDialog extends DialogFragment {

        private static final String ARG_MESSAGE = "message";

        public static ErrorDialog newInstance(String message) {
            ErrorDialog dialog = new ErrorDialog();
            Bundle args = new Bundle();
            args.putString(ARG_MESSAGE, message);
            dialog.setArguments(args);
            return dialog;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Activity activity = getActivity();
            return new AlertDialog.Builder(activity)
                    .setMessage(getArguments().getString(ARG_MESSAGE))
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finish();
                        }
                    })
                    .create();
        }

    }

    /**
     * Shows OK/Cancel confirmation dialog about camera permission.
     */
    public static class ConfirmationDialog extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Fragment parent = getParentFragment();
            return new AlertDialog.Builder(getActivity())
                    .setMessage(R.string.request_permission)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            parent.requestPermissions(new String[]{Manifest.permission.CAMERA},
                                    REQUEST_CAMERA_PERMISSION);
                        }
                    })
                    .setNegativeButton(android.R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Activity activity = parent.getActivity();
                                    if (activity != null) {
                                        activity.finish();
                                    }
                                }
                            })
                    .create();
        }
    }

}

```
 
 
 
  #### GalleryActivity.java / 위와 마찬가지로 게시글 작성 및 사용자 회원가입시 DB에 저장할 사진을 갤러리에서 참조하기위한 코드 작성 

 
```c
 public class GalleryActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        if (ContextCompat.checkSelfPermission(GalleryActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(GalleryActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            if (ActivityCompat.shouldShowRequestPermissionRationale(GalleryActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE )){
                //
            }
            else {
                startToast("권한을 허용해 주세요");
            }
        }else {
            recyclerInit();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode){
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    recyclerInit();
                } else {
                    finish();
                startToast("권한을 허용해 주세요");
                }
            }
        }
    }

    private void recyclerInit(){
        final int numberOfColumns = 3;

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        RecyclerView.Adapter mAdapter = new GalleryAdapter(this, getImagesPath(this));
        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<String> getImagesPath(Activity Activity) {
        Uri uri;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        Cursor cursor;
        int column_index_data;
        String PathOfImage = null;
        String[] projection;

        Intent intent = getIntent();
        if (intent.getStringExtra("media").equals("video")){
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            projection = new String[] { MediaStore.MediaColumns.DATA,MediaStore.Video.Media.BUCKET_DISPLAY_NAME};
        }else {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            projection = new String[] { MediaStore.MediaColumns.DATA,MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
        }

        cursor = Activity.getContentResolver().query(uri, projection, null, null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()){
            PathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(PathOfImage);
        }
        return listOfAllImages;
    }
    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
```
 
 
  #### GalleryAdapter.java / 위의 GalleryActivity 에 대한 참조 및 기능 구현 Activity 

 
```c
 public class GalleryAdapter  extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private ArrayList<String> mDataset;
    private Activity activity;

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public GalleryViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public GalleryAdapter(Activity activity, ArrayList<String> myDataset) {
        mDataset = myDataset;
        this.activity = activity;
    }
    @NonNull
    @Override
    public GalleryAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        final GalleryViewHolder vh = new GalleryViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("profilePath", mDataset.get(vh.getAdapterPosition()));
                activity.setResult(Activity.RESULT_OK, resultIntent);
                activity.finish();
            }
        });
        return vh;
        }
    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.itemImage);
        Glide.with(activity).load(mDataset.get(position)).override(300).into(imageView);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

 
 ```
 
  #### UserInitActivity.java / 회원가입 및 사용자정보 등록시 사용될 Activity 추가 

 
```c
 public class UserInitActivity extends Activity {
    private static final String TAG ="UserInitActivity";

    public static final int PICK_FROM_ALBUM = 1;
    private FirebaseStorage mStorage;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private Uri imageUri;
    private String pathUri;
    private File tempFile;
    private ImageView profileImage;
    private RelativeLayout loaderLayout, buttonsBackgroundLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinit_page);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mStorage = FirebaseStorage.getInstance();
        loaderLayout = findViewById(R.id.loaderLayout);
        buttonsBackgroundLayout = findViewById(R.id.buttonsBackgroundLayout);
        findViewById(R.id.gallery).setOnClickListener(onClickListener);
        findViewById(R.id.picture).setOnClickListener(onClickListener);
        findViewById(R.id.profileImage).setOnClickListener(onClickListener);

        //프로필 이미지 변경 리스너

        //회원정보 저장 버튼
        findViewById(R.id.btnInfoOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileUpdate();
            }
        });

       }

        View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.profileImage :
                    buttonsBackgroundLayout.setVisibility(View.VISIBLE);
                    break;
                case R.id.gallery :
                    gotoAlbum();
                    buttonsBackgroundLayout.setVisibility(View.GONE);
                    break;
                case R.id.picture :
                    StartMyActivity(CameraActivity.class);
                    buttonsBackgroundLayout.setVisibility(View.GONE);
                    break;
            }
        }
    };

    // 앨범 메소드
    private void gotoAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_OK) { // 코드가 틀릴경우
            startToast("회원가입을 취소하였습니다");
            if (tempFile != null) {
                if (tempFile.exists()) {
                    if (tempFile.delete()) {
                        Log.e(TAG, tempFile.getAbsolutePath() + " 삭제 성공");
                        tempFile = null;
                    }
                }
            }
            return;
        }
        switch (requestCode) {
            case PICK_FROM_ALBUM: { // 코드 일치
                // Uri
                imageUri = data.getData();
                pathUri = getPath(data.getData());
                Log.d(TAG, "PICK_FROM_ALBUM photoUri : " + imageUri);
                profileImage.setImageURI(imageUri); // 이미지 띄움
                break;
            }
        }
    }

    // uri 절대경로 가져오기
    public String getPath(Uri uri) {

        String[] proj = {MediaStore.Images.Media._ID};
        CursorLoader cursorLoader = new CursorLoader(this, uri, proj, null, null, null);

        Cursor cursor = cursorLoader.loadInBackground();
        int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);

        cursor.moveToFirst();
        return cursor.getString(index);
    }

    //뒤로가기
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //회원정보 등록
    private void profileUpdate() {

        String name = ((EditText) findViewById(R.id.IdEditText)).getText().toString();
        String phoneNumber = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
        String birthDay = ((EditText) findViewById(R.id.birthDayEditText)).getText().toString();
        String address = ((EditText) findViewById(R.id.addressEditText)).getText().toString();
        ImageView profileImage = ((ImageView) findViewById(R.id.profileImage));

        if (profileImage != null && name.length() > 0 && phoneNumber.length() > 9 && birthDay.length() > 5 && address.length() > 0 ) {
            loaderLayout.setVisibility(View.VISIBLE);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            //사용자 정보 초기화
            UserInfo userInfo = new UserInfo( name, phoneNumber, birthDay, address, profileImage);

            if (user != null  ) {

                db.collection("users").document(user.getUid()).set(userInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                final Uri file = Uri.fromFile(new File(pathUri)); // path

                                // 스토리지에 방생성 후 선택한 이미지 넣음
                                StorageReference storageReference = mStorage.getReference()
                                        .child("users").child("uid/"+file.getLastPathSegment());
                                storageReference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                 @Override
                                 public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                     final Task<Uri> imageUrl = task.getResult().getStorage().getDownloadUrl();
                                              userInfo.setName(name);
                                             Glide.with(userInfo.getProfileImage()).load(imageUrl.getResult().toString());
                                             // database에 저장
                                             mDatabase.getReference().child("users").child(name)
                                                     .setValue(userInfo);
                                     }
                                 });
                                startToast("회원가입에 성공하였습니다.");
                                loaderLayout.setVisibility(View.GONE);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("회원정보 등록에 실패하였습니다");
                                loaderLayout.setVisibility(View.GONE);
                                Log.v(TAG, "Error writting document",e);
                            }
                        });
            }
        } else {
            startToast("프로필사진 및 회원정보 입력은 필수입니다");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivityForResult(intent,0);
    }


}

 
 ```
 
 
   #### UserInit.xml / 위의 UserInitActivity.java(사용자 정보등록)에 대한 Layout 디자인 

 
```c
 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools">

    <include
        layout="@layout/view_loader"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="181dp"
        tools:layout_editor_absoluteY="634dp"
        android:visibility="gone"/>

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#FFFFFF"
            android:orientation="vertical"
            android:padding="10dp">


            <TextView
                android:id="@+id/textView"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:gravity="center"
                android:text="회원정보"
                android:textColor="#000000"
                android:textSize="27sp"
                android:textStyle="bold" />

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
                        android:adjustViewBounds="true"
                        android:src="@android:drawable/sym_def_app_icon"
                        app:srcCompat="@drawable/mypage" />
                </androidx.cardview.widget.CardView>

                <EditText
                    android:id="@+id/IdEditText"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="10dp"
                    android:ems="10"
                    android:hint="이름"
                    android:inputType="text"
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
                    app:layout_constraintStart_toStartOf="@+id/IdEditText"
                    app:layout_constraintTop_toBottomOf="@+id/IdEditText" />

                <Button
                    android:id="@+id/btnInfoOk"
                    android:layout_width="209dp"
                    android:layout_height="32dp"
                    android:layout_marginTop="20dp"
                    android:background="@drawable/icondesign"
                    android:textColor="#000000"
                    android:text="확인"
                    app:backgroundTint="#FDF07C"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@+id/phoneNumber" />

            </LinearLayout>
        </LinearLayout>
    </ScrollView>

    <RelativeLayout
        android:id="@+id/buttonsBackgroundLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#91646464"
        android:visibility="gone">

        <androidx.cardview.widget.CardView
            android:id="@+id/btnsCardView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:elevation="10dp"
            app:cardCornerRadius="15dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:padding="5dp">

                <Button
                    android:id="@+id/picture"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/icondesign"
                    android:textColor="#000000"
                    android:text="사진촬영" />

                <Button
                    android:id="@+id/gallery"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/icondesign"
                    android:textColor="#000000"
                    android:text="갤러리" />

            </LinearLayout>

        </androidx.cardview.widget.CardView>

    </RelativeLayout>



</RelativeLayout>
 
 
 ```
 
   #### activity_gallery.xml / 위의 GalleryActivity 에 대한 layout 디자인 추가 

 
```c
 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <include
        layout="@layout/view_toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@+id/toolbar">

    </androidx.recyclerview.widget.RecyclerView>
</RelativeLayout>
 
 
 ```
 
 #### fragmentCamera2.xml / 위에서 구현한 CameraActivity.java 페이지에 대한 layout 디자인 추가 

 
```c
 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <com.tennessee.project_navi.AutoFitTextureView
        android:id="@+id/texture"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true" />

    <LinearLayout
        android:id="@+id/control"
        android:layout_width="match_parent"
        android:layout_height="112dp"
        android:layout_alignParentBottom="true"
        android:gravity="center">

        <Button
            android:id="@+id/picture"
            android:background="@drawable/icondesign"
            android:textColor="#000000"
            app:backgroundTint="#FDF07C"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_weight="1"
            android:text="picture" />

        <Button
            android:id="@+id/change"
            android:background="@drawable/icondesign"
            app:backgroundTint="#FDF07C"
            android:textColor="#000000"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_weight="1"
            android:text="카메라 전/후면변경" />


    </LinearLayout>

</RelativeLayout>

 
 
 ```
 
 #### JoinActivity.java / 회원가입 페이지에 대한 기능 구현 코드  

 
```c
 public class JoinActivity extends Activity {
    TextView txtAlert;
    EditText txtID, txtPass, txtPassCk, txtName;
    Button btnOKJoin, btndel;


    private static final String TAG = "JoinActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_page);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        txtID = findViewById(R.id.txtID);
        txtPass = findViewById(R.id.txtPass);
        txtPassCk = findViewById(R.id.txtPassCk);
        txtAlert = findViewById(R.id.txtAlert);

        btnOKJoin = findViewById(R.id.btnOKJoin);
        btndel = findViewById(R.id.btndel);

        //비밀번호 일치 불일치
        txtPassCk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //일치 할 경우 출력
                if (txtPass.getText().toString().equals(txtPassCk.getText().toString())) {
                    txtAlert.setText("비밀번호가 일치합니다.");
                }
                //불일치 할 경우 출력
                else {
                    txtAlert.setText("비밀번호가 일치하지 않습니다.다시 입력해주세요.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnOKJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Join();

            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    private void Join() {

        String email = ((EditText) findViewById(R.id.txtID)).getText().toString();
        String password = ((EditText) findViewById(R.id.txtPass)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.txtPassCk)).getText().toString();

        if(email.length() > 0 && password.length() >0 && passwordCheck.length() > 0){

            if (password.equals(passwordCheck)) {
                RelativeLayout loaderLayout = findViewById(R.id.loaderLayout);
                loaderLayout.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, (task) ->  {
                            loaderLayout.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                StartMyActivity(UserInitActivity.class);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                if(task.getException() != null) {
                                    startToast(task.getException().toString());

                                }
                            }

                        });

            }else {
                startToast("비밀번호가 일치하지 않습니다.");
            }
        }else{
            startToast("이메일 또는 비밀번호를 입력해 주세요");
        }
    }


    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    private void StartMyActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
 
 
 ```
 
 #### LoginActivity.java / 로그인 페이지에 대한 기능 구현 코드 

 
```c
 
 public class LoginActivity extends Activity {


    private ISessionCallback mSessionCallback;

    EditText Login_ID, Login_Pass;
    Button btnLogin, btnJoin, btnPassreset;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        //카카오톡 로그인 메소드
        mSessionCallback = new ISessionCallback() {
            @Override
            public void onSessionOpened() {
                // 로그인 요청
                UserManagement.getInstance().me(new MeV2ResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        //로그인 실패
                        Toast.makeText(LoginActivity.this,"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        // 세션이 닫힘
                        Toast.makeText(LoginActivity.this,"세션이 닫혔습니다..다시 시도해주세요",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(MeV2Response result) {
                        // 로그인 성공

                       /* intent.putExtra("name", result.getKakaoAccount().getProfile().getNickname());
                        intent.putExtra("email",result.getKakaoAccount().getEmail());
                        intent.putExtra("profileImg",result.getKakaoAccount().getProfile().getProfileImageUrl());*/


                        Toast.makeText(LoginActivity.this,"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {
                Toast.makeText(LoginActivity.this, "onSessionOpenFailed",Toast.LENGTH_SHORT).show();
            }

        };


        Login_ID = findViewById(R.id.IdEditText);
        Login_Pass = findViewById(R.id.phoneNumber);

        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        btnPassreset = findViewById(R.id.btnInfoOk);

        // 로그인 버튼  / Intent 넘기는건 Login() Method 안에서 실행
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartMyActivity(JoinActivity.class);
            }
        });
        btnPassreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartMyActivity(PassresetActivity.class);
            }
        });


    }

    private void Login() {

        String email = ((EditText) findViewById(R.id.IdEditText)).getText().toString();
        String password = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();


        if (email.length() > 0 && password.length() > 0) {
            RelativeLayout loderLayout = findViewById(R.id.loaderLayout);
            loderLayout.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            loderLayout.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인에 성공하였습니다.");
                           finish();
                                    StartMyActivity(MainActivity.class);
                            } else {
                                if(task.getException() != null){
                                    startToast(task.getException().toString());
                                }

                            }
                        }
                    });
        } else {
            startToast("이메일 또는 비밀번호를 입력해 주세요");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c){
         Intent intent = new Intent(this, c);
         startActivity(intent);
    }

}


 
 ```
 
  #### Passreset.java / 비밀번호 재설정 페이지에 대한 코드 

 
```c
 public class PassresetActivity extends Activity {


    EditText emailEditText;
    Button btnSend;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.passreset_page);


        emailEditText = findViewById(R.id.phoneNumber);
        btnSend = findViewById(R.id.btnSend);



        // Intent 넘기는건 Login() Method 안에서 실행
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

    }

  #### Passreset.java / 비밀번호 재설정 페이지에 대한 코드 

 
```c
 public class PassresetActivity extends Activity {


    EditText emailEditText;
    Button btnSend;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.passreset_page);


        emailEditText = findViewById(R.id.phoneNumber);
        btnSend = findViewById(R.id.btnSend);



        // Intent 넘기는건 Login() Method 안에서 실행
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

    private void send() {

        String email = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();


        if (email.length() > 0) {
            RelativeLayout loaderLayout = findViewById(R.id.loaderLayout);
            loaderLayout.setVisibility(View.VISIBLE);
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            loaderLayout.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                startToast("비밀번호 재설정 이메일을 보냈습니다");
                            }
                        }
                    });
        } else {
            startToast("이메일을 입력해 주세요");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



}



 ```
 
   #### Join_page.xml / 회원가입(JoinActivity.java) 에 대한 Layout 디자인 코드 추가 

 
```c

      <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFFFF">

    <include
        layout="@layout/view_loader"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="181dp"
        tools:layout_editor_absoluteY="634dp"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="108dp"
        android:text="NAVI"
        android:textSize="30sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


    <EditText
        android:id="@+id/txtID"
        android:layout_width="220dp"
        android:layout_height="45dp"
        android:layout_marginTop="40dp"
        android:ems="10"
        android:hint="아이디"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.502"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <EditText
        android:id="@+id/txtPass"
        android:layout_width="220dp"
        android:layout_height="45dp"
        android:layout_marginTop="28dp"
        android:ems="10"
        android:hint="비밀번호"
        android:inputType="textPassword"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.502"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtID" />

    <EditText
        android:id="@+id/txtPassCk"
        android:layout_width="220dp"
        android:layout_height="45dp"
        android:layout_marginTop="28dp"
        android:ems="10"
        android:hint="비밀번호 확인"
        android:inputType="textPassword"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.502"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtPass" />

    <Button
        android:id="@+id/btndel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="44dp"
        android:layout_marginLeft="44dp"
        android:background="@drawable/icondesign"
        android:text="취소"
        app:backgroundTint="#FDF07C"
        android:textColor="#000000"
        app:layout_constraintStart_toEndOf="@+id/btnOKJoin"
        app:layout_constraintTop_toTopOf="@+id/btnOKJoin" />

    <Button
        android:id="@+id/btnOKJoin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="96dp"
        android:layout_marginLeft="96dp"
        android:layout_marginTop="77dp"
        android:background="@drawable/icondesign"
        android:text="가입"
        android:textColor="#000000"
        app:backgroundTint="#FDF07C"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtAlert" />

    <TextView
        android:id="@+id/txtAlert"
        android:layout_width="220dp"
        android:layout_height="20dp"
        android:layout_marginTop="8dp"
        android:text=""
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.502"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtPassCk" />


</androidx.constraintlayout.widget.ConstraintLayout>

 ```
 
 
   #### Login_page.xml / 로그인(LoginActivity.java) 에 대한 Layout 디자인 코드 추가  

 
```c
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".LoginActivity">

    <include
        layout="@layout/view_loader"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="181dp"
        tools:layout_editor_absoluteY="634dp"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="108dp"
        android:text="NAVI"
        android:textSize="30sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


    <Button
        android:id="@+id/btnLogin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="48dp"
        android:background="@drawable/icondesign"
        android:text="로그인"
        android:textColor="#000000"
        app:backgroundTint="#FDF07C"
        app:layout_constraintStart_toStartOf="@+id/phoneNumber"
        app:layout_constraintTop_toBottomOf="@+id/phoneNumber" />


    <Button
        android:id="@+id/btnInfoOk"
        android:layout_width="209dp"
        android:layout_height="32dp"
        android:layout_marginTop="112dp"
        android:background="@drawable/icondesign"
        android:text="비밀번호 재설정"
        android:textColor="#000000"
        app:backgroundTint="#FDF07C"
        app:layout_constraintEnd_toEndOf="@+id/btnJoin"
        app:layout_constraintStart_toStartOf="@+id/btnLogin"
        app:layout_constraintTop_toBottomOf="@+id/phoneNumber" />

    <EditText
        android:id="@+id/IdEditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="226dp"
        android:layout_marginBottom="233dp"
        android:ems="10"
        android:hint="ID"
        android:inputType="text"
        app:layout_constraintBottom_toTopOf="@+id/btnKakao"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/phoneNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="44dp"
        android:ems="10"
        android:hint="비밀번호"
        android:inputType="textPassword"
        app:layout_constraintStart_toStartOf="@+id/IdEditText"
        app:layout_constraintTop_toBottomOf="@+id/IdEditText" />

    <Button
        android:id="@+id/btnJoin"
        android:layout_width="90dp"
        android:layout_height="50dp"
        android:layout_marginStart="32dp"
        android:layout_marginLeft="32dp"
        android:background="@drawable/icondesign"
        android:text="가입"
        android:textColor="#000000"
        app:backgroundTint="#FDF07C"
        app:layout_constraintStart_toEndOf="@+id/btnLogin"
        app:layout_constraintTop_toTopOf="@+id/btnLogin" />

    <com.kakao.usermgmt.LoginButton
        android:id="@+id/btnKakao"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="48dp"
        android:layout_marginBottom="177dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/IdEditText" />

</androidx.constraintlayout.widget.ConstraintLayout>
      

 ```
 
 

 
 
 



<br>
<br>






## Firebase DB  <br>
<br>
<br>
 
 #### 사용자 DB (Authentication)<br>
 ![DB22 (1)](https://user-images.githubusercontent.com/74412438/121343415-9abab180-c95d-11eb-899a-cae20f1dad80.png)
<br>
 
 #### 사용자정보 DB (Firestore)<br>
  ![image](https://user-images.githubusercontent.com/74412438/121343737-f8e79480-c95d-11eb-8fd9-21c61dea3a0a.png)
<br>
 
 
#### 게시글 DB (Firestore)<br>
  ![DB44 (1)](https://user-images.githubusercontent.com/74412438/121344165-64c9fd00-c95e-11eb-8cd0-5e7215265aa6.png)
<br>
 
 #### 카메라 및 갤러리 (Storage)<br>
  ![image](https://user-images.githubusercontent.com/74412438/121343737-f8e79480-c95d-11eb-8fd9-21c61dea3a0a.png)
<br>
 
 


<br><br><br>
     
 ## 프로젝트 진행방식  <br>

    
  <strong>  1-1 매 주차 Discord를 이용하였으며, 평균 주 2회의 회의를 진행. </strong><br>
          다음과 같은 과정으로 프로젝트 진행.<br><br>
        - 회의 전 각 팀원별 준비자료를 종합하여 회의 간 내용 공유<br>
        - 공유한 내용을 기반으로 팀원 간 보완점 논의 <br>
        - 최종 프로젝트 구상 회의  <br><br>

![111 (1)](https://user-images.githubusercontent.com/74412438/120943536-6af78800-c76a-11eb-9e69-e65539cad924.png) <br>Discord 회의화면




 
 

<br>

## Navi-app 기획서 및 스토리보드
   <br><br>
![슬라이드3](https://user-images.githubusercontent.com/74412438/130820377-e8ed3ccf-0787-488e-845b-96ff3a4e171f.PNG)<br><br>
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



