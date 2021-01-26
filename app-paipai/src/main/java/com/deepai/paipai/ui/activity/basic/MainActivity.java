package com.deepai.paipai.ui.activity.basic;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.request.Json2EntityPostRequest;
import com.deepai.library.app.AppManager;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.support.adapter.ListViewIndexAdapter;
import com.deepai.paipai.support.bean.IndexPhotoBean;
import com.deepai.paipai.support.ble.MyReadSendBle;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.support.net.NetConstants;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.photo.CameraActivity;
import com.deepai.paipai.ui.widget.CustomSlidingMenuView;
import com.deepai.paipai.ui.widget.refreshview.WaterDropListView;
import com.deepai.paipai.ui.widget.refreshview.WaterDropListView.IWaterDropListViewListener;
import com.google.gson.reflect.TypeToken;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class MainActivity extends BaseActivity implements IWaterDropListViewListener {
    private static String OPCV_TAG = "opencv/MainActivity";
    /* access modifiers changed from: private */
    public int countPage = 1;
    /* access modifiers changed from: private */
    public Handler mControlHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    MainActivity.this.countPage = 1;
                    MainActivity.this.getIndexData(1, 10);
                    MainActivity.this.mIndexListView.stopRefresh();
                    return;
                case 2:
                    MainActivity.access$004(MainActivity.this);
                    MainActivity.this.getIndexData(MainActivity.this.countPage, 10);
                    MainActivity.this.mIndexListView.stopLoadMore();
                    return;
                default:
                    return;
            }
        }
    };
    private CustomSlidingMenuView mCusSlidingmenu;
    private long mExitTime;
    /* access modifiers changed from: private */
    public List<IndexPhotoBean> mIndexDataList = new ArrayList();
    /* access modifiers changed from: private */
    public WaterDropListView mIndexListView;
    /* access modifiers changed from: private */
    public ListViewIndexAdapter mListAdapter;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressBar;
    private SlidingMenu mSlidingMenu;

    static /* synthetic */ int access$004(MainActivity x0) {
        int i = x0.countPage + 1;
        x0.countPage = i;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        initView();
        initSlidingMenu();
        checkOpened();
    }

    private void checkOpened() {
        if (!AppSP.getOpened(this)) {
            AppSP.setOpened(this);
            new Thread() {
                public void run() {
                    MediaRecorder recorder = new MediaRecorder();
                    recorder.setAudioSource(1);
                    recorder.setOutputFormat(1);
                    recorder.setAudioEncoder(1);
                    String filePath = FileUtils.getRecordDir() + CookieSpec.PATH_DELIM + System.currentTimeMillis() + ".amr";
                    recorder.setOutputFile(FileUtils.getRecordDir() + CookieSpec.PATH_DELIM + System.currentTimeMillis() + ".amr");
                    try {
                        recorder.prepare();
                        recorder.start();
                        recorder.stop();
                        recorder.reset();
                        recorder.release();
                        if (filePath != null) {
                            File file = new File(filePath);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    } catch (Exception e) {
                        recorder.reset();
                        recorder.release();
                        if (filePath != null) {
                            File file2 = new File(filePath);
                            if (file2.exists()) {
                                file2.delete();
                            }
                        }
                    } catch (Throwable th) {
                        recorder.reset();
                        recorder.release();
                        if (filePath != null) {
                            File file3 = new File(filePath);
                            if (file3.exists()) {
                                file3.delete();
                            }
                        }
                        throw th;
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: protected */
    public void initSlidingMenu() {
        this.mCusSlidingmenu = new CustomSlidingMenuView(this);
        this.mSlidingMenu = this.mCusSlidingmenu.initSlidingMenu();
    }

    private void initView() {
        this.mProgressBar = getProgressBar();
        this.mProgressBar.show();
        this.mIndexListView = (WaterDropListView) findViewById(R.id.custom_recycler_list);
        this.mListAdapter = new ListViewIndexAdapter(this.mIndexDataList, this);
        this.mIndexListView.setAdapter((ListAdapter) this.mListAdapter);
        this.mIndexListView.setWaterDropListViewListener(this);
        this.mIndexListView.setPullLoadEnable(true);
    }

    public void onTitleLeftClick(View view) {
        if (this.mSlidingMenu != null && !this.mSlidingMenu.isMenuShowing()) {
            this.mSlidingMenu.showMenu();
        }
    }

    public void onTitleRightClick(View view) {
        startActivity(new Intent(this, CameraActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mCusSlidingmenu.setState();
        this.countPage = 1;
        getIndexData(1, 10);
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void getIndexData(final int page, int rows) {
        Map<String, String> params = new HashMap<>();
        params.put("page", page + "");
        params.put("rows", rows + "");
        PaiApp.vQueue.add(new Json2EntityPostRequest(NetConstants.INDEX_DATA, params, new TypeToken<List<IndexPhotoBean>>() {
        }.getType(), new Listener<List<IndexPhotoBean>>() {
            public void onResponse(List<IndexPhotoBean> response) {
                if (MainActivity.this.mProgressBar != null && MainActivity.this.mProgressBar.isShowing()) {
                    MainActivity.this.mProgressBar.dismiss();
                }
                if (response != null && response.size() > 0) {
                    if (page == 1 && MainActivity.this.mIndexDataList.size() > 0) {
                        MainActivity.this.mIndexDataList.clear();
                    }
                    MainActivity.this.mIndexDataList.addAll(response);
                    if (MainActivity.this.mIndexDataList.size() > 0) {
                        MainActivity.this.mListAdapter.notifyDataSetChanged();
                    }
                } else if (response != null && response.size() == 0) {
                    MainActivity.this.countPage = MainActivity.this.countPage - 1;
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (MainActivity.this.mProgressBar != null && MainActivity.this.mProgressBar.isShowing()) {
                    MainActivity.this.mProgressBar.dismiss();
                }
            }
        }));
    }

    private ProgressDialog getProgressBar() {
        ProgressDialog mypDialog = new ProgressDialog(this);
        mypDialog.setProgressStyle(0);
        mypDialog.setMessage("正在加载图片中，请稍后...");
        mypDialog.setIndeterminate(false);
        mypDialog.setCancelable(true);
        return mypDialog;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (this.mSlidingMenu.isMenuShowing() || this.mSlidingMenu.isSecondaryMenuShowing()) {
                this.mSlidingMenu.showContent();
                return true;
            } else if (System.currentTimeMillis() - this.mExitTime > 2000) {
                ToastFactory.getToast((Context) this, "再按一次退出").show();
                this.mExitTime = System.currentTimeMillis();
                return true;
            } else {
                MyReadSendBle.Stop();
                AppManager.getInstance().finishAllActivity();
                return true;
            }
        } else if (keyCode != 82) {
            return super.onKeyDown(keyCode, event);
        } else {
            return true;
        }
    }

    public void onRefresh() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    MainActivity.this.mControlHandler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onLoadMore() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    MainActivity.this.mControlHandler.sendEmptyMessage(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
