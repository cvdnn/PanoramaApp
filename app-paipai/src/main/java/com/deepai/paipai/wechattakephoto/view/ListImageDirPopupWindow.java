package com.deepai.paipai.wechattakephoto.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.deepai.paipai.R;
import com.deepai.paipai.wechattakephoto.entity.FolderBean;
import com.deepai.paipai.wechattakephoto.manager.MyImageLoader;
import java.util.List;

public class ListImageDirPopupWindow extends PopupWindow {
    private Context mContext;
    private View mConvertView;
    /* access modifiers changed from: private */
    public List<FolderBean> mData;
    private int mHeight;
    private ListView mListView;
    /* access modifiers changed from: private */
    public OnDirSelectedListener mListener;
    /* access modifiers changed from: private */
    public int mSelectPosition = 0;
    private int mWidth;

    private class ListDirAdapter extends ArrayAdapter<FolderBean> {
        private LayoutInflater mInflater;

        private class ViewHolder {
            ImageView mChoose;
            TextView mDirCount;
            TextView mDirName;
            ImageView mImg;

            private ViewHolder() {
            }
        }

        public ListDirAdapter(Context context, List<FolderBean> objects) {
            super(context, 0, objects);
            this.mInflater = LayoutInflater.from(context);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = this.mInflater.inflate(R.layout.item_popup_take_photo, parent, false);
                holder.mImg = (ImageView) convertView.findViewById(R.id.iv_item_folder_image);
                holder.mDirName = (TextView) convertView.findViewById(R.id.tv_item_folder_name);
                holder.mDirCount = (TextView) convertView.findViewById(R.id.tv_item_folder_image_count);
                holder.mChoose = (ImageView) convertView.findViewById(R.id.iv_item_folder_choose);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            FolderBean bean = (FolderBean) getItem(position);
            holder.mImg.setImageResource(R.drawable.image_fail);
            if (ListImageDirPopupWindow.this.mSelectPosition == position) {
                holder.mChoose.setVisibility(0);
            } else {
                holder.mChoose.setVisibility(8);
            }
            MyImageLoader.getInstance().loadImage(bean.getFirstImgPath(), holder.mImg, false);
            if (-1 == bean.getImgCount()) {
                holder.mDirName.setText("所有图片");
                holder.mDirCount.setVisibility(8);
            } else {
                holder.mDirName.setText(bean.getName());
                holder.mDirCount.setVisibility(0);
                holder.mDirCount.setText(bean.getImgCount() + "张");
            }
            return convertView;
        }
    }

    public interface OnDirSelectedListener {
        void onSelect(FolderBean folderBean);
    }

    public ListImageDirPopupWindow(Context context, List<FolderBean> data) {
        this.mContext = context;
        this.mData = data;
        calWidthAndHeight(context);
        this.mConvertView = LayoutInflater.from(context).inflate(R.layout.popup_take_photo, null);
        setContentView(this.mConvertView);
        setWidth(this.mWidth);
        setHeight(this.mHeight);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 4) {
                    return false;
                }
                ListImageDirPopupWindow.this.dismiss();
                return true;
            }
        });
        initView();
        initEvent();
    }

    public void setOnDirSelectedListener(OnDirSelectedListener mListener2) {
        this.mListener = mListener2;
    }

    private void calWidthAndHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService("window");
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        this.mWidth = outMetrics.widthPixels;
        this.mHeight = (int) (((double) outMetrics.heightPixels) * 0.7d);
    }

    private void initView() {
        this.mListView = (ListView) this.mConvertView.findViewById(R.id.lv_folder_list);
        this.mListView.setAdapter(new ListDirAdapter(this.mContext, this.mData));
    }

    private void initEvent() {
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (ListImageDirPopupWindow.this.mListener != null) {
                    ListImageDirPopupWindow.this.mListener.onSelect((FolderBean) ListImageDirPopupWindow.this.mData.get(position));
                    ListImageDirPopupWindow.this.mSelectPosition = position;
                    ListImageDirPopupWindow.this.dismiss();
                }
            }
        });
    }
}
