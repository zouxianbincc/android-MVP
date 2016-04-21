package com.example.cc.UILayer.Activity.Start;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cc.BaseActivity;
import com.example.cc.PresenterLayer.Start.IStartView;
import com.example.cc.PresenterLayer.Start.StartPresenter;
import com.example.cc.R;
import com.example.cc.UIHelper;
import com.example.cc.UILayer.Activity.Guide.GuideActivity;


public class StartActivity extends BaseActivity implements IStartView {

    private StartPresenter mStartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mStartPresenter = new StartPresenter(this);
        mStartPresenter.onCreate(this);

    }

    @Override
    public void startMain() {
        UIHelper.startMain(this);
        finish();

    }

    @Override
    public void startGuide() {

        UIHelper.startActivity(this, GuideActivity.class, null);
        finish();

    }
}
