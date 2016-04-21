package com.example.cc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by cc on 16/4/13.
 */
public class BaseActivity extends AppCompatActivity {


    public Context getContext() {
        return super.getApplicationContext();
    }

    public Activity getActivity() {
        return this;
    }

    public <T extends android.support.v4.app.Fragment> T findSupportFragment(Class<T> fragmentClass) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = fragmentManager.findFragmentByTag(fragmentClass.getName());
        return (T) fragment;
    }

    public <T extends android.support.v4.app.Fragment> T newSupportFragment(Class<T> fragmentClass, Bundle args) {
        android.support.v4.app.Fragment fragment = android.support.v4.app.Fragment.instantiate(getContext(), fragmentClass.getName(), args);
        fragment.setArguments(args);
        return (T) fragment;
    }
}
