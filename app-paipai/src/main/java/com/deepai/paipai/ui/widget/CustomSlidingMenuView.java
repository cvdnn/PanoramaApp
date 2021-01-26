package com.deepai.paipai.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.support.imageloader.UniversalImageLoadTool;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.activity.ble.BleListActivity;
import com.deepai.paipai.ui.activity.photo.MyWorksActivity;
import com.deepai.paipai.ui.activity.user.LoginActivity;
import com.deepai.paipai.ui.activity.user.MyCommentActivity;
import com.deepai.paipai.ui.activity.user.SystemSettingActivity;
import com.deepai.paipai.ui.activity.user.UserInfoActivity;
import com.deepai.paipai.ui.widget.CustomDialog.Builder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnClosedListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSlidingMenuView {
    /* access modifiers changed from: private */
    public BaseActivity activity;
    private Gson gson;
    private String headUrl;
    private LinearLayout linLogout;
    /* access modifiers changed from: private */
    public SlidingMenu localSlidingMenu;
    private ImageView mHeadImage;
    /* access modifiers changed from: private */
    public String token;
    private TextView tvUserName;
    private String userName;

    class MyAdapter extends SimpleAdapter {
        private List<Map<String, Object>> data;

        public MyAdapter(Context context, List<Map<String, Object>> data2, int resource, String[] from, int[] to) {
            super(context, data2, resource, from, to);
            this.data = data2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View convertView2 = LayoutInflater.from(CustomSlidingMenuView.this.activity).inflate(R.layout.item_left_menu, parent, false);
            TextView tv = (TextView) convertView2.findViewById(R.id.tv_left_menu_text);
            ((ImageView) convertView2.findViewById(R.id.iv_left_menu_icon)).setImageResource(((Integer) ((Map) this.data.get(position)).get("icon")).intValue());
            tv.setText((String) ((Map) this.data.get(position)).get("text"));
            return convertView2;
        }
    }

    public CustomSlidingMenuView(BaseActivity activity2) {
        this.activity = activity2;
    }

    public SlidingMenu initSlidingMenu() {
        this.localSlidingMenu = new SlidingMenu(this.activity);
        this.localSlidingMenu.setMode(0);
        this.localSlidingMenu.setTouchModeAbove(1);
        this.localSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        this.localSlidingMenu.setShadowDrawable((int) R.drawable.shape_slidingmenu_show);
        this.localSlidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
        this.localSlidingMenu.setFadeDegree(0.35f);
        this.localSlidingMenu.attachToActivity(this.activity, 0);
        this.localSlidingMenu.setMenu((int) R.layout.left_menu);
        this.localSlidingMenu.setOnOpenedListener(new OnOpenedListener() {
            public void onOpened() {
            }
        });
        this.localSlidingMenu.setOnClosedListener(new OnClosedListener() {
            public void onClosed() {
            }
        });
        initListView(this.localSlidingMenu.getMenu());
        return this.localSlidingMenu;
    }

    /* access modifiers changed from: private */
    public void paserResponseMessage() {
        this.mHeadImage.setImageResource(R.mipmap.logo_login);
        this.tvUserName.setVisibility(4);
        this.linLogout.setVisibility(8);
        AppSP.setToken(this.activity, "");
    }

    public void setState() {
        this.token = AppSP.getToken(this.activity, "").toString();
        this.headUrl = AppSP.getUserHeadUrl(this.activity, "").toString();
        this.userName = AppSP.getUserName(this.activity, "").toString();
        if (TextUtils.isEmpty(this.token.trim()) || "0".equals(this.token)) {
            this.mHeadImage.setImageResource(R.mipmap.logo_login);
            this.tvUserName.setVisibility(4);
            this.linLogout.setVisibility(8);
        } else {
            UniversalImageLoadTool.disCirclePlay(this.headUrl, this.mHeadImage, R.mipmap.logo_default, this.activity);
            this.tvUserName.setVisibility(0);
            this.tvUserName.setText(this.userName);
            this.linLogout.setVisibility(0);
        }
        this.mHeadImage.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CustomSlidingMenuView.this.token = AppSP.getToken(CustomSlidingMenuView.this.activity, "").toString();
                if (TextUtils.isEmpty(CustomSlidingMenuView.this.token.trim()) || "0".equals(CustomSlidingMenuView.this.token.trim())) {
                    CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, LoginActivity.class));
                } else {
                    CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, UserInfoActivity.class));
                }
            }
        });
        this.linLogout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CustomSlidingMenuView.this.exitDialog();
            }
        });
    }

    private void initListView(View view) {
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        String[] textArray = this.activity.getResources().getStringArray(R.array.array_left_menu_text);
        TypedArray ar = this.activity.getResources().obtainTypedArray(R.array.array_left_menu_icon);
        int len = ar.length();
        int[] iconArray = new int[len];
        for (int i = 0; i < len; i++) {
            iconArray[i] = ar.getResourceId(i, 0);
        }
        ar.recycle();
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i2 = 0; i2 < textArray.length; i2++) {
            Map<String, Object> map = new HashMap<>();
            map.put("icon", Integer.valueOf(iconArray[i2]));
            map.put("text", textArray[i2]);
            data.add(map);
        }
        this.linLogout = (LinearLayout) view.findViewById(R.id.ll_left_menu_foot);
        this.mHeadImage = (ImageView) view.findViewById(R.id.iv_portrait_left_menu);
        this.tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        ListView lv = (ListView) view.findViewById(R.id.lv_left_menu);
        lv.setAdapter(new MyAdapter(this.activity, data, R.layout.item_left_menu, new String[]{"icon", "text"}, new int[]{R.id.iv_left_menu_icon, R.id.tv_left_menu_text}));
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, MyWorksActivity.class));
                        if (CustomSlidingMenuView.this.localSlidingMenu != null && CustomSlidingMenuView.this.localSlidingMenu.isMenuShowing()) {
                            CustomSlidingMenuView.this.localSlidingMenu.showContent();
                            return;
                        }
                        return;
                    case 1:
                        if (TextUtils.isEmpty(AppSP.getToken(CustomSlidingMenuView.this.activity, "").toString())) {
                            CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, LoginActivity.class));
                            return;
                        }
                        CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, MyCommentActivity.class));
                        if (CustomSlidingMenuView.this.localSlidingMenu != null && CustomSlidingMenuView.this.localSlidingMenu.isMenuShowing()) {
                            CustomSlidingMenuView.this.localSlidingMenu.showContent();
                            return;
                        }
                        return;
                    case 2:
                        CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, BleListActivity.class));
                        if (CustomSlidingMenuView.this.localSlidingMenu != null && CustomSlidingMenuView.this.localSlidingMenu.isMenuShowing()) {
                            CustomSlidingMenuView.this.localSlidingMenu.showContent();
                            return;
                        }
                        return;
                    case 3:
                        CustomSlidingMenuView.this.activity.startActivity(new Intent(CustomSlidingMenuView.this.activity, SystemSettingActivity.class));
                        if (CustomSlidingMenuView.this.localSlidingMenu != null && CustomSlidingMenuView.this.localSlidingMenu.isMenuShowing()) {
                            CustomSlidingMenuView.this.localSlidingMenu.showContent();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void exitWork() {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.TOKEN, this.token);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.BASEUSERSERVICEURL_LOGOUT, params, new Listener<String>() {
            public void onResponse(String response) {
                CustomSlidingMenuView.this.paserResponseMessage();
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                CustomSlidingMenuView.this.paserResponseMessage();
            }
        }));
    }

    /* access modifiers changed from: private */
    public void exitDialog() {
        Builder builder = new Builder(this.activity);
        builder.setTitle("退出登录").setMessage("您确定要退出本应用吗？");
        builder.setPositiveButton("确定", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                CustomSlidingMenuView.this.exitWork();
                dialog.dismiss();
            }
        }).setNegativeButton("取消", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
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
}
