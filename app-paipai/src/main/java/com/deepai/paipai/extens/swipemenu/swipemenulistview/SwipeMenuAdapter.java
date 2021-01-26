package com.deepai.paipai.extens.swipemenu.swipemenulistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.PullToRefreshSwipeMenuListView.OnMenuItemClickListener;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.SwipeMenuView.OnSwipeItemClickListener;

public class SwipeMenuAdapter implements WrapperListAdapter, OnSwipeItemClickListener {
    private ListAdapter mAdapter;
    private Context mContext;
    private OnMenuItemClickListener onMenuItemClickListener;

    public SwipeMenuAdapter(Context context, ListAdapter adapter) {
        this.mAdapter = adapter;
        this.mContext = context;
    }

    public int getCount() {
        return this.mAdapter.getCount();
    }

    public Object getItem(int position) {
        return this.mAdapter.getItem(position);
    }

    public long getItemId(int position) {
        return this.mAdapter.getItemId(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            View contentView = this.mAdapter.getView(position, convertView, parent);
            SwipeMenu menu = new SwipeMenu(this.mContext);
            menu.setViewType(this.mAdapter.getItemViewType(position));
            createMenu(menu);
            SwipeMenuView menuView = new SwipeMenuView(menu, (PullToRefreshSwipeMenuListView) parent);
            menuView.setOnSwipeItemClickListener(this);
            PullToRefreshSwipeMenuListView listView = (PullToRefreshSwipeMenuListView) parent;
            SwipeMenuLayout layout = new SwipeMenuLayout(contentView, menuView, listView.getCloseInterpolator(), listView.getOpenInterpolator());
            layout.setPosition(position);
            return layout;
        }
        SwipeMenuLayout layout2 = (SwipeMenuLayout) convertView;
        layout2.closeMenu();
        layout2.setPosition(position);
        this.mAdapter.getView(position, layout2.getContentView(), parent);
        return layout2;
    }

    public void createMenu(SwipeMenu menu) {
        SwipeMenuItem item = new SwipeMenuItem(this.mContext);
        item.setTitle("Item 1");
        item.setBackground((Drawable) new ColorDrawable(-7829368));
        item.setWidth(300);
        menu.addMenuItem(item);
        SwipeMenuItem item2 = new SwipeMenuItem(this.mContext);
        item2.setTitle("Item 2");
        item2.setBackground((Drawable) new ColorDrawable(SupportMenu.CATEGORY_MASK));
        item2.setWidth(300);
        menu.addMenuItem(item2);
    }

    public void onItemClick(SwipeMenuView view, SwipeMenu menu, int index) {
        if (this.onMenuItemClickListener != null) {
            this.onMenuItemClickListener.onMenuItemClick(view.getPosition(), menu, index);
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener2) {
        this.onMenuItemClickListener = onMenuItemClickListener2;
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        this.mAdapter.registerDataSetObserver(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        this.mAdapter.unregisterDataSetObserver(observer);
    }

    public boolean areAllItemsEnabled() {
        return this.mAdapter.areAllItemsEnabled();
    }

    public boolean isEnabled(int position) {
        return this.mAdapter.isEnabled(position);
    }

    public boolean hasStableIds() {
        return this.mAdapter.hasStableIds();
    }

    public int getItemViewType(int position) {
        return this.mAdapter.getItemViewType(position);
    }

    public int getViewTypeCount() {
        return this.mAdapter.getViewTypeCount();
    }

    public boolean isEmpty() {
        return this.mAdapter.isEmpty();
    }

    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }
}
