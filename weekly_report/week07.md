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
         -수빈: Login & Sign up Layout 구현, UI 이미지 자료 수집 및 제작
         
      •기능
         -성택: kakaoMAP API를 통한 Map_Activity 구현(Splash Screen 동작 후 메인으로 보여지는 화면), Kakao 로그인 구현 (Kakao Developer)
         -주현: naver 로그인 구현 (Naver Developer), 회원가입 폼 중 비밀번호 동일성 확인 여부 구현(DB와 연동 전)
         
   ### -백엔드 <br>
      •데이터 베이스
         -민욱 : (MySQL Workbench) Account Table, Post Table 구현 및 key참조 
      •서버구축
         -예진 : FastAPI를 통해 Json형식의 데이터를 받을 수 있는 API서버 구축, DB tool(MySQL Workbench)와 Sever tool(Pycham)연결 
<br><br>

## 3. CODE Review <br><br>

        android:id="@+id/buttonOAuthLoginImg"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="368dp" />            
1. 네이버 로그인 버튼을 생성해준다.


       private static String OAUTH_CLIENT_ID = "VN_A3mzSi0LfCZXXCr7w";
       private static String OAUTH_CLIENT_SECRET = "8xkYrJhLFd";
       private static String OAUTH_CLIENT_NAME =  " 네아로 테스트";
2. Naver Developer에서 사용자가 할당 받은 Client ID, Client Secret 그리고 사용자가지정한 Client Name을 입력해준다.



  
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
3. initData를 통해 메소드 초기화


         protected void redirectSignupActivity(){
        final Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        finish();
        }
4. 회원가입 후 이동할 Activity 설정

 ## 4. 필터(filter) 기능에 대하여 <br><br>

   - 전체 사용자 게시글 피드노출의 필터링(filtering) 기능에 대한 부연설명 <br>
   <br>
   
   
   1.  해시태그(#)를 통한 키워드별 필터링 기능을 제공<br>
   2.  조회수 및 추천순에 비례한 상위노출(Descend) 필터링 제공<br>
   3.  사용자별 관심사 키워드 선택을 통한 추천장소 정렬<br><br>
   
   - DB에 해시태그(#) 조건에 맞는 table 관리 및 검색 키워드에 따른 연동을 지원한다. <br><br><br><br>



   
## 5. Project 생성 및 Splash screen 구현 <br><br>
- Navi_Project 생성 및 최초 Github commit <br><br>
 ![image](https://user-images.githubusercontent.com/74412438/114554334-921d6600-9ca1-11eb-8f11-902b24e55ffd.png)
 <br><br>
 
- Splash 기능 구현<br>
 레이아웃 파일을 사용하지 않고, 대신 Activity의 테마 배경을 변경하는 방식으로 구현을 진행. <br><br>


      public class SplashActivity extends AppCompatActivity {
       @Override
       protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
          }
         }
   

<br><br>

 <strong>Splash screen 구현장면<br></strong><br>
   ![2021-04-13 21-52-34 (online-video-cutter com)](https://user-images.githubusercontent.com/74412438/114555926-250ad000-9ca3-11eb-9e54-9df23e8fb42c.gif)

<br> <br><br>
## 6. 프로젝트 기획서 및 스토리보드 
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



