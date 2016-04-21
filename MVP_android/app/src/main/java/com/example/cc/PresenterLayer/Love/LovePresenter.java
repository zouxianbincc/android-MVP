package com.example.cc.PresenterLayer.Love;

import com.example.cc.ModelLayer.LoveService.ILoveModel;
import com.example.cc.ModelLayer.LoveService.LoveService;

import java.util.List;

/**
 * Created by cc on 16/4/14.
 */
public class LovePresenter {

    private ILoveView mILoveView;


    public LovePresenter(ILoveView iLoveView) {

        mILoveView = iLoveView;
    }


    public void getMoreLoveData() {

        mILoveView.showProgressBar("正在加载");


        final LoveService loveService = new LoveService();

        loveService.getMoreLoveData(new ILoveModel() {
            @Override
            public void onSuccess(Object object) {
                mILoveView.setLoveData((List<String>) object);
                mILoveView.hideProgressBar();
            }

            @Override
            public void onFail(Object object) {
                mILoveView.promptToastMessge(object.toString());
                mILoveView.hideProgressBar();
            }
        });


    }

    public void getRefreshLoveData() {



        mILoveView.showProgressBar("正在加载");

        final LoveService loveService = new LoveService();

        loveService.getMoreLoveData(new ILoveModel() {
            @Override
            public void onSuccess(Object object) {
                mILoveView.addLoveData((List<String>) object);
                mILoveView.hideProgressBar();
            }

            @Override
            public void onFail(Object object) {
                mILoveView.promptToastMessge(object.toString());
                mILoveView.hideProgressBar();
            }
        });
    }
}
