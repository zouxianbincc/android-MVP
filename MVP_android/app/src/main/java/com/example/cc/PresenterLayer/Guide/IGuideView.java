package com.example.cc.PresenterLayer.Guide;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by cc on 16/4/13.
 */
public interface IGuideView {

    void setGuideData(List<View> views);

    List<View> getGuideViews();

    void startActivity();

    Context getContext();

}
