package com.youth.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import e.n.a.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class BannerAdapter<T, VH extends d0> extends g<VH> implements IViewHolder<T, VH> {
    public int increaseCount = 2;
    public List<T> mDatas = new ArrayList();
    public OnBannerListener mOnBannerListener;
    public VH mViewHolder;

    public BannerAdapter(List<T> list) {
        setDatas(list);
    }

    public /* synthetic */ void a(int i2, View view) {
        this.mOnBannerListener.OnBannerClick(this.mDatas.get(i2), i2);
    }

    public T getData(int i2) {
        return this.mDatas.get(i2);
    }

    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.increaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getRealPosition(int i2) {
        return BannerUtils.getRealPosition(this.increaseCount == 2, i2, getRealCount());
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    public final void onBindViewHolder(VH vh, int i2) {
        this.mViewHolder = vh;
        int realPosition = getRealPosition(i2);
        onBindView(vh, this.mDatas.get(realPosition), realPosition, getRealCount());
        if (this.mOnBannerListener != null) {
            vh.itemView.setOnClickListener(new a(this, realPosition));
        }
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return (d0) onCreateHolder(viewGroup, i2);
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas = list;
    }

    public void setIncreaseCount(int i2) {
        this.increaseCount = i2;
    }

    public void setOnBannerListener(OnBannerListener onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }
}
