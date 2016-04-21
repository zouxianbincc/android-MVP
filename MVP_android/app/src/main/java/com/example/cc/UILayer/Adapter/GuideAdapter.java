package com.example.cc.UILayer.Adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cc on 16/4/13.
 */
public class GuideAdapter extends PagerAdapter {


    private List<View> mGuideList;

    @Override
    public int getCount() {

        return mGuideList == null ? 0 : mGuideList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public GuideAdapter(List<View> mGuideList) {
        this.mGuideList = mGuideList;
        Log.e("FF",mGuideList.size()+"");
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(mGuideList.get(position));

        Log.e("WW",mGuideList.get(position).getId()+"");

        return mGuideList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}
