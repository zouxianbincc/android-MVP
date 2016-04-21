package com.example.cc.Utlis.Dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cc.Utlis.BackGroudSeletor;
import com.example.cc.Utlis.DensityUtil;


/**
 * Created by cc on 2015/11/20.
 */
public class LittleDialog extends ProgressDialog {
    private ProgressBar mProgressBar;
    private TextView tv;
    private String mMessage;
    private View.OnClickListener mClickListener;
    private Context context;


    public LittleDialog(Context context, String message) {
        super(context);
        init(context, message, null);
    }

    public LittleDialog(Context context, String message, View.OnClickListener clickListener) {
        super(context);
        init(context, message, clickListener);
    }

    private void init(Context context, String message, View.OnClickListener clickListener) {
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        mMessage = message;
        mClickListener = clickListener;
        this.context = context;

    }

    @Override
    public void setMessage(CharSequence message) {
        if (message == null) {
            mMessage = "";
        } else {
            mMessage = message.toString();
        }
        if (tv != null) {
            tv.setText(mMessage);
        }
    }

    @Override
    public void show() {
        super.show();
        LinearLayout contentView = new  LinearLayout(context);
        ViewGroup.LayoutParams rlp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(
                context, 84));

        contentView.setVerticalGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams pblp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mProgressBar = new ProgressBar(context);


        pblp.addRule(RelativeLayout.CENTER_VERTICAL);
        pblp.setMargins(DensityUtil.dip2px(context, 50), 0,
                DensityUtil.dip2px(context, 12), 0);

        mProgressBar.setLayoutParams(pblp);
        contentView.addView(mProgressBar, pblp);

        ImageView iv = new ImageView(context);

        RelativeLayout.LayoutParams ivlp = new RelativeLayout.LayoutParams(
                DensityUtil.dip2px(context, 27), DensityUtil.dip2px(
                context, 27));
        iv.setImageDrawable(BackGroudSeletor.getdrawble("gy_image_close",
                context));
        ivlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        ivlp.addRule(RelativeLayout.CENTER_VERTICAL);
        ivlp.setMargins(DensityUtil.dip2px(context, 50), 0,
                DensityUtil.dip2px(context, 24), 0);
        iv.setLayoutParams(ivlp);

        contentView.addView(iv, ivlp);
        if (mClickListener != null) {
            iv.setOnClickListener(mClickListener);
        }
        tv = new TextView(context);
        RelativeLayout.LayoutParams tvlp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        tvlp.addRule(RelativeLayout.CENTER_VERTICAL);
        tvlp.addRule(RelativeLayout.RIGHT_OF, mProgressBar.getId());
        tvlp.addRule(RelativeLayout.LEFT_OF, iv.getId());
        tv.setText(mMessage);
        tv.setTextSize(18);
        tv.setTextColor(Color.BLACK);
        contentView.addView(tv, tvlp);

        setContentView(contentView, rlp);
        contentView.setBackgroundColor(Color.WHITE);

    }
}
