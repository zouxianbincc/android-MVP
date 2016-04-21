package com.example.cc.UILayer.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 16/4/14.
 */
public class LoveAdapter extends RecyclerView.Adapter<LoveAdapter.ViewHoder> {

    private List<String> mLoveData;

    private OnLoveItmeListener mOnLoveItmeListener;

    public LoveAdapter(OnLoveItmeListener onLoveItmeListener) {

        mOnLoveItmeListener = onLoveItmeListener;
    }

    public void setLoveData(List<String> loveData) {
        mLoveData = loveData;
        notifyDataSetChanged();
    }

    public void addLoveData(List<String> loveData) {
        if (null == mLoveData) {

            mLoveData = new ArrayList<>();
        }
        mLoveData.addAll(loveData);
        notifyDataSetChanged();


    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_love, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {

        holder.itme_love_tv_content.setText(mLoveData.get(position));

    }

    @Override
    public int getItemCount() {
        return mLoveData == null ? 0 : mLoveData.size();
    }


    public class ViewHoder extends RecyclerView.ViewHolder {

        public TextView itme_love_tv_content;


        public ViewHoder(View itemView) {
            super(itemView);

            itme_love_tv_content = (TextView) itemView.findViewById(R.id.itme_love_tv_content);
        }
    }


   public interface OnLoveItmeListener {
        void onLoveItmeListener(int position, Object object);
    }
}
