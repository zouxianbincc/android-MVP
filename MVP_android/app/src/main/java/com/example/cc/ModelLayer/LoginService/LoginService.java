package com.example.cc.ModelLayer.LoginService;

import android.os.Handler;

import java.util.Random;

/**
 * Created by cc on 16/4/13.
 */
public class LoginService {


    public LoginService(final ILoginMode iLoginMode) {

        //这里模拟网络请求。按道理来说。这里不该出现os包的代码。这里只为了测试。
        // 建设 model层。放在异步线程执行。可以试一下
        //Rx(rxjava或rxandroid) 与 Retrogit
        //Rx(rxjava或rxandroid) 可以简单理解为"异步"
        //Retrogit网络请求

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               //模拟加载数据

               if (new Random().nextBoolean()){
                   iLoginMode.onSuccess("请求成功");
                   return;
               }
               iLoginMode.onFail("请求失败");
           }
       },3000);




    }
}
