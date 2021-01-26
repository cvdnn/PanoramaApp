package com.deepai.paipai.extens.swipemenu.swipemenulistview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class SwipeMenu {
    private Context mContext;
    private List<SwipeMenuItem> mItems = new ArrayList();
    private int mViewType;

    public SwipeMenu(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void addMenuItem(SwipeMenuItem item) {
        this.mItems.add(item);
    }

    public void removeMenuItem(SwipeMenuItem item) {
        this.mItems.remove(item);
    }

    public List<SwipeMenuItem> getMenuItems() {
        return this.mItems;
    }

    public SwipeMenuItem getMenuItem(int index) {
        return (SwipeMenuItem) this.mItems.get(index);
    }

    public int getViewType() {
        return this.mViewType;
    }

    public void setViewType(int viewType) {
        this.mViewType = viewType;
    }
}
