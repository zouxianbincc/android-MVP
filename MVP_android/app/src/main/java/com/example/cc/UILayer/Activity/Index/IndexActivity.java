package com.example.cc.UILayer.Activity.Index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cc.BaseActivity;
import com.example.cc.PresenterLayer.Index.IIndexView;
import com.example.cc.PresenterLayer.Index.IndexPresenter;
import com.example.cc.R;
import com.example.cc.UILayer.Fragment.LoveFragment;
import com.example.cc.UILayer.Fragment.MarriageFragment;
import com.example.cc.UILayer.Fragment.SettingFragment;
import com.example.cc.Utlis.StaticUtils;

/**
 * Created by cc on 16/4/13.
 */
public class IndexActivity extends BaseActivity implements IIndexView {


    private LinearLayout index_ll_content;

    private Button index_btn_love, index_btn_marriage, index_btn_setting;


    private LoveFragment mLoveFragment;

    private MarriageFragment mMarriageFragment;

    private SettingFragment mSettingFragment;


    private IndexPresenter mIndexPresenter;


    protected void startFragment(int intent,Object... object){

        mIndexPresenter.onCreate(intent);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_index);
        mIndexPresenter = new IndexPresenter(this);
        initView();
        startFragment(StaticUtils.INTNET_LOVE);



    }

    private void initView() {



        index_ll_content = (LinearLayout) findViewById(R.id.index_ll_content);

        index_btn_love = (Button) findViewById(R.id.index_btn_love);
        index_btn_marriage = (Button) findViewById(R.id.index_btn_marriage);
        index_btn_setting = (Button) findViewById(R.id.index_btn_setting);

        index_btn_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndexPresenter.LoveClick();
            }
        });
        index_btn_marriage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndexPresenter.MarriageClick();
            }
        });
        index_btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndexPresenter.SettingClick();
            }
        });

    }


    @Override
    public void onLoveStartActivity(Object object) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        hideFragment(transaction);
        Bundle bundle = new Bundle();

        bundle.putString("aa",object.toString());

        mLoveFragment = showFragment(LoveFragment.class, mLoveFragment, bundle, transaction);
        transaction.commit();
    }

    @Override
    public void onMarriageStartActivity(Object object) {

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);

        Bundle bundle = new Bundle();
        bundle.putString("aa",object.toString());


        mMarriageFragment = showFragment(MarriageFragment.class, mMarriageFragment, bundle, transaction);
        transaction.commit();
    }

    @Override
    public void onSettingStartActivity(Object object) {

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);

        Bundle bundle = new Bundle();
        bundle.putString("aa",object.toString());
        mSettingFragment = showFragment(SettingFragment.class, mSettingFragment, bundle, transaction);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        hideFragment(mLoveFragment, transaction);
        hideFragment(mMarriageFragment, transaction);
        hideFragment(mSettingFragment, transaction);

    }


    private <T extends Fragment> T showFragment(Class<T> fragmentClass, T fragment, Bundle bundle, FragmentTransaction transaction) {
        if (fragment == null) {
            fragment = findSupportFragment(fragmentClass);
        }
        if (fragment == null || fragment.isDetached()) {
            fragment = newSupportFragment(fragmentClass, bundle);
            transaction.add(R.id.index_ll_content, fragment, fragment.getClass().getName());
        }
        transaction.show(fragment);
        return fragment;
    }

    private void hideFragment(Fragment fragment, FragmentTransaction transaction) {
        if (fragment != null && !fragment.isDetached()) {
            transaction.hide(fragment);
        }
    }

    private void removeFragment(Fragment fragment, FragmentTransaction transaction) {
        if (fragment != null && !fragment.isDetached()) {
            transaction.remove(fragment);
        }
    }
}
