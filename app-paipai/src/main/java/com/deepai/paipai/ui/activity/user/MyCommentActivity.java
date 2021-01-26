package com.deepai.paipai.ui.activity.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.library.support.utils.FormatUtil;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.extens.swipemenu.pulltorefresh.RefreshTime;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.PullToRefreshSwipeMenuListView;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.PullToRefreshSwipeMenuListView.IXListViewListener;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.PullToRefreshSwipeMenuListView.OnMenuItemClickListener;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.PullToRefreshSwipeMenuListView.OnSwipeListener;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.SwipeMenu;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.SwipeMenuCreator;
import com.deepai.paipai.extens.swipemenu.swipemenulistview.SwipeMenuItem;
import com.deepai.paipai.support.bean.IndexPhotoBean;
import com.deepai.paipai.support.bean.MyCommentBean;
import com.deepai.paipai.support.imageloader.UniversalImageLoadTool;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.activity.details.ImageDetailsActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

public class MyCommentActivity extends BaseActivity implements IXListViewListener, OnItemClickListener {
    /* access modifiers changed from: private */
    public List<MyCommentBean> listData;
    private PullToRefreshSwipeMenuListView listView;
    /* access modifiers changed from: private */
    public MyCommentAdapter mAdapter;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressBar;
    private String token = "";

    class MyCommentAdapter extends BaseAdapter {

        class ViewHolder {
            TextView content;
            ImageView imageView;
            TextView name;
            TextView time;

            ViewHolder() {
            }
        }

        MyCommentAdapter() {
        }

        public int getCount() {
            return MyCommentActivity.this.listData.size();
        }

        public Object getItem(int position) {
            return MyCommentActivity.this.listData.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(MyCommentActivity.this, R.layout.item_my_comment_list, null);
                holder.imageView = (ImageView) convertView.findViewById(R.id.mc_image_iv);
                holder.name = (TextView) convertView.findViewById(R.id.mc_name_tv);
                holder.content = (TextView) convertView.findViewById(R.id.mc_content_tv);
                holder.time = (TextView) convertView.findViewById(R.id.mc_time_tv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            UniversalImageLoadTool.disPlay(AppConstant.BASEUSERSERVICEURL + ((MyCommentBean) MyCommentActivity.this.listData.get(position)).getSurl(), holder.imageView, (Context) MyCommentActivity.this, (int) R.mipmap.image_moren_fang);
            holder.name.setText(((MyCommentBean) MyCommentActivity.this.listData.get(position)).getNickname());
            holder.content.setText(((MyCommentBean) MyCommentActivity.this.listData.get(position)).getContent());
            holder.time.setText(((MyCommentBean) MyCommentActivity.this.listData.get(position)).getCommenthowLong());
            return convertView;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_my_comment);
        initTitle(R.string.my_comment);
        init();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.listData != null && this.listData.size() > 0) {
            this.listData.clear();
        }
        getCommentList();
        super.onResume();
    }

