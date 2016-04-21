package com.example.cc.ModelLayer;

import android.content.Context;

import com.example.cc.Utlis.SharedPrefsUtil;

/**
 * Created by cc on 16/4/13.
 */
public class LocalLoginPhone {

    private String LoginPhone = "LOGINPHONE";

    private String LoginPhoneKey = "LoginPhone";


    public  String getLoginPhone(Context context) {

        return SharedPrefsUtil.getValue(context, LoginPhone, LoginPhoneKey, "");
    }


    public void saveLoginPhone(Context context, String phone) {


        SharedPrefsUtil.putValue(context, LoginPhone, LoginPhoneKey, phone);
    }
}
