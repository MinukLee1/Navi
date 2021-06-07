package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class UserInfo {


   private String name;
   private String phoneNumber;
   private String birthDay;
   private String address;
   private ImageView profileImage;

   public UserInfo(String name, String phoneNumber, String birthDay, String address,ImageView profileImage){
         this.name = name;
         this.phoneNumber = phoneNumber;
         this.birthDay = birthDay;
         this.address = address;
         this.profileImage = profileImage;
   }


   public String getName(){
      return this.name;
   }
   public void setName(String name){
      this.name = name;
   }

   public String getPhoneNumber(){
      return this.phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber){
      this.phoneNumber = phoneNumber;
   }
   public String getBirthDay(){
      return this.birthDay;
   }
   public void setBirthDay(String birthDay){
      this.birthDay = birthDay;
   }
   public String getAddress(){
      return this.address;
   }
   public void setAddress(String address){
      this.address = address;
   }
   public ImageView getProfileImage(){
      return this.profileImage;
   }
   public void setProfileImage(ImageView address){
      this.profileImage = profileImage;
   }

}

