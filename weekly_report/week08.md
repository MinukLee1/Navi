# Week08 <br><br>

## 1. 8주차 회의  
<br>
   <strong>  1-1 매 주차와 같이 Discord를 이용하였으며, 8주차는 4/27(화) 진행하였음. </strong><br>
         다음과 같은 과정으로 프로젝트 진행.<br><br>
        - 회의 전 각 팀원별 준비자료를 종합하여 회의 간 내용 공유<br>
        - 공유한 내용을 기반으로 팀원 간 보완점 논의 <br>
        - 최종 프로젝트 구상 회의  <br><br>

![image](https://user-images.githubusercontent.com/74412438/116230381-8ac28600-a792-11eb-8ffb-458502b21e3b.png)
<br> 8주차 - 1 Discord 회의화면

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




## 3.2 황성택  Review <br><br>
 구글MAP 을 사용하지 않고 카카오MAP을 사용한 이유는 보다 다양한 마크업표시가 가능하고 API에 대한 설명이 보다 자세하게 나와있어 사용하게 되었다.<br>
  1. 주차 Read.me 에 나와있는 카카오로그인방식과 같이 앱등록 후 해쉬키까지 등록해준다. 
  2. 아래에 나와있는 링크로 들어가 SDK파일을 압축해제 한 후 각 파일에 맞게 압축한 SDK파일을 넣어준다.
     >> SDK다운로드 및 파일추가 링크 https://apis.map.kakao.com/android/guide/
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
 
## 3.3 최수빈  Review <br><br>
 
     

## 3.4 박예진  Review <br><br>



## 3.5 이민욱  Review <br><br>

 MySQL 
   
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



