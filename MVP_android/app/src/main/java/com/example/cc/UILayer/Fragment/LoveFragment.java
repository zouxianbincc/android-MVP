package com.example.cc.UILayer.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cc.BaseFragment;
import com.example.cc.PresenterLayer.Love.ILoveView;
import com.example.cc.PresenterLayer.Love.LovePresenter;
import com.example.cc.R;
import com.example.cc.UILayer.Adapter.LoveAdapter;
import com.example.cc.Utlis.Dialog.LittleDialog;

import java.util.List;

/**
 * Created by cc on 16/4/14.
 */
public class LoveFragment extends BaseFragment implements LoveAdapter.OnLoveItmeListener,ILoveView{

    private View mCreateView;

    private RecyclerView love_rv_content;

    private LoveAdapter mLoveAdapter;

    private LittleDialog mDialog;

    private LovePresenter mLovePresenter;


    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);

        String aa=args.getString("aa");
        Log.e("LOve",aa);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCreateView=LayoutInflater.from(getActivity()).inflate(R.layout.act_love,container,false);
        Log.e("LOve","------------");

        return mCreateView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("LOve","------2------");
        mLovePresenter=new LovePresenter(this);
        initView();
        mLovePresenter.getRefreshLoveData();


    }



    private void initView(){



        love_rv_content= (RecyclerView) mCreateView.findViewById(R.id.love_rv_content);

        love_rv_content.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        mLoveAdapter=new LoveAdapter(this);

        love_rv_content.setAdapter(mLoveAdapter);


    }

    @Override
    public void onLoveItmeListener(int position, Object object) {



    }

    @Override
    public void promptToastMessge(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar(String msg) {
        mDialog = new LittleDialog(getActivity(), msg);
        mDialog.show();
    }

    @Override
    public void setProgressBarMessage(String msg) {

    }

    @Override
    public void hideProgressBar() {
        mDialog.dismiss();
    }

    @Override
    public void setLoveData(List<String> loveData) {
        mLoveAdapter.setLoveData(loveData);

    }

    @Override
    public void addLoveData(List<String> loveData) {
        mLoveAdapter.addLoveData(loveData);

    }
}
