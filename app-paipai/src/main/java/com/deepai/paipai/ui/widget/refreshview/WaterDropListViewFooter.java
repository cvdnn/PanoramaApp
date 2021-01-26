package com.deepai.paipai.ui.widget.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.deepai.paipai.R;

public class WaterDropListViewFooter extends LinearLayout {
    private LinearLayout layout_progress;
    private View mContentView;
    private Context mContext;
    private TextView mHintView;
    private View mProgressBar;
    private TextView txt_progresstext;

    public enum STATE {
        normal,
        ready,
        loading
    }

    public WaterDropListViewFooter(Context context) {
        super(context);
        initView(context);
    }

    public WaterDropListViewFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void setState(STATE state) {
        this.mHintView.setVisibility(4);
        this.mProgressBar.setVisibility(4);
        this.mHintView.setVisibility(4);
        this.txt_progresstext.setVisibility(4);
        this.layout_progress.setVisibility(4);
        if (state == STATE.ready) {
            this.mHintView.setVisibility(0);
            this.mHintView.setText(getResources().getString(R.string.listfooterview_ready));
        } else if (state == STATE.loading) {
            this.mProgressBar.setVisibility(0);
            this.layout_progress.setVisibility(0);
            this.txt_progresstext.setVisibility(0);
        } else {
            this.mHintView.setVisibility(0);
            this.mHintView.setText(getResources().getString(R.string.listfooterview_normal));
        }
    }

    public void setBottomMargin(int height) {
        if (height >= 0) {
            LayoutParams lp = (LayoutParams) this.mContentView.getLayoutParams();
            lp.bottomMargin = height;
            this.mContentView.setLayoutParams(lp);
        }
    }

    public int getBottomMargin() {
        return ((LayoutParams) this.mContentView.getLayoutParams()).bottomMargin;
    }

    public void normal() {
        this.mHintView.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.layout_progress.setVisibility(8);
        this.txt_progresstext.setVisibility(8);
    }

    public void loading() {
        this.mHintView.setVisibility(8);
        this.mProgressBar.setVisibility(0);
        this.layout_progress.setVisibility(0);
        this.txt_progresstext.setVisibility(0);
    }

    public void hide() {
        LayoutParams lp = (LayoutParams) this.mContentView.getLayoutParams();
        lp.height = 0;
        this.mContentView.setLayoutParams(lp);
    }

    public void show() {
        LayoutParams lp = (LayoutParams) this.mContentView.getLayoutParams();
        lp.height = -2;
        this.mContentView.setLayoutParams(lp);
    }

    private void initView(Context context) {
        this.mContext = context;
        LinearLayout moreView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.waterdroplistview_footer, null);
        addView(moreView);
        moreView.setLayoutParams(new LayoutParams(-1, -2));
        this.mContentView = moreView.findViewById(R.id.waterdroplistview_footer_content);
        this.mProgressBar = moreView.findViewById(R.id.waterdroplistview_footer_progressbar);
        this.mHintView = (TextView) moreView.findViewById(R.id.waterdroplistview_footer_hint_textview);
        this.layout_progress = (LinearLayout) moreView.findViewById(R.id.progresslayout);
        this.txt_progresstext = (TextView) moreView.findViewById(R.id.txt_progresstext);
    }
}
