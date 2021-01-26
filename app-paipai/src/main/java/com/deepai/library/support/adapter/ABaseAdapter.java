package com.deepai.library.support.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.deepai.library.support.inject.InjectUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ABaseAdapter<T extends Serializable> extends BaseAdapter {
    private BaseAdapterHelper<T> adapterHelper;
    private Context context;
    private ArrayList<T> datas;
    private int selectedPosition = -1;

    public static abstract class AbstractItemView<T extends Serializable> {
        /* access modifiers changed from: private */
        public int position;
        /* access modifiers changed from: private */
        public int size;

        public abstract void bindingData(View view, T t);

        public abstract int inflateViewId();

        public void bindingView(View convertView) {
            InjectUtility.initInjectedView(this, convertView);
        }

        public void updateConvertView(T t, View convertView, int selectedPosition) {
        }

        public int getPosition() {
            return this.position;
        }

        public void setPosition(int position2) {
            this.position = position2;
        }

        public int getSize() {
            return this.size;
        }

        public void recycleView(View view) {
        }
    }

    private static abstract class BaseAdapterHelper<T> implements Serializable {
        private static final long serialVersionUID = 8411760659150853673L;

        public abstract int getCount(List<T> list);

        public abstract T getItem(int i, List<T> list);

        private BaseAdapterHelper() {
        }

        /* access modifiers changed from: private */
        public boolean isReusing(View convertView) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public abstract AbstractItemView<T> newItemView();

    public ABaseAdapter(ArrayList<T> datas2, Activity context2) {
        if (datas2 == null) {
            datas2 = new ArrayList<>();
        }
        this.datas = datas2;
        this.context = context2;
    }

    public void setAdapterHelper(BaseAdapterHelper<T> adapterHepler) {
        this.adapterHelper = adapterHepler;
    }

    public BaseAdapterHelper<T> getAdapterHepler() {
        return this.adapterHelper;
    }

    public void setSelected(int position) {
        this.selectedPosition = position;
        notifyDataSetChanged();
    }

    public int getSelected() {
        return this.selectedPosition;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        AbstractItemView<T> itemViewProcessor;
        boolean isReusing = true;
        if (!(convertView == null || this.adapterHelper == null)) {
            isReusing = this.adapterHelper.isReusing(convertView);
        }
        if (convertView == null || !isReusing) {
            itemViewProcessor = newItemView();
            convertView = View.inflate(this.context, itemViewProcessor.inflateViewId(), null);
            convertView.setTag(itemViewProcessor);
            itemViewProcessor.bindingView(convertView);
        } else {
            itemViewProcessor = (AbstractItemView) convertView.getTag();
        }
        itemViewProcessor.position = position;
        itemViewProcessor.size = this.datas.size();
        if (this.adapterHelper != null) {
            itemViewProcessor.bindingData(convertView, (Serializable) this.adapterHelper.getItem(position, this.datas));
        } else {
            itemViewProcessor.bindingData(convertView, (Serializable) this.datas.get(position));
        }
        if (this.adapterHelper != null) {
            itemViewProcessor.updateConvertView((Serializable) this.adapterHelper.getItem(position, this.datas), convertView, this.selectedPosition);
        } else {
            itemViewProcessor.updateConvertView((Serializable) this.datas.get(position), convertView, this.selectedPosition);
        }
        convertView.setSelected(this.selectedPosition == position);
        return convertView;
    }

    public ArrayList<T> getDatas() {
        return this.datas;
    }

    public int getCount() {
        if (this.adapterHelper != null) {
            return this.adapterHelper.getCount(this.datas);
        }
        return this.datas.size();
    }

    public Object getItem(int position) {
        return this.datas.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public void setDatas(ArrayList<T> datas2) {
        this.datas = datas2;
    }

    public void setDatasAndRefresh(ArrayList<T> datas2) {
        setDatas(datas2);
        notifyDataSetChanged();
    }

    public void addItem(T entry) {
        this.datas.add(entry);
    }

    public void addItemAndRefresh(T entry) {
        addItem(entry);
        notifyDataSetChanged();
    }

    public void addItems(List<T> entries) {
        for (T entry : entries) {
            this.datas.add(entry);
        }
    }

    public void addItemsAndRefresh(List<T> entries) {
        addItems(entries);
        notifyDataSetChanged();
    }

    public void addItem(T entry, int to) {
        this.datas.add(to, entry);
    }

    public void addItemsAndRefresh(T entry, int to) {
        this.datas.add(to, entry);
        notifyDataSetChanged();
    }

    public void addItemAtFront(T entry) {
        this.datas.add(0, entry);
    }

    public void addItemAtFrontAndRefresh(T entry) {
        addItemAtFront(entry);
        notifyDataSetChanged();
    }

    public void addItemsAtFront(List<T> entries) {
        for (int i = entries.size() - 1; i >= 0; i--) {
            this.datas.add(0, entries.get(i));
        }
    }

    public void addItemsAtFrontAndRefresh(List<T> entries) {
        addItemsAtFront(entries);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        this.datas.remove(index);
    }

    public void removeItemAndRefresh(int index) {
        removeItem(index);
        notifyDataSetChanged();
    }

    public void removeItemAndRefresh(T entry) {
        removeItem(entry);
        notifyDataSetChanged();
    }

    public void removeItem(T entry) {
        this.datas.remove(entry);
    }

    /* access modifiers changed from: protected */
    public void itemIsEmpty() {
    }
}
