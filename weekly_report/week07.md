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
<strong> 기능<br>
-프로트앤드<br>
   •기능<br>
       -성택:~~~<br>
       -주현:~~~<br>
   •디자인 및 레이아웃<br>
       -수빈:~~~<br>
-백앤드<br>
     •데이터 베이스<br>
       -민욱:~~<br><br> </strong>
        
<br><br>
     
## 3. Import할 Map API 시연 및 선정 <br><br>

   대표적인 Map기반 API인 Kakao & Google 두가지를 별도 프로젝트에서 시연해보고, 지원해주는 기능이 더 많고 호환성이 좋은 API를 선정. <br> <br>
![image](https://user-images.githubusercontent.com/74412438/114547275-3353ee80-9c99-11eb-9ca7-70cb57604df3.png)
 ![image](https://user-images.githubusercontent.com/74412438/114547131-043d7d00-9c99-11eb-90e2-6d913145d521.png) <br><br>
  <br><br><br>

<strong>- Google map 및 Kakao map API 시연 AVD  </strong><br><br>
![image](https://user-images.githubusercontent.com/74412438/114548106-46b38980-9c9a-11eb-973d-fdef221ba0c2.png)
![image](https://user-images.githubusercontent.com/74412438/114548265-811d2680-9c9a-11eb-83d4-999a5f171616.png)

<br><br><br>
<strong>- 각 API의 대표적인 특징</strong> <br><br>
- Google MAP API : (payment required.. : 200,000won credit free when creating an account.)
결제계정 생성 시 대충 20여만원의 크레딧을 제공한다. 이후로는 유료로 책정.


- KAKAO MAP API : (1day, 300000 call, dev guide is perfect)
KAKAO MAP API는 상당히 여러가지 기능과 인터페이스를 제공한다. 심지어 30만콜이 무료이며 가이드가 상당히 잘 짜여져있다.

<br><br>
![image](https://user-images.githubusercontent.com/74412438/114549519-110fa000-9c9c-11eb-9cc9-1573df648bb6.png)

<br><br>
### <strong>-최종 선정 API </strong><br><br>
Kakao Map API <br><br>
### <strong>-선정 이유 </strong><br><br>
더 높은 직관성 , 지원하는 기능의 폭넓음, 국내에 최적화된 API, MarkUp기능지원  
        

   <br><br><br>


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



