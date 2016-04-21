package com.example.cc.PresenterLayer.Login;

import android.content.Context;

/**
 * Created by cc on 16/4/13.
 */
public interface ILoginView {

    String getPhone();

    String getPassWord();

    void setPhone(String phone);

    void setPassWroid(String passWroid);

    void startIndexActivity();

    void startForgetActivity();

    Context getContext();

    void promptToastMessge(String msg);



    void showProgressBar(String msg);

    void setProgressBarMessage(String msg);

    void hideProgressBar();


}
