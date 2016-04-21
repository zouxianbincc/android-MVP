package com.example.cc.PresenterLayer.Love;

import java.util.List;

/**
 * Created by cc on 16/4/14.
 */
public interface ILoveView {

    void promptToastMessge(String msg);

    void showProgressBar(String msg);

    void setProgressBarMessage(String msg);

    void hideProgressBar();

    void setLoveData(List<String> loveData);

    void addLoveData(List<String> loveData);
}
