package com.deepai.paipai.extens.swipemenu.swipemenulistview;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class SwipeMenuView extends LinearLayout implements OnClickListener {
    private SwipeMenuLayout mLayout;
    private PullToRefreshSwipeMenuListView mListView;
    private SwipeMenu mMenu;
    private OnSwipeItemClickListener onItemClickListener;
    private int position;

    public interface OnSwipeItemClickListener {
        void onItemClick(SwipeMenuView swipeMenuView, SwipeMenu swipeMenu, int i);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position2) {
        this.position = position2;
    }

    public SwipeMenuView(SwipeMenu menu, PullToRefreshSwipeMenuListView listView) {
        super(menu.getContext());
        this.mListView = listView;
        this.mMenu = menu;
        int id = 0;
        for (SwipeMenuItem item : menu.getMenuItems()) {
            int id2 = id + 1;
            addItem(item, id);
            id = id2;
        }
    }

    private void addItem(SwipeMenuItem item, int id) {
        LayoutParams params = new LayoutParams(item.getWidth(), -1);
        LinearLayout parent = new LinearLayout(getContext());
        parent.setId(id);
        parent.setGravity(17);
        parent.setOrientation(1);
        parent.setLayoutParams(params);
        parent.setBackgroundDrawable(item.getBackground());
        parent.setOnClickListener(this);
        addView(parent);
        if (item.getIcon() != null) {
            parent.addView(createIcon(item));
        }
        if (!TextUtils.isEmpty(item.getTitle())) {
            parent.addView(createTitle(item));
        }
    }

    private ImageView createIcon(SwipeMenuItem item) {
        ImageView iv = new ImageView(getContext());
        iv.setImageDrawable(item.getIcon());
        return iv;
    }

    private TextView createTitle(SwipeMenuItem item) {
        TextView tv = new TextView(getContext());
        tv.setText(item.getTitle());
        tv.setGravity(17);
        tv.setTextSize((float) item.getTitleSize());
        tv.setTextColor(item.getTitleColor());
        return tv;
    }

    public void onClick(View v) {
        if (this.onItemClickListener != null && this.mLayout.isOpen()) {
            this.onItemClickListener.onItemClick(this, this.mMenu, v.getId());
        }
    }

    public OnSwipeItemClickListener getOnSwipeItemClickListener() {
        return this.onItemClickListener;
    }

    public void setOnSwipeItemClickListener(OnSwipeItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void setLayout(SwipeMenuLayout mLayout2) {
        this.mLayout = mLayout2;
    }
}
