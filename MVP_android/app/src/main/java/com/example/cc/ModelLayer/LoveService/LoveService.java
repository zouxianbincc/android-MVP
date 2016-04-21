package com.example.cc.ModelLayer.LoveService;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cc on 16/4/14.
 */
public class LoveService {






    public void getRefreshLoveData(final ILoveModel iLoveModel) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<String> list = new ArrayList<String>();

                for (int i = 0; i < 10; i++) {

                    list.add("刷新＋" + new Random().nextInt());
                }

                if (new Random().nextBoolean()){
                    iLoveModel.onSuccess(list);

                    return;
                }

                iLoveModel.onFail("失败了");


            }
        }, 3000);

    }

    public void getMoreLoveData(final ILoveModel iLoveModel) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<String> list = new ArrayList<String>();

                for (int i = 0; i < 10; i++) {

                    list.add("加载＋" + new Random().nextInt());
                }

                if (new Random().nextBoolean()){
                    iLoveModel.onSuccess(list);

                    return;
                }

                iLoveModel.onFail("失败了");


            }
        }, 3000);

    }

}
