package com.example.cc.PresenterLayer.Login;

import android.text.TextUtils;

import com.example.cc.ModelLayer.LocalLoginPhone;
import com.example.cc.ModelLayer.LoginService.ILoginMode;
import com.example.cc.ModelLayer.LoginService.LoginService;

/**
 * Created by cc on 16/4/13.
 */
public class LoginPresenter {

    private ILoginView mILoginView;


    public LoginPresenter(ILoginView iLoginView) {
        mILoginView = iLoginView;
    }

    public void onCreate() {

        LocalLoginPhone localLoginPhone = new LocalLoginPhone();

        String phone = localLoginPhone.getLoginPhone(mILoginView.getContext());

        mILoginView.setPhone(phone);

    }

    public void deletePhoneClick() {

        mILoginView.setPhone("");

    }

    public void deletePassWordClick() {
        mILoginView.setPassWroid("");
    }

    public void forgetPassWordClick() {
        mILoginView.startForgetActivity();
    }

    public void LoginClick() {

        String phone = mILoginView.getPhone();

        if (TextUtils.isEmpty(phone)) {

            mILoginView.promptToastMessge("填写信息有误");

            return;
        }

        String possWord = mILoginView.getPassWord();

        if (TextUtils.isEmpty(possWord)) {

            mILoginView.promptToastMessge("填写信息有误");

            return;
        }

        mILoginView.showProgressBar("正在加载");

        LoginService loginService = new LoginService(new ILoginMode() {
            @Override
            public void onSuccess(Object object) {
                mILoginView.setProgressBarMessage(object.toString());
                mILoginView.hideProgressBar();

                mILoginView.startIndexActivity();
            }

            @Override
            public void onFail(Object object) {
                mILoginView.setProgressBarMessage(object.toString());
                mILoginView.hideProgressBar();
                mILoginView.promptToastMessge("提交失败");
            }
        });


    }


}
