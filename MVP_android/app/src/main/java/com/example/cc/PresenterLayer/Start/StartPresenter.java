package com.example.cc.PresenterLayer.Start;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.example.cc.Entity.UserEntity;
import com.example.cc.ModelLayer.LocalUserInfo;
import com.example.cc.ModelLayer.LocalVersion;
import com.example.cc.ModelLayer.SystemVersionInfo;

/**
 * Created by cc on 16/4/13.
 */
public class StartPresenter {

    private IStartView mIStartView;

    private LocalVersion mLocalVersion;

    public StartPresenter(IStartView iStartView) {
        mIStartView = iStartView;

    }

    public void onCreate(final Context context) {
        Log.e("fs","onCreatekkkkkkkk......................................................................................................");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mLocalVersion = new LocalVersion();

                int localVersion = mLocalVersion.getLocalVersion(context);//获取model保存的版本号

                int systemVersion = SystemVersionInfo.getVersionCode(context);//获取当前的版本号


                UserEntity userEntity = LocalUserInfo.getUserInfo(context);//获取用户登录状态

                if (TextUtils.isEmpty(userEntity.token)){

                    Log.e("fd","fgfgfgfgf---------------------------------------------------------------------------------------------------------------");
                    mIStartView.startGuide();
                    return;
                }

                if (localVersion < systemVersion) {


                    Log.e("fd","fffff--------------------------------------------------------------------------------------------------------------");
                    mIStartView.startGuide();
                    return;

                }


                Log.e("fd","gggggggg---------------------------------------------------------------------------------------------------------------");
                mIStartView.startMain();
            }
        },5000);

    }
}
