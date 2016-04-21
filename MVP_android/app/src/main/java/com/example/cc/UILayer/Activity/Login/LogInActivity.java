package com.example.cc.UILayer.Activity.Login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cc.BaseActivity;
import com.example.cc.PresenterLayer.Login.ILoginView;
import com.example.cc.PresenterLayer.Login.LoginPresenter;
import com.example.cc.R;
import com.example.cc.UIHelper;
import com.example.cc.UILayer.Activity.Index.IndexActivity;
import com.example.cc.Utlis.Dialog.LittleDialog;


/**
 * Created by cc on 16/4/13.
 */
public class LogInActivity extends BaseActivity implements ILoginView {


    private EditText login_et_phone, login_et_password;

    private Button login_btn_delete_phone, login_btn_delete_password, login_btn_login, login_btn_forget_password;

    private LoginPresenter mLoginPresenter;

    private LittleDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_login);

        initView();

        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.onCreate();
    }



    private void initView() {

        login_et_phone = (EditText) findViewById(R.id.login_et_phone);
        login_et_password = (EditText) findViewById(R.id.login_et_password);
        login_btn_delete_phone = (Button) findViewById(R.id.login_btn_delete_phone);
        login_btn_delete_password = (Button) findViewById(R.id.login_btn_delete_password);
        login_btn_login = (Button) findViewById(R.id.login_btn_login);
        login_btn_forget_password = (Button) findViewById(R.id.login_btn_forget_password);


        login_btn_delete_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.deletePhoneClick();
            }
        });
        login_btn_delete_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.deletePassWordClick();
            }
        });
        login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.LoginClick();
            }
        });
        login_btn_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.forgetPassWordClick();
            }
        });

    }

    @Override
    public String getPhone() {
        return login_et_phone.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return login_et_password.getText().toString().trim();
    }

    @Override
    public void setPhone(String phone) {

        login_et_phone.setText(phone);

    }

    @Override
    public void setPassWroid(String passWroid) {
        login_et_password.setText(passWroid);
    }

    @Override
    public void startIndexActivity() {
        UIHelper.startActivity(this, IndexActivity.class, null);
    }

    @Override
    public void startForgetActivity() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void promptToastMessge(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    @Override
    public void showProgressBar(String msg) {
        mDialog = new LittleDialog(this, msg);
        mDialog.show();

    }

    @Override
    public void setProgressBarMessage(String msg) {
        if (null != mDialog)
            mDialog.setMessage(msg);
    }

    @Override
    public void hideProgressBar() {

        if (null != mDialog)
            mDialog.dismiss();

    }


}
