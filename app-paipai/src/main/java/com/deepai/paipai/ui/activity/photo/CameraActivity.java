package com.deepai.paipai.ui.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.support.ble.MyBle;
import com.deepai.paipai.support.ble.MyReadSendBle;
import com.deepai.paipai.support.camera.CameraConstants;
import com.deepai.paipai.support.camera.CameraContainer;
import com.deepai.paipai.support.camera.CameraContainer.TakePictureListener;
import com.deepai.paipai.support.camera.CameraView.FlashMode;
import com.deepai.paipai.support.camera.PicStitcher;
import com.deepai.paipai.support.file.FileOperateUtil;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.sys.service.BlueToothServiceBle;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.widget.MyProgressView;
import com.tencent.mm.sdk.platformtools.Util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.httpclient.cookie.CookieSpec;

public class CameraActivity extends BaseActivity implements OnClickListener, TakePictureListener {
    public final Handler bleHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 21:
                    byte[] readBuf = (byte[]) msg.obj;
                    if (readBuf[5] == 2) {
                        Log.d("auto1 byte", "get " + Arrays.toString(readBuf));
                        if (CameraActivity.this.myReadSendBle != null) {
                            CameraConstants.savePictureFileNum = readBuf[10] & 255;
                            if (CameraConstants.savePictureFileNum == 0) {
                                FileUtils.delAllPicture();
                            }
                            CameraActivity.this.onTakePictureStart();
                            return;
                        }
                        return;
                    }
                    return;
                case 23:
                    switch (msg.arg1) {
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean isRecording;
    private LinearLayout llExit;
    private ImageButton mCameraShutterButton;
    /* access modifiers changed from: private */
    public CameraContainer mContainer;
    private ImageView mFlashView;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -9:
                    CameraActivity.this.mHandler.removeCallbacks(CameraActivity.this.makingRunnable);
                    ToastFactory.getToast((Context) CameraActivity.this.activity, "制作失败").show();
                    CameraActivity.this.onBackPressed();
                    return;
                case -8:
                    ToastFactory.getToast((Context) CameraActivity.this.activity, "制作成功").show();
                    String filePath = (String) msg.obj;
                    Bundle bundle = new Bundle();
                    bundle.putString(CreatePhotoActivity.EK_BIG_IMG_PATH, filePath);
                    CameraActivity.this.mHandler.removeCallbacks(CameraActivity.this.makingRunnable);
                    CameraActivity.this.jumpToActivity(CameraActivity.this.activity, CreatePhotoActivity.class, bundle);
                    CameraActivity.this.onBackPressed();
                    return;
                default:
                    return;
            }
        }
    };
    private View mHeaderBar;
    private boolean mIsRecordMode;
    /* access modifiers changed from: private */
    public ProgressBar mPbMaking;
    private String mSaveRoot;
    private ImageView mSwitchCameraView;
    private ImageButton mSwitchModeButton;
    /* access modifiers changed from: private */
    public Making makingRunnable;
    private ImageView myImageView18;
    private ImageView myImageView36;
    private ImageView myImageView72;
    private ImageView myImageViewDaoRu;
    private ImageView myImageViewVideo;
    /* access modifiers changed from: private */
    public MyProgressView myProgressView;
    /* access modifiers changed from: private */
    public MyReadSendBle myReadSendBle;
    /* access modifiers changed from: private */
    public TextView myRunTextView;
    /* access modifiers changed from: private */
    public PicStitcher picStitcher;
    private TextView tvPicCount;

    class Making implements Runnable {
        private int mCount = 0;
        private int mMax;

        public Making(int max) {
            this.mMax = max;
        }

        public void run() {
            this.mCount++;
            if (this.mCount < this.mMax) {
                CameraActivity.this.mPbMaking.setProgress(this.mCount);
                CameraActivity.this.mHandler.postDelayed(this, 1000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_camera);
        this.mHeaderBar = findViewById(R.id.camera_header_bar);
        this.mContainer = (CameraContainer) findViewById(R.id.container);
        this.mCameraShutterButton = (ImageButton) findViewById(R.id.btn_shutter_camera);
        this.mSwitchCameraView = (ImageView) findViewById(R.id.btn_switch_camera);
        this.mFlashView = (ImageView) findViewById(R.id.btn_flash_mode);
        this.mPbMaking = (ProgressBar) findViewById(R.id.pb_create_image);
        this.mPbMaking.setMax(80);
        this.makingRunnable = new Making(80);
        this.mSwitchModeButton = (ImageButton) findViewById(R.id.btn_switch_mode);
        this.llExit = (LinearLayout) findViewById(R.id.ll_camera_cancel);
        this.llExit.setOnClickListener(this);
        this.mCameraShutterButton.setOnClickListener(this);
        this.mFlashView.setOnClickListener(this);
        this.mSwitchModeButton.setOnClickListener(this);
        this.mSwitchCameraView.setOnClickListener(this);
        this.mSaveRoot = "test";
        this.mSwitchModeButton.setImageResource(R.mipmap.ic_switch_camera);
        this.mCameraShutterButton.setVisibility(0);
        this.mHeaderBar.setVisibility(0);
        this.mIsRecordMode = false;
        if (this.mContainer.mCameraView.mCamera == null) {
            ToastFactory.getToast((Context) this, "无法打开摄像头,请在系统设置中开启摄像头权限");
            onBackPressed();
        } else {
            this.mContainer.switchMode(0);
            this.mContainer.setRootPath(this.mSaveRoot);
            this.mContainer.setFlashMode(FlashMode.OFF);
        }
        stopRecord();
        this.myRunTextView = (TextView) findViewById(R.id.C2_RunTextView);
        this.myProgressView = (MyProgressView) findViewById(R.id.C2_MyProgress);
        this.mContainer.myProgressView = this.myProgressView;
        this.myImageView18 = (ImageView) findViewById(R.id.C2_Button18);
        this.myImageView18.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CameraConstants.videoMode = 18;
                CameraActivity.this.xianShiMode();
            }
        });
        this.myImageView36 = (ImageView) findViewById(R.id.C2_Button36);
        this.myImageView36.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CameraConstants.videoMode = 36;
                CameraActivity.this.xianShiMode();
            }
        });
        this.myImageView72 = (ImageView) findViewById(R.id.C2_Button72);
        this.myImageView72.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CameraConstants.videoMode = 72;
                CameraActivity.this.xianShiMode();
            }
        });
        this.myImageViewVideo = (ImageView) findViewById(R.id.C2_ButtonVideo);
        this.myImageViewVideo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CameraConstants.videoMode = 100;
                CameraActivity.this.xianShiMode();
            }
        });
        this.myImageViewDaoRu = (ImageView) findViewById(R.id.C2_ButtonDaoRu);
        this.myImageViewDaoRu.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (CameraConstants.videoMode == 100) {
                    CameraActivity.this.openActivity(1);
                } else {
                    CameraActivity.this.openActivity(0);
                }
            }
        });
        CameraConstants.videoMode = 18;
        xianShiMode();
        this.tvPicCount = (TextView) findViewById(R.id.tv_pic_count);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.myReadSendBle = null;
        this.myReadSendBle = new MyReadSendBle(this, this.bleHandler);
        this.myRunTextView.setVisibility(4);
        this.myProgressView.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.myReadSendBle = null;
        this.mContainer.mCameraView.releaseCamera();
        Log.e("CameraActivity", "release camera");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    private void stopRecord() {
        this.mContainer.stopRecord(this);
        this.isRecording = false;
    }

    /* access modifiers changed from: 0000 */
    public void xianShiMode() {
        this.myImageView18.setImageResource(R.mipmap.c2_4off);
        this.myImageView36.setImageResource(R.mipmap.c2_5off);
        this.myImageView72.setImageResource(R.mipmap.c2_6off);
        this.myImageViewVideo.setImageResource(R.mipmap.c2_9off);
        switch (CameraConstants.videoMode) {
            case 18:
                this.myImageView18.setImageResource(R.mipmap.c2_4on);
                return;
            case 36:
                this.myImageView36.setImageResource(R.mipmap.c2_5on);
                return;
            case 72:
                this.myImageView72.setImageResource(R.mipmap.c2_6on);
                return;
            case 100:
                this.myImageViewVideo.setImageResource(R.mipmap.c2_9on);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    public void openActivity(int myNum) {
        if (myNum != 0 && myNum == 1 && FileUtils.getVideoExists()) {
        }
    }

    private void initThumbnail() {
        List<File> files = FileOperateUtil.listFiles(FileOperateUtil.getFolderPath(this, 2, this.mSaveRoot), Util.PHOTO_DEFAULT_EXT);
        if (files == null || files.size() <= 0 || BitmapFactory.decodeFile(((File) files.get(0)).getAbsolutePath()) == null || ((File) files.get(0)).getAbsolutePath().contains("video")) {
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_camera_cancel /*2131624134*/:
                onBackPressed();
                return;
            case R.id.btn_shutter_camera /*2131624135*/:
                if (CameraConstants.videoMode == 100) {
                    MyBle.startRun(Boolean.valueOf(true), this, this.myReadSendBle, 0, 1, 1);
                    if (BlueToothServiceBle.isConnectOK.booleanValue()) {
                        this.mHandler.postDelayed(new Runnable() {
                            public void run() {
                                CameraActivity.this.stopVideo();
                            }
                        }, 31000);
                        return;
                    }
                    return;
                }
                CameraConstants.savePictureFileNum = 0;
                MyBle.startAuto1(Boolean.valueOf(true), this, this.myReadSendBle);
                if (BlueToothServiceBle.isConnectOK.booleanValue()) {
                    this.picStitcher = PicStitcher.getInstance();
                    this.picStitcher.initStitch(this.mHandler, CameraConstants.videoMode / 1);
                    this.myRunTextView.setVisibility(0);
                    this.mHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (CameraConstants.savePictureFileNum == 0) {
                                CameraActivity.this.myRunTextView.setVisibility(4);
                                CameraActivity.this.myProgressView.setVisibility(4);
                                BlueToothServiceBle.isConnectOK = Boolean.valueOf(false);
                                MyBle.startAuto1(Boolean.valueOf(true), CameraActivity.this, CameraActivity.this.myReadSendBle);
                            }
                        }
                    }, 10000);
                    return;
                }
                return;
            case R.id.btn_flash_mode /*2131624146*/:
                if (this.mContainer.getFlashMode() == FlashMode.TORCH) {
                    this.mContainer.setFlashMode(FlashMode.OFF);
                    this.mFlashView.setImageResource(R.mipmap.c2_2off);
                    return;
                }
                this.mContainer.setFlashMode(FlashMode.TORCH);
                this.mFlashView.setImageResource(R.mipmap.c2_2on);
                return;
            case R.id.btn_switch_camera /*2131624147*/:
                this.mContainer.switchCamera();
                if (this.mContainer.mCameraView.mIsFrontCamera) {
                    this.mFlashView.setVisibility(8);
                    return;
                } else {
                    this.mFlashView.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    public void stopVideo() {
        if (this.isRecording) {
            this.isRecording = false;
            stopRecord();
            this.myRunTextView.setVisibility(4);
            this.myProgressView.setVisibility(4);
        }
    }

    public void onTakePictureStart() {
        this.mCameraShutterButton.setClickable(false);
        this.mContainer.takePicture(this);
    }

    public void onTakePictureEnd(Bitmap bm) {
        this.tvPicCount.setText((CameraConstants.savePictureFileNum + 1) + "");
        if (CameraConstants.savePictureFileNum == CameraConstants.videoMode - 1) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    if (CameraConstants.savePictureFileNum % 1 == 0) {
                        CameraActivity.this.picStitcher.addPic(FileUtils.getTempFilePath() + CookieSpec.PATH_DELIM + (CameraConstants.savePictureFileNum / 1) + Util.PHOTO_DEFAULT_EXT);
                    }
                    CameraActivity.this.mPbMaking.setVisibility(0);
                    CameraActivity.this.mHandler.postDelayed(CameraActivity.this.makingRunnable, 1000);
                    CameraActivity.this.mContainer.stopCamera();
                }
            }, 1000);
        } else {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    if (CameraConstants.savePictureFileNum % 1 == 0) {
                        CameraActivity.this.picStitcher.addPic(FileUtils.getTempFilePath() + CookieSpec.PATH_DELIM + (CameraConstants.savePictureFileNum / 1) + Util.PHOTO_DEFAULT_EXT);
                    }
                    MyBle.startAuto1(Boolean.valueOf(true), CameraActivity.this, CameraActivity.this.myReadSendBle);
                }
            }, 2000);
        }
    }

    public void onAnimtionEnd(Bitmap bm, boolean isVideo) {
        Log.d("", "录像完成");
        if (bm != null) {
        }
    }
}
