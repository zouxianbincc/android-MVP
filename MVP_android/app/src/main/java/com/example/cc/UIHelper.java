package com.example.cc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.cc.UILayer.Activity.Index.IndexActivity;

/**
 * UI操作辅助类
 * @author alafighting 2016-0
 */
public class UIHelper {

    /**
     * 界面跳转
     * @param context
     * @param activity
     * @param bundle
     */
    public static void startActivity(Context context, Class<? extends Activity> activity, Bundle  bundle) {
        if (context == null) {
            throw new NullPointerException("context不能为空");
        }
        Intent intent = new Intent(context, activity);

        if (null !=bundle){
            intent.putExtras(bundle);
        }


        context.startActivity(intent);
    }


    /**
     * 打开主界面
     * @param context
     */
    public static void startMain(Context context) {
        startActivity(context, IndexActivity.class,null);
    }

}
