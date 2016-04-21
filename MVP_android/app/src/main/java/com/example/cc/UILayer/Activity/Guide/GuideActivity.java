package com.example.cc.UILayer.Activity.Guide;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.cc.BaseActivity;
import com.example.cc.PresenterLayer.Guide.GuidePresenter;
import com.example.cc.PresenterLayer.Guide.IGuideView;
import com.example.cc.R;
import com.example.cc.UIHelper;
import com.example.cc.UILayer.Activity.Login.LogInActivity;
import com.example.cc.UILayer.Adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 16/4/13.
 */
public class GuideActivity extends BaseActivity implements IGuideView {


    private ViewPager guide_vp_img;


    private GuidePresenter mGuidePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_guide);
        initView();

        mGuidePresenter = new GuidePresenter(this);

        mGuidePresenter.onCreate();

    }


    private void initView() {

        guide_vp_img = (ViewPager) findViewById(R.id.guide_vp_img);


    }

    @Override
    public void setGuideData(List<View> views) {

        guide_vp_img.setAdapter(new GuideAdapter(views));


    }

    @Override
    public List<View> getGuideViews() {

        View view1 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view1.setBackgroundResource(R.color.colorAccent);

        View view2 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view2.setBackgroundResource(R.color.colorPrimary);

        View view3 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view3.setBackgroundResource(R.color.colorPrimaryDark);

        View view4 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view4.setBackgroundResource(R.color.colorPrimary);

        View view5 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view5.setBackgroundResource(R.color.colorAccent);

        View view6 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view6.setBackgroundResource(R.color.colorPrimaryDark);


        View view7 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide, null);
        view7.setBackgroundResource(R.color.colorPrimary);


        View view8 = LayoutInflater.from(this).inflate(R.layout.act_content_ll_guide_btn, null);
        Button guide_btn_login = (Button) view8.findViewById(R.id.guide_btn_login);
        guide_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGuidePresenter.onLoginClick();
            }
        });

        List<View> views = new ArrayList<>();

        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);
        views.add(view7);

        views.add(view8);


        return views;
    }

    @Override
    public void startActivity() {
        UIHelper.startActivity(this, LogInActivity.class, null);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
