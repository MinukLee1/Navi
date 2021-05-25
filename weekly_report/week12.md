
# Week12 <br><br>

## 1. 12주차 회의  
<br>
   <strong>  1-1 DB, Server / 안드로이드 스튜디오 개발 인력별로 대면 회의를 진행하였으며, 12주차는 5/22 ~ 5/23 (주말) 진행하였음. </strong><br>
         다음과 같은 과정으로 프로젝트 진행.<br><br>
        - 회의 전 각 팀원별 진척도를 종합하여 회의 중 내용 공유<br>
        - 공유한 내용을 기반으로 보완점 논의 <br>
        - 최종 프로젝트 구상 회의  <br><br>


<br><br>

## 2. 팀원별 역할분담 <br><br>
### -프론트엔드<br>
  
    
      •디자인 및 레이아웃
         -최수빈: 게시글 layout 및 기능
         
      •기능
         -황성택: 게시글업로드 Activity 제작
         -성주현: KakaoMap API를 사용하기 위한 Hash Key 추출 코드 작성, User의 현재 위치, 마커 기능, 트랙킹 모드 구현.
         
   ### -백엔드 <br>
      •데이터 베이스 / 서버구축
         -이민욱 : Account Table, Post Table 구현 및 key참조 (MySQL Workbench) 
         
      •데이터 베이스 / 서버구축
         -박예진 : FastAPI를 통해 Json형식의 데이터를 받을 수 있는 간단한 API서버 구축, DB tool(MySQL Workbench)와 Sever tool(Pycham)연결 
<br><br>

## 3.1 성주현  Review <br><br>

1. 프로필 사진 변경을 위한 변수 선언 (사진 찍기, 앨범에서 가져오기, 가져온 사진 자르기)

     private static final int PICK_FROM_CAMERA = 0;
     private static final int PICK_FROM_ALBUM = 1;
     private static final int CROP_FROM_iMAGE = 2;

     private Uri mImageCaptureUri;
     private ImageView iv_UserPhoto;
     private int id_view;
     private String absoultePath;
     //private DB_Manger dbmanger;


2. 사진 설정 코드.

          //카메라에서 프로필 사진 촬영
          public void doTakePhotoAction()  //카메라 촬영 후 이미지 가져오기
          {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

           //임시로 사용할 파일의 경로 생성
            String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + "jpg";
            mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                    url));

            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
            startActivityForResult(intent, PICK_FROM_CAMERA);
        }

        //앨범에서 프로필 사진 가져오기
        public void doTakeAlbumAction() //앨범에서 이미지 가져오기
        {
            //앨범 호출
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
            startActivityForResult(intent, PICK_FROM_ALBUM);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if(resultCode !=RESULT_OK)
                return;

            switch (requestCode)
            {
                case PICK_FROM_ALBUM: {
                    mImageCaptureUri = data.getData();
                    Log.d("SmartWheel", mImageCaptureUri.getPath().toString());
            }

            case PICK_FROM_CAMERA: {
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 200);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_iMAGE);
                break;
            }

                /*case CROP_FROM_iMAGE: {
                    if (resultCode !=null){
                        Bitmap photo = extras.getParcelable("data");
                        iv_UserPhoto.setImageBitmap(photo);
                        storeCropImage(photo, filePath);
                        absoultePath = filePath;
                        break;
                    }

                    File f = new File(mImageCaptureUri.getPath());
                    if(f.exists()){
                        f.delete();
                    }
                }
            }
         }


3. 프로필 사진 설정 시 노출되는 토스트 

                    new AlertDialog.Builder(this)
                    .setTitle("업로드할 이미지 선택")
                    .setPositiveButton("사진촬영", cameraListener)
                    .setNeutralButton("앨범선택", albumListener)
                    .setNegativeButton("취소", cancelListener)
                    .show();
                   
                   

완벽 기능 구현은 차주 진행 예정




## 3.2 황성택  Review <br><br>

  1.게시글기능에 사용할 변수를 만들어준다.
  
       Button btnUpload;
       TextView txtWrite;
       private FirebaseAuth mAuth;
  2.변수값에 대한 ID값을 가져와준다.
  
       mAuth = FirebaseAuth.getInstance();

       btnUpload = findViewById(R.id.btnUpload);
       txtWrite = findViewById(R.id.txtWrite);
  3.Upload버튼 클릭시 수행되는 기능을 작성해준다.
  
       btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                           Upload();
            }

            private void Upload() {

                String upwrite = ((EditText) findViewById(R.id.txtWrite)).getText().toString();
                String upload = ((Button) findViewById(R.id.btnUpload)).getText().toString();

                if(TextUtils.isEmpty((CharSequence) txtWrite)){
                    Toast.makeText(getApplicationContext(), "메세지를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
   firebase와 연동하는 부분은 차주 진행할 예정이다.     
 
## 3.3 최수빈  Review <br><br>

  1.게시글 업로드를 수행할 layout 파일을 만들어준다.(임시)

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.5" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        app:layout_constraintBottom_toTopOf="@+id/guideline2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@android:drawable/ic_menu_gallery" />

    <EditText
        android:id="@+id/txtWrite"
        android:layout_width="393dp"
        android:layout_height="116dp"
        android:layout_marginTop="8dp"
        android:ems="10"
        android:gravity="start|top"
        android:inputType="textMultiLine"
        app:layout_constraintEnd_toEndOf="@+id/imageView"
        app:layout_constraintHorizontal_bias="0.428"
        app:layout_constraintStart_toStartOf="@+id/imageView"
        app:layout_constraintTop_toTopOf="@+id/guideline2" />

    <Button
        android:id="@+id/btnUpload"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="16dp"
        android:text="Button"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

   ![캡처](https://user-images.githubusercontent.com/79950091/119503050-85625680-bda5-11eb-9ba0-15573b6a5869.PNG)


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



