package com.deepai.paipai.wechattakephoto.manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.deepai.paipai.R;
import com.deepai.paipai.wechattakephoto.WCTakePhotoActivity;
import com.deepai.paipai.wechattakephoto.WCTakePhotoActivity.DirType;
import com.deepai.paipai.wechattakephoto.manager.MyImageLoader.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class ImageAdapter extends BaseAdapter {
    private static ArrayList<String> mSelectImg = new ArrayList<>();
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public Activity mContext;
    private List<String> mData;
    private String mDirPath;
    /* access modifiers changed from: private */
    public OnImg2CropClickListener mImg2CropClickListener;
    /* access modifiers changed from: private */
    public OnImgClickListener mImgClickListener;
    private OnSelectedChangeListener mListener;
    private int mMaxSelectCount;
    /* access modifiers changed from: private */
    public int mSelectType;
    /* access modifiers changed from: private */
    public Uri mTempFileUri;
    /* access modifiers changed from: private */
    public DirType mType;

    public interface OnImg2CropClickListener {
        void onImg2CropClick(String str);
    }

    public interface OnImgClickListener {
        void onImgClick(String str);
    }

    public interface OnSelectedChangeListener {
        void onSelectedChange(List<String> list);
    }

    private class ViewHolder {
        ImageView imgView;
        ImageView selectBtn;

        private ViewHolder() {
        }
    }

    public ImageAdapter(Activity context, List<String> data, String dirPath, DirType type, int maxSelectCount, int selectType, Uri tempFileUri) {
        this.mContext = context;
        this.mType = type;
        this.mData = data;
        this.mDirPath = dirPath;
        this.inflater = LayoutInflater.from(context);
        this.mMaxSelectCount = maxSelectCount;
        this.mSelectType = selectType;
        this.mTempFileUri = tempFileUri;
    }

    public void setOnSelectedChangeListener(OnSelectedChangeListener listener) {
        this.mListener = listener;
    }

    public void setOnImg2CropClickListener(OnImg2CropClickListener listener) {
        this.mImg2CropClickListener = listener;
    }

    public void setOnImgClickListener(OnImgClickListener listener) {
        this.mImgClickListener = listener;
    }

    public void changeData(List<String> data, String dirPath, DirType type, int maxSelectCount, int selectType, Uri tempFileUri) {
        this.mType = type;
        this.mData = data;
        this.mDirPath = dirPath;
        this.mMaxSelectCount = maxSelectCount;
        this.mSelectType = selectType;
        this.mTempFileUri = tempFileUri;
        notifyDataSetChanged();
    }

    public void clearSelectImg() {
        if (mSelectImg != null && mSelectImg.size() > 0) {
            mSelectImg.clear();
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.mData.size();
    }

    public Object getItem(int position) {
        return this.mData.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final String imagePath;
        final ViewHolder holder;
        if (WCTakePhotoActivity.ALL_IMG_DIR.equals(this.mDirPath)) {
            imagePath = (String) this.mData.get(position);
        } else {
            imagePath = this.mDirPath + CookieSpec.PATH_DELIM + ((String) this.mData.get(position));
        }
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.item_grid_view, parent, false);
            holder = new ViewHolder();
            holder.imgView = (ImageView) convertView.findViewById(R.id.iv_item_image);
            holder.selectBtn = (ImageView) convertView.findViewById(R.id.btn_item_select);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imgView.setScaleType(ScaleType.CENTER_INSIDE);
        holder.imgView.setImageResource(R.drawable.image_fail);
        if (mSelectImg.contains(imagePath)) {
            holder.imgView.setColorFilter(Color.parseColor("#77000000"));
            holder.selectBtn.setImageResource(R.drawable.selected);
        } else {
            holder.imgView.setColorFilter(null);
            holder.selectBtn.setImageResource(R.drawable.not_selected);
        }
        if (DirType.ALL == this.mType && position == 0) {
            holder.imgView.setScaleType(ScaleType.CENTER_INSIDE);
            holder.imgView.setImageResource(R.drawable.take_photo);
            holder.selectBtn.setVisibility(8);
            holder.imgView.setTag(Integer.valueOf(R.drawable.take_photo));
        } else {
            holder.imgView.setScaleType(ScaleType.CENTER_CROP);
            if (this.mSelectType == -3) {
                holder.selectBtn.setVisibility(0);
            } else {
                holder.selectBtn.setVisibility(8);
            }
            MyImageLoader.getInstance(3, Type.LIFO).loadImage(imagePath, holder.imgView, false);
        }
        holder.selectBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ImageAdapter.this.changeSelectStatus(imagePath, holder);
            }
        });
        holder.imgView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (-2 == ImageAdapter.this.mSelectType) {
                    if (DirType.ALL == ImageAdapter.this.mType && position == 0) {
                        Intent iTakePhotoCrop = new Intent("android.media.action.IMAGE_CAPTURE");
                        iTakePhotoCrop.putExtra("output", ImageAdapter.this.mTempFileUri);
                        ImageAdapter.this.mContext.startActivityForResult(iTakePhotoCrop, WCTakePhotoActivity.REQ_CODE_TAKE_CAMERA_CROP);
                    } else if (ImageAdapter.this.mImg2CropClickListener != null) {
                        ImageAdapter.this.mImg2CropClickListener.onImg2CropClick(imagePath);
                    }
                } else if (-3 != ImageAdapter.this.mSelectType) {
                } else {
                    if (DirType.ALL == ImageAdapter.this.mType && position == 0) {
                        Intent iTakePhoto = new Intent("android.media.action.IMAGE_CAPTURE");
                        iTakePhoto.putExtra("output", ImageAdapter.this.mTempFileUri);
                        ImageAdapter.this.mContext.startActivityForResult(iTakePhoto, WCTakePhotoActivity.REQ_CODE_TAKE_CAMERA);
                    } else if (ImageAdapter.this.mImgClickListener != null) {
                        ImageAdapter.this.mImgClickListener.onImgClick(imagePath);
                    }
                }
            }
        });
        return convertView;
    }

    /* access modifiers changed from: private */
    public void changeSelectStatus(String imagePath, ViewHolder holder) {
        if (mSelectImg.contains(imagePath)) {
            mSelectImg.remove(imagePath);
            holder.imgView.setColorFilter(null);
            holder.selectBtn.setImageResource(R.drawable.not_selected);
        } else if (mSelectImg.size() < this.mMaxSelectCount) {
            mSelectImg.add(imagePath);
            holder.imgView.setColorFilter(Color.parseColor("#77000000"));
            holder.selectBtn.setImageResource(R.drawable.selected);
        }
        if (this.mListener != null) {
            this.mListener.onSelectedChange(mSelectImg);
        }
    }
}
