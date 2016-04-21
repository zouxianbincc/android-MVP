package com.example.cc.PresenterLayer.Guide;

import com.example.cc.ModelLayer.LocalVersion;
import com.example.cc.ModelLayer.SystemVersionInfo;

/**
 * Created by cc on 16/4/13.
 */
public class GuidePresenter {

    private IGuideView mIGuideView;

    public GuidePresenter(IGuideView iGuideView) {
        mIGuideView = iGuideView;

    }

    public void onCreate() {

        mIGuideView.setGuideData(mIGuideView.getGuideViews());

    }

    public void onLoginClick(){

        LocalVersion localVersion=new LocalVersion();
        localVersion.saveLocalVersion(mIGuideView.getContext(), SystemVersionInfo.getVersionCode(mIGuideView.getContext()));

        mIGuideView.startActivity();

    }
}
