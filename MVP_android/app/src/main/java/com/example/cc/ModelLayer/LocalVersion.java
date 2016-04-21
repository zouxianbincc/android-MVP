package com.example.cc.ModelLayer;

import android.content.Context;

import com.example.cc.Utlis.SharedPrefsUtil;

/**
 * Created by cc on 16/4/13.
 */
public class LocalVersion {


    private String mFileName = "VERSION";
    private String mVersionKey = "version";

    public int getLocalVersion(Context context) {

        //对于调用者来说。只关心结果。

        int version = SharedPrefsUtil.getValue(context, mFileName, mVersionKey, 0);

        return version;

    }

    public void saveLocalVersion(Context context, int version) {

        //对于调用者来说。不关心是如果保存的,也不关心我保存的ＫＥＹ 和 文件是什么。只要保存
        SharedPrefsUtil.putValue(context, mFileName, mVersionKey, version);

    }

}
