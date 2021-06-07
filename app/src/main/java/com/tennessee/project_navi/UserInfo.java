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
   public ImageView profileImage;

   public UserInfo(String name, String phoneNumber, String birthDay, String address,ImageView profileImage){
         this.name = name;
         this.phoneNumber = phoneNumber;
         this.birthDay = birthDay;
         this.address = address;
         this.profileImage = profileImage;
   }


   public String getname(){
      return this.name;
   }
   public void setname(String name){
      this.name = name;
   }

   public String getphoneNumber(){
      return this.phoneNumber;
   }
   public void setphoneNumber(String phoneNumber){
      this.phoneNumber = phoneNumber;
   }
   public String getbirthDay(){
      return this.birthDay;
   }
   public void setbirthDay(String birthDay){
      this.birthDay = birthDay;
   }
   public String getaddress(){
      return this.address;
   }
   public void setaddress(String address){
      this.address = address;
   }

}

