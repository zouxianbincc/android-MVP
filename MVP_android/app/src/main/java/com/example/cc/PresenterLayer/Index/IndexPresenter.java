package com.example.cc.PresenterLayer.Index;

import com.example.cc.Utlis.StaticUtils;

/**
 * Created by cc on 16/4/14.
 */
public class IndexPresenter {


    private IIndexView mIIndexView;


    public IndexPresenter(IIndexView iIndexView) {

        mIIndexView = iIndexView;

    }


    public void onCreate(int intent) {

        if (intent == StaticUtils.INTNET_LOVE) {
            LoveClick();
            return;
        }

        if (intent == StaticUtils.INTNET_MARRIAGE) {
            MarriageClick();
            return;

        }

        if (intent == StaticUtils.INTNET_SETTING) {
            SettingClick();
            return;

        }
        LoveClick();

    }

    public void LoveClick() {


        mIIndexView.onLoveStartActivity("我个");
    }

    public void MarriageClick() {


        mIIndexView.onMarriageStartActivity(" 你的  ");

    }

    public void SettingClick() {


        mIIndexView.onSettingStartActivity(" 不是的 ");

    }

    public void Sec(){


        mIIndexView.onLoveStartActivity("我个");
    }

}
