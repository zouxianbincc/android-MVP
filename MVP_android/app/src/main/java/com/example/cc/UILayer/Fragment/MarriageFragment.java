package com.example.cc.UILayer.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.cc.BaseFragment;

/**
 * Created by cc on 16/4/14.
 */
public class MarriageFragment extends BaseFragment {

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);

        String aa=args.getString("aa");
        Log.e("Marriage",aa);
    }

}
