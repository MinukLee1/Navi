# Week10 <br><br>

## 1. 11주차 회의  
<br>
   <strong>  1-1 DB, Server / 안드로이드 스튜디오 개발 인력별로 대면 회의를 진행하였으며, 11주차는 5/15 ~ 5/16 (주말) 진행하였음. </strong><br>
         다음과 같은 과정으로 프로젝트 진행.<br><br>
        - 회의 전 각 팀원별 진척도를 종합하여 회의 중 내용 공유<br>
        - 공유한 내용을 기반으로 보완점 논의 <br>
        - 최종 프로젝트 구상 회의  <br><br>


<br><br>

## 2. 팀원별 역할분담 <br><br>
### -프로트엔드<br>
  
    
      •디자인 및 레이아웃
         -최수빈: Login & Sign up Layout 구현, UI 이미지 자료 수집 및 제작
         
      •기능
         -황성택: kakaoMAP API를 통한 Map_Activity 구현(Splash Screen 동작 후 메인으로 보여지는 화면)
         -성주현: naver 로그인 구현 (Naver Developer), 회원가입 폼 중 비밀번호 동일성 확인 여부 구현(DB와 연동 전)
         
   ### -백엔드 <br>
      •데이터 베이스 / 서버구축
         -이민욱 : Account Table, Post Table 구현 및 key참조 (MySQL Workbench) 
         
      •데이터 베이스 / 서버구축
         -박예진 : FastAPI를 통해 Json형식의 데이터를 받을 수 있는 간단한 API서버 구축, DB tool(MySQL Workbench)와 Sever tool(Pycham)연결 
<br><br>

## 3.1 성주현  Review <br><br>

1. 카카오맵을 사용하기 위해서는 Hash키가 필요하다. 다음 code를 통해 각 pc에 할당된 고유 hash key를 추출할 수 있다.

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

         Log.e("getKeyHash", ""+ getKeyHash(this));


 
2. 사용자의 현재 위치를 화면에 출력해주는 code.
         mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
         
         

3. 사용자의 현재 위치를 마커로 표시해주는 code
            MapPOIItem marker = new MapPOIItem();
            marker.setItemName("Default Marker");
            marker.setTag(0);
            //marker.setMapPoint(MARKER_POINT);
            marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
            //marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
            mapView.addPOIItem(marker);
            mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);






## 3.2 황성택  Review <br><br>
 구글MAP 을 사용하지 않고 카카오MAP을 사용한 이유는 보다 다양한 마크업표시가 가능하고 API에 대한 설명이 보다 자세하게 나와있어 사용하게 되었다.<br>
  1. 6주차 Read.me 에 나와있는 카카오로그인방식과 같이 앱등록 후 해쉬키까지 등록해준다. 
  2. 아래에 나와있는 링크로 들어가 SDK파일을 압축해제 한 후 각 파일에 맞게 압축한 SDK파일을 넣어준다.<br> >> SDK다운로드 및 파일추가 링크 https://apis.map.kakao.com/android/guide/
  3. 2번 방식과 같이 진행하게되면 아래와 같은 코드가 나오는데 이를 sync now 해준다.
  
            splits {
            abi {
            enable true
            reset()
            include 'arm64-v8a','armeabi-v7a', 'armeabi'
            universalApk false
            }
            } 
  4. xml 파일을 추가해 http 통신에 대한 예외 처리를 해준다.(targetSDKVersion이28이상일 경우)
  
             <?xml version="1.0" encoding="utf-8"?>
            
           <network-security-config>
           <domain-config cleartextTrafficPermitted="true">
           <domain includeSubdomains="true">maps.daum-img.net</domain>
           </domain-config>
           </network-security-config>
  5. 카카오MAP을 보여줄 레이아웃을 만들어준다.

             <RelativeLayout
          android:id="@+id/map_view"
          android:layout_width="match_parent"
          android:layout_height="match_parent"/>
  6. MainActivity에 맵View에 대한 자바코드를 작성해준다.
  
          public class MainActivity extends AppCompatActivity {
          MapView mapView;
          RelativeLayout mapViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapViewContainer = (RelativeLayout)findViewById(R.id.map_view);
        mapView = new MapView(this);
        mapViewContainer.addView(mapView);
    );
  
  7. 추가적으로 현재위치를 계속 받아오면서 나침반 모드를 활성해주는 코드를 onCreate 안에 작성해준다.
  
         mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
 
