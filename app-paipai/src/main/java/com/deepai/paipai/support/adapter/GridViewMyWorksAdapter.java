package com.deepai.paipai.support.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.baidu.location.c.d;
import com.deepai.library.support.adapter.DBaseAdapter;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.support.file.DeleteFileUtils;
import com.deepai.paipai.support.imageloader.UniversalImageLoadTool;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.widget.CustomDialog;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.json.JSONException;
import org.json.JSONObject;

public class GridViewMyWorksAdapter extends DBaseAdapter<String[]> {
    /* access modifiers changed from: private */
    public OnClickListener mClickListener;
    private DisplayImageOptions options = new Builder().showImageOnLoading((int) R.mipmap.image_fail).showImageForEmptyUri((int) R.mipmap.image_fail).showImageOnFail((int) R.mipmap.image_fail).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).build();

    public interface OnClickListener {
        void onClick(int i);
    }

    private static class ViewHolder {
        ImageView imageView;

        private ViewHolder() {
        }
    }

    public GridViewMyWorksAdapter(List<String[]> list, String type, Context context) {
        super(list, type, context);
    }

    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.item_gridview_my_works, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_item_myworks);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String myUrl = ((String[]) this.list.get(position))[0];
        final String myId = ((String[]) this.list.get(position))[1];
        if ("0".equals(this.type)) {
            ImageLoader.getInstance().displayImage("file://" + myUrl, (ImageAware) new ImageViewAware(viewHolder.imageView), this.options);
        } else if (d.ai.equals(this.type)) {
            UniversalImageLoadTool.disPlay(myUrl, viewHolder.imageView, (int) R.mipmap.image_fail, this.context);
        }
        viewHolder.imageView.setTag(Integer.valueOf(position));
        viewHolder.imageView.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                Integer position = (Integer) v.getTag();
                String fileName = myUrl;
                String mineId = myId;
                if (TextUtils.isEmpty(fileName)) {
                    ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "暂未找到该作品").show();
                } else if ("0".equals(GridViewMyWorksAdapter.this.type)) {
                    GridViewMyWorksAdapter.this.clearDialog(position.intValue(), "0", fileName.substring(fileName.lastIndexOf(CookieSpec.PATH_DELIM) + 1, fileName.length()));
                } else if (d.ai.equals(GridViewMyWorksAdapter.this.type) && !TextUtils.isEmpty(mineId)) {
                    GridViewMyWorksAdapter.this.clearDialog(position.intValue(), d.ai, mineId);
                }
                return true;
            }
        });
        viewHolder.imageView.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                if (GridViewMyWorksAdapter.this.mClickListener != null) {
                    GridViewMyWorksAdapter.this.mClickListener.onClick(((Integer) v.getTag()).intValue());
                }
            }
        });
        return convertView;
    }

    /* access modifiers changed from: private */
    public void clearDialog(final int postition, final String type, final String fileName) {
        CustomDialog.Builder builder = new CustomDialog.Builder(this.context);
        if ("0".equals(type)) {
            builder.setTitle("删除").setMessage("您确定要删除此本地作品吗？删除后该作品将不可查看。");
        } else if (d.ai.equals(type)) {
            builder.setTitle("删除").setMessage("您确定要删除此上传作品吗？删除后该作品将不可查看。");
        }
        builder.setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) new android.content.DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if ("0".equals(type)) {
                    if (DeleteFileUtils.deleteFiles(fileName)) {
                        GridViewMyWorksAdapter.this.list.remove(postition);
                        ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除成功").show();
                        GridViewMyWorksAdapter.this.notifyDataSetChanged();
                    } else {
                        ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除失败").show();
                    }
                } else if (d.ai.equals(type)) {
                    GridViewMyWorksAdapter.this.deleteUpLoadImage(fileName, postition);
                }
                dialog.dismiss();
            }
        }).setNegativeButton("取消", (android.content.DialogInterface.OnClickListener) new android.content.DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        CustomDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                dialog.dismiss();
                return true;
            }
        });
        dialog.show();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    /* access modifiers changed from: private */
    public void deleteUpLoadImage(String myId, final int position) {
        String token = AppSP.getToken(this.context, "").toString();
        if (!TextUtils.isEmpty(token)) {
            Map<String, String> params = new HashMap<>();
            params.put(RequestKey.TOKEN, token);
            params.put("pictureId", myId);
            PaiApp.vQueue.add(new StringPostRequest(AppConstant.DELETE_UPLOADIMAGE, params, new Listener<String>() {
                public void onResponse(String response) {
                    if (!TextUtils.isEmpty(response)) {
                        try {
                            String code = new JSONObject(response).getString(AppConstant.CODE);
                            if (TextUtils.isEmpty(code)) {
                                ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除失败").show();
                            } else if (AppConstant.SUCCESS.equals(code)) {
                                GridViewMyWorksAdapter.this.list.remove(position);
                                ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除成功").show();
                                GridViewMyWorksAdapter.this.notifyDataSetChanged();
                            } else {
                                ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除失败").show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除失败").show();
                        }
                    } else {
                        ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "删除失败").show();
                    }
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    if (error.getClass() == MsgError.class) {
                        ToastFactory.getToast(GridViewMyWorksAdapter.this.context, error.getMessage()).show();
                    } else {
                        ToastFactory.getToast(GridViewMyWorksAdapter.this.context, "服务器正忙，请稍后再试").show();
                    }
                }
            }));
            return;
        }
        ToastFactory.getToast(this.context, "请登录后，再进行删除操作").show();
    }
}
