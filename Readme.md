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

   각 어플별 사용자 만족도가 높은 사용자 위치기반 주변 명소를 추천하는 기능을 기본으로 제공하며 다음과 같은 차별성을 둠 <br>
   
   <strong>차별성</strong>
   
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
##### 3. Logcat 터미널에 나오는 Hashkey를 [KakaoDeveloper](https://developers.kakao.com/) 에 등록
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

## Algorithm <br>


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