## 3.3 최수빈  Review <br><br><br><br>

splash 화면 이미지 디자인 구현
나만의 비밀 장소 - 나비 타이틀에 맞게 나비를 연상시키는 노란색과 나,비를 강조하여 프로젝트의 주제를 나타냈다.

1.style.xml 파일에 원하는 이미지파일을 넣어준다.

     <style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
        <item name="android:windowBackground">@drawable/navi_splash</item>
     </style>
2.Manifest 파일에 splash Java 코드를 넣어준다.

       <activity android:name=".SplashActivity"
            android:theme="@style/SplashTheme">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
3.Splash 동작 후 Mainpage로 넘어가는 작동코딩을 해준다.

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
4.구동 결과

![splash](https://user-images.githubusercontent.com/79950091/116997887-5f9ee000-ad18-11eb-8b96-e8694b4fa37d.PNG) 

<br><br><br><br>
 
    

## 3.4 박예진  Review <br><br>

 - DB 연동 서버 구축 및 방식 구현비교, 선정 ( Android <-> OR FireBase )  <br><br>
 - 사용자DB 및 서버 환경구축 ( Google Firebase API ) <br><br>
 ![image](https://user-images.githubusercontent.com/74412438/118648499-6ef45200-b81d-11eb-8ec1-51ce41ae8707.png)<br>
 ![image](https://user-images.githubusercontent.com/74412438/118648752-b549b100-b81d-11eb-93f9-ec86b4270a14.png)<br><br><br>


 - Firebase Auth 관련 보완 및 수정<br><br>
 
        mAuth = FirebaseAuth.getInstance(); <br><br>
        
 - Client <-> DB 간 가입logic 구현<br>
       
       private void Join() {

        String email = ((EditText) findViewById(R.id.txtID)).getText().toString();
        String password = ((EditText) findViewById(R.id.txtPass)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.txtPassCk)).getText().toString();

        if(email.length() > 0 && password.length() >0 && passwordCheck.length() > 0){

            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, (task) ->  {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("회원가입에 성공하였습니다.");
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
  
<br><br><br><br>

## 3.5 이민욱  Review <br><br>

 - DB 연동 서버 구축 및 방식 구현비교, 선정 ( Android <-> OR FireBase )  <br><br>
 - 사용자DB 및 서버 환경구축 ( Google Firebase API ) <br><br>
  ![image](https://user-images.githubusercontent.com/74412438/118648474-66038080-b81d-11eb-9f27-aa6fed319d89.png)<br>
   ![image](https://user-images.githubusercontent.com/74412438/118648752-b549b100-b81d-11eb-93f9-ec86b4270a14.png)<br><br><br>

 - Flag를 통한 App 전반적 생명주기 컨트롤<br>

         private void StartMainActivity(){
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            }
       
 - Client <-> DB 간 로그인logic 구현<br>
        
        private void Login() {

        String email = ((EditText) findViewById(R.id.login_ID)).getText().toString();
        String password = ((EditText) findViewById(R.id.login_Pass)).getText().toString();


        if (email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인에 성공하였습니다.");
                                StartMainActivity();
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
    
 -App Theme 설정을 통한 정상적인 Activity Switch 구현<br>
 
             setTheme(R.style.SplashTheme);    -> Manifest/SplashActivity 
             setTheme(R.style.AppTheme);   -> LoginActivity
 <br><br>
   
 ## 4. 필터(filter) 기능에 대하여 <br><br>

   - 전체 사용자 게시글 피드노출의 필터링(filtering) 기능에 대한 부연설명 <br>
   <br>
   <br>
   <br>
   
   
   1.  해시태그(#)를 통한 키워드별 필터링 기능을 제공<br>
   2.  조회수 및 추천순에 비례한 상위노출(Descend) 필터링 제공<br>
   3.  사용자별 관심사 키워드 선택을 통한 추천장소 정렬<br><br>
   
   - DB에 해시태그(#) 조건에 맞는 table 관리 및 검색 키워드에 따른 연동을 지원한다. <br><br><br><br>







<br> <br><br>
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


    
## 7. 다음 주 목표
   <br>
    역할분담에 따른 App Project 진행 ( 서버, DB 구축 및 기능구현 )
<br><br>