    private void init() {
        this.mProgressBar = getProgressBar();
        this.mProgressBar.show();
        this.listData = new ArrayList();
        this.token = AppSP.getToken(this, "").toString();
        this.listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.listView);
        this.mAdapter = new MyCommentAdapter();
        this.listView.setAdapter((ListAdapter) this.mAdapter);
        this.listView.setPullRefreshEnable(true);
        this.listView.setPullLoadEnable(true);
        this.listView.setXListViewListener(this);
        this.listView.setOnItemClickListener(this);
        this.mHandler = new Handler();
        this.listView.setMenuCreator(new SwipeMenuCreator() {
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(MyCommentActivity.this.getApplicationContext());
                deleteItem.setBackground((Drawable) new ColorDrawable(Color.rgb(249, 63, 37)));
                deleteItem.setWidth(MyCommentActivity.this.dp2px(90));
                deleteItem.setIcon((int) R.drawable.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        });
        this.listView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                MyCommentBean item = (MyCommentBean) MyCommentActivity.this.listData.get(position);
                switch (index) {
                    case 0:
                        MyCommentActivity.this.delete(item, position);
                        return;
                    default:
                        return;
                }
            }
        });
        this.listView.setOnSwipeListener(new OnSwipeListener() {
            public void onSwipeStart(int position) {
            }

            public void onSwipeEnd(int position) {
            }
        });
    }

    private void getCommentList() {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.TOKEN, this.token);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.GET_COMMENT_LIST, params, new Listener<String>() {
            public void onResponse(String response) {
                if (MyCommentActivity.this.mProgressBar != null && MyCommentActivity.this.mProgressBar.isShowing()) {
                    MyCommentActivity.this.mProgressBar.dismiss();
                }
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        MyCommentActivity.this.listData.addAll(FormatUtil.jsonToList(FormatUtil.getStringFromJson(response, AppConstant.DATA, AppConstant.CODE, AppConstant.SUCCESS), MyCommentBean[].class));
                        MyCommentActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    Toast.makeText(MyCommentActivity.this, MyCommentActivity.this.getString(R.string.my_comment_fail_tip), 0).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (MyCommentActivity.this.mProgressBar != null && MyCommentActivity.this.mProgressBar.isShowing()) {
                        MyCommentActivity.this.mProgressBar.dismiss();
                    }
                    Toast.makeText(MyCommentActivity.this, MyCommentActivity.this.getString(R.string.my_comment_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (MyCommentActivity.this.mProgressBar != null && MyCommentActivity.this.mProgressBar.isShowing()) {
                    MyCommentActivity.this.mProgressBar.dismiss();
                }
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) MyCommentActivity.this, "获取我的评论失败").show();
                } else {
                    ToastFactory.getToast((Context) MyCommentActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public void delete(MyCommentBean bean, final int position) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.TOKEN, this.token);
        params.put("commentsid", bean.getId());
        params.put("pictureid", bean.getPictureId());
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.DELETE_COMMENT_LIST, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        Toast.makeText(MyCommentActivity.this, MyCommentActivity.this.getString(R.string.my_comment_delete_success_tip), 0).show();
                        MyCommentActivity.this.listData.remove(position);
                        MyCommentActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    Toast.makeText(MyCommentActivity.this, MyCommentActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MyCommentActivity.this, MyCommentActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) MyCommentActivity.this, MyCommentActivity.this.getString(R.string.check_code_send_fail_tip)).show();
                } else {
                    ToastFactory.getToast((Context) MyCommentActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, getResources().getDisplayMetrics());
    }

    public void onRefresh() {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                RefreshTime.setRefreshTime(MyCommentActivity.this.getApplicationContext(), new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(new Date()));
                MyCommentActivity.this.onLoad();
            }
        }, 2000);
    }

    public void onLoadMore() {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                MyCommentActivity.this.onLoad();
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public void onLoad() {
        this.listView.setRefreshTime(RefreshTime.getRefreshTime(getApplicationContext()));
        this.listView.stopRefresh();
        this.listView.stopLoadMore();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        MyCommentBean commentBean = (MyCommentBean) this.listData.get((int) id);
        IndexPhotoBean indexPhotoBean = new IndexPhotoBean();
        indexPhotoBean.setCommentnum(commentBean.getCommentNum());
        indexPhotoBean.setCreatetime(commentBean.getPiccreatetime());
        indexPhotoBean.setNickname(commentBean.getNickname());
        indexPhotoBean.setPraisenum(commentBean.getPraiseNum());
        indexPhotoBean.setShareurl(commentBean.getShareurl());
        indexPhotoBean.setLocation(commentBean.getLocation());
        indexPhotoBean.setId(commentBean.getPictureId());
        indexPhotoBean.setTitle(commentBean.getTitle());
        indexPhotoBean.setUserid(commentBean.getUserid());
        indexPhotoBean.setUrl(commentBean.getUrl());
        indexPhotoBean.setSurl(commentBean.getSurl());
        indexPhotoBean.setHowLong(commentBean.getHowLong());
        indexPhotoBean.setHidecontent(commentBean.getHidecontent());
        indexPhotoBean.setSongname(commentBean.getSongname());
        indexPhotoBean.setHeadimgurl(commentBean.getHeadimgurl());
        Intent intent = new Intent(this, ImageDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("detailsData", indexPhotoBean);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private ProgressDialog getProgressBar() {
        ProgressDialog mypDialog = new ProgressDialog(this);
        mypDialog.setProgressStyle(0);
        mypDialog.setMessage("正在加载评论中，请稍后。。。");
        mypDialog.setIndeterminate(false);
        mypDialog.setCancelable(true);
        return mypDialog;
    }
}
