package com.deepai.paipai.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.deepai.paipai.R;
import com.deepai.paipai.support.adapter.ListViewCommentShowAdapter;
import com.deepai.paipai.support.bean.CommentShowBean;
import java.util.ArrayList;
import java.util.List;

public class CustomCommentShowView extends LinearLayout {
    private ListViewCommentShowAdapter mAdapter;
    private CustomDisplayListView mContentListView;
    private List<CommentShowBean> mListData = new ArrayList();

    public CustomCommentShowView(Context context) {
        super(context);
        init();
    }

    public CustomCommentShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCommentShowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mContentListView = (CustomDisplayListView) inflate(getContext(), R.layout.layout_custom_comment_show, this).findViewById(R.id.list_custom_comment_show);
        this.mAdapter = new ListViewCommentShowAdapter(this.mListData, getContext());
        this.mContentListView.setAdapter(this.mAdapter);
    }

    public void setViewData(List<CommentShowBean> data) {
        if (this.mListData.size() > 0) {
            this.mListData.clear();
        }
        this.mListData.addAll(data);
        this.mAdapter.notifyDataSetChanged();
    }
}
