# Week07 <br><br>

## 1. 7주차 회의  
<br>
   <strong>  1-1 매 주차와 같이 Discord를 이용하였으며, 7주차는 4/15(목),4/19(월)  두차례 진행하였음. </strong><br>
         다음과 같은 과정으로 프로젝트 진행.<br><br>
        - 회의 전 각 팀원별 준비자료를 종합하여 회의 간 내용 공유<br>
        - 공유한 내용을 기반으로 팀원 간 보완점 논의 <br>
        - 최종 프로젝트 구상 회의  <br><br>

![image](https://user-images.githubusercontent.com/74412438/114839758-1c380c80-9e11-11eb-8cd5-5fd5c7b0b0d0.png)
<br> 7주차 - 1 Discord 회의화면

<br><br>

## 2. 팀원별 역할분담 <br><br>
### -프로트엔드<br>

  
    
      •디자인 및 레이아웃
         -최수빈: Login & Sign up Layout 구현, UI 이미지 자료 수집 및 제작
         
      •기능
         -황성택: kakaoMAP API를 통한 Map_Activity 구현(Splash Screen 동작 후 메인으로 보여지는 화면), Kakao 로그인 구현 (Kakao Developer)
         -성주현: naver 로그인 구현 (Naver Developer), 회원가입 폼 중 비밀번호 동일성 확인 여부 구현(DB와 연동 전)
         
   ### -백엔드 <br>
      •데이터 베이스
         -이민욱 : Account Table, Post Table 구현 및 key참조 (MySQL Workbench)
         
      •서버구축
         -박예진 : FastAPI를 통해 Json형식의 데이터를 받을 수 있는 간단한 API서버 구축, DB tool(MySQL Workbench)와 Sever tool(Pycham)연결 
<br><br>

## 3.1 성주현 CODE Review <br><br>


        android:id="@+id/buttonOAuthLoginImg"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="368dp" />            
1.네이버 로그인 버튼을 생성해준다.


       private static String OAUTH_CLIENT_ID = "VN_A3mzSi0LfCZXXCr7w";
       private static String OAUTH_CLIENT_SECRET = "8xkYrJhLFd";
       private static String OAUTH_CLIENT_NAME =  " 네아로 테스트";
2.Naver Developer에서 사용자가 할당 받은 Client ID, Client Secret 그리고 사용자가지정한 Client Name을 입력해준다.



  
           public void onCreate(Bundle savedInstanceState){
           super.onCreate(savedInstanceState);
           setContentView(R.layout.naverloginactivity);
           mContext = this;
           initDate();
          }
          private void initDate(){
          mOAuthLoginInstance = OAuthLogin.getInstance();
          mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);
          mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
          mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
          }
3.initData를 통해 메소드 초기화


         protected void redirectSignupActivity(){
        final Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        finish();
        }
4.회원가입 후 이동할 Activity 설정<br><br>

## 3.2 황성택 CODE Review <br><br>

대한민국에서 가장 큰 sns중의 하나인 카카오톡을 이용한 로그인을 구현하여 간편하게 어플을 
즐길 수 있도록 하였다.

    dependencies {
    implementation 'com.kakao.sdk:usermgmt:1.29.0'
    }
    
    allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url 'http://devrepo.kakao.com:8088/nexus/content/groups/public/' }
    }
    }
1.Buildgradle(app)파일에 카카오 로그인을 위한 sdk, url을 추가해준다.

      <uses-permission android:name="android.permission.INTERNET"/>
      
      <meta-data
            android:name="com.kakao.sdk.AppKey"
            android:value="c44c9d483335fe534b2792f4f6b3c79a" />
     

2.manifest파일에 카카오 로그인에 필요한 인터넷연결을 permission하고 AppKey와 네이티브 키를 입력한다.


     private void getAppKeyHash() {
    try {
        PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md;
            md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            String something = new String(Base64.encode(md.digest(), 0));
            Log.e("Hash key", something);
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        Log.e("name not found", e.toString());
    }
    }
