package com.example.cc.ModelLayer;

import android.content.Context;

import com.example.cc.Entity.UserEntity;
import com.example.cc.Utlis.SharedPrefsUtil;

/**
 * Created by cc on 16/4/13.
 */
public class LocalUserInfo {


    public static UserEntity getUserInfo(Context context) {

        UserEntity userEntity = new UserEntity();

        userEntity.token =SharedPrefsUtil.getValue(context,"TOKEN","token",null);




        return userEntity;


    }


    public static void saveUserInfo(Context context,UserEntity userEntity) {

        SharedPrefsUtil.putValue(context,"TOKEN","token",userEntity.token);



        //保存数据
    }


}