3.카카오 로그인을 하기위해 해시 키를 생성 후 카카오 디벨로퍼에 입력해준다.

      <com.kakao.usermgmt.LoginButton
        android:id="@+id/loginButton"
        android:layout_width="279dp"
        android:layout_height="46dp"
        android:layout_marginBottom="232dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent" />

4.카카오 로그인을 해주기 위한 카카오버튼을 구현해준다.

       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        strNick = intent.getStringExtra("name");
        strEmail = intent.getStringExtra("email");
        strProfileImg = intent.getStringExtra("profileImg");

        TextView tv_nick = findViewById(R.id.tv_nickName);
        TextView tv_email = findViewById(R.id.tv_email);
        ImageView iv_profile = findViewById(R.id.iv_profile);

        // 닉네임 set
        tv_nick.setText(strNick);
        // 이메일 set
        tv_email.setText(strEmail);
        // 프로필 이미지 사진 set
        Glide.with(this).load(strProfileImg).into(iv_profile);

        // 로그아웃 처리
        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        // 로그아웃 성공시 수행지점
                        finish(); //현재 액티비티 종료
      

5. 로그인후 프로필을 보여주기 위한 액티비티를 구현해준다.

## 3.3 최수빈 CODE Review <br><br>
    <EditText
        android:id="@+id/join_name"
        android:layout_width="220dp"
        android:layout_height="45dp"
        android:layout_marginTop="220dp"
        android:ems="10"
        android:hint="아이디"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
1.회원가입과 로그인 창에 사용되는 textBox 화면 구성을 EditText를 사용해준다.
각각의 inputType에 맞게 값을 입력해준다.

    <Button
        android:id="@+id/delete"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="87dp"
        android:layout_marginRight="87dp"
        android:text="취소"
        android:background="#FDF07C"
        app:backgroundTint="#FDF07C"
        app:layout_constraintBaseline_toBaselineOf="@+id/join_button"
        app:layout_constraintEnd_toEndOf="parent" />
       
 2.로그인/회원가입, 가입/취소 버튼 생성

 4.아직 적절한 테마나  화면 구성을 정하지 못하였지만 join/login 기능 구현이 완성되었을때 디테일한 Layout 화면을 정해줄 예정이다.

## 3.4 박예진 CODE Review <br><br>

1. fastAPI 구축을 필요한 파일 다운 코드

               $ pip install fastapi
               $ pip install uvicorn[standard]
2. fastAPI로 JSON파일을 받을 수 있는 간단한 API구축 

                     from typing import Optional
                     from fastapi import FastAPI

                     app = FastAPI()

                    @app.get("/")  #경로/
                    def read_root():
                    return {"Hello": "World"} #출력

                    @app.get("/items/{item_id}") #경로/items/item_id_int?q="str"
                    def read_item(item_id: int, q: Optional[str] = None): #item_id는 int형식, q는 str형식 
                    return {"item_id": item_id, "q": q} #출력
                    
                    

## 3.5 이민욱 CODE Review <br><br>

1. 사용자 계정에 대한 account table 생성 

              CREATE TABLE `account` (
                  `nickname` varchar(20) NOT NULL,
                  `name`varchar(10) NOT NULL,
                  `id` varchar(20) NOT NULL,
                  `pw` varchar(20) NOT NULL,
                   PRIMARY KEY (`nickname`)
                     ) 
2. 작성 게시글에 대한 post table 생성 (foreign key 참조)

                     CREATE TABLE `post` (
                         `postNum` int NOT NULL,
                         `title` varchar(10) NOT NULL,
                         `contents` varchar(500) NOT NULL,
                          `nickname` varchar(20) NOT NULL,
                         PRIMARY KEY (`postNum`),
                         KEY `nickname` (`nickname`),
                         CONSTRAINT `post_ibfk_1` FOREIGN KEY (`nickname`) REFERENCES `account` (`nickname`)
                         ) 


   
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



