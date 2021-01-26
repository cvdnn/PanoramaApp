package com.deepai.paipai.wechattakephoto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.GridView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.deepai.paipai.R;
import com.deepai.paipai.wechattakephoto.entity.FolderBean;
import com.deepai.paipai.wechattakephoto.manager.ImageAdapter;
import com.deepai.paipai.wechattakephoto.manager.ImageAdapter.OnImg2CropClickListener;
import com.deepai.paipai.wechattakephoto.manager.ImageAdapter.OnImgClickListener;
import com.deepai.paipai.wechattakephoto.manager.ImageAdapter.OnSelectedChangeListener;
import com.deepai.paipai.wechattakephoto.manager.ImageTaker;
import com.deepai.paipai.wechattakephoto.manager.MyImageLoader;
import com.deepai.paipai.wechattakephoto.manager.MyImageLoader.Type;
import com.deepai.paipai.wechattakephoto.manager.TempManager;
import com.deepai.paipai.wechattakephoto.view.ListImageDirPopupWindow;
import com.deepai.paipai.wechattakephoto.view.ListImageDirPopupWindow.OnDirSelectedListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class WCTakePhotoActivity extends Activity {
    public static final int ACT_REQ_CODE = 17;
    public static final String ACT_RESP_KEY = "respKey";
    public static final int ALL_IMG_COUNT = -1;
    public static final String ALL_IMG_DIR = "/allImg";
    private static final int DEFAULT_CROP_SIZE = 600;
    private static final int DEFAULT_MAX_SELECT_COUNT = 9;
    public static final String EK_CROP_HEIGHT = "cropHeight";
    public static final String EK_CROP_WIDTH = "cropWidth";
    public static final String EK_SELECT_COUNT = "selectCount";
    public static final String EK_SELECT_TYPE = "selectType";
    public static final int EV_MULTIPLY_SELECT = -3;
    public static final int EV_SINGLE_SELECT = -2;
    private static final int LOAD_COMPLETE = 1;
    public static final int REQ_CODE_CROP_IMG = 274;
    public static final int REQ_CODE_TAKE_CAMERA = 273;
    public static final int REQ_CODE_TAKE_CAMERA_CROP = 272;
    public static final String TAKE_CAMERA_POSITION = "takeCamera";
    private ImageAdapter adapter;
    /* access modifiers changed from: private */
    public List<String> mAllImgList;
    /* access modifiers changed from: private */
    public int mCropHeight;
    /* access modifiers changed from: private */
    public int mCropWidth;
    /* access modifiers changed from: private */
    public File mCurrentDirFile;
    private List<String> mCurrentImgList;
    /* access modifiers changed from: private */
    public ListImageDirPopupWindow mDirPopupWindow;
    /* access modifiers changed from: private */
    public MyFilenameFilter mFilenameFilter;
    /* access modifiers changed from: private */
    public List<FolderBean> mFolderBeans = new ArrayList();
    private GridView mGridView;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    WCTakePhotoActivity.this.mProgressDialog.dismiss();
                    WCTakePhotoActivity.this.data2View(DirType.ALL);
                    WCTakePhotoActivity.this.initPopupWindow();
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    public ProgressDialog mProgressDialog;
    /* access modifiers changed from: private */
    public int mSelectCount;
    /* access modifiers changed from: private */
    public ArrayList<String> mSelectImg;
    private int mSelectType;
    /* access modifiers changed from: private */
    public TextView mTVComplete;
    /* access modifiers changed from: private */
    public TextView mTVCurrentDirName;
    private String mTempImagePath;
    /* access modifiers changed from: private */
    public Uri mTempImageUri;

    public enum DirType {
        ALL,
        DIR
    }

    private class MyFilenameFilter implements FilenameFilter {
        private MyFilenameFilter() {
        }

        public boolean accept(File dir, String filename) {
            return filename.endsWith(".jpeg") || filename.endsWith(Util.PHOTO_DEFAULT_EXT) || filename.endsWith(".png");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wc_take_photo);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(R.id.gv_wc_take_photo);
        this.mTVCurrentDirName = (TextView) findViewById(R.id.tv_current_dir_name);
        this.mTVComplete = (TextView) findViewById(R.id.tv_complete);
    }

    private void initData() {
        this.mSelectType = getIntent().getIntExtra(EK_SELECT_TYPE, -3);
        this.mSelectCount = getIntent().getIntExtra(EK_SELECT_COUNT, 9);
        this.mCropWidth = getIntent().getIntExtra(EK_CROP_WIDTH, 600);
        this.mCropHeight = getIntent().getIntExtra(EK_CROP_HEIGHT, 600);
        if (-3 == this.mSelectType) {
            this.mTVComplete.setVisibility(0);
        } else {
            this.mTVComplete.setVisibility(8);
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast.makeText(this, "当前SD卡不可用", 0).show();
            finish();
            return;
        }
        this.mProgressDialog = ProgressDialog.show(this, null, "正在加载图片");
        this.mFilenameFilter = new MyFilenameFilter();
        this.mAllImgList = new ArrayList();
        File tempFile = TempManager.INSTANCE.obtainFile();
        this.mTempImagePath = tempFile.getAbsolutePath();
        this.mTempImageUri = Uri.fromFile(tempFile);
        new Thread() {
            public void run() {
                Cursor cursor = WCTakePhotoActivity.this.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, "mime_type=? or mime_type=?", new String[]{"image/jpeg", "image/png"}, "date_modified DESC");
                Set<String> dirPaths = new HashSet<>();
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String path = cursor.getString(cursor.getColumnIndex("_data"));
                        File parentFile = new File(path).getParentFile();
                        if (parentFile != null) {
                            String dirPath = parentFile.getAbsolutePath();
                            if ((path.endsWith(".jpeg") || path.endsWith(Util.PHOTO_DEFAULT_EXT) || path.endsWith(".png")) && new File(path).exists()) {
                                WCTakePhotoActivity.this.mAllImgList.add(path);
                            }
                            if (!dirPaths.contains(dirPath)) {
                                dirPaths.add(dirPath);
                                FolderBean folderBean = new FolderBean();
                                folderBean.setDir(dirPath);
                                folderBean.setFirstImgPath(path);
                                if (parentFile.list(WCTakePhotoActivity.this.mFilenameFilter) != null) {
                                    folderBean.setImgCount(parentFile.list().length);
                                    WCTakePhotoActivity.this.mFolderBeans.add(folderBean);
                                }
                            }
                        }
                    }
                    cursor.close();
                }
                FolderBean folderBean2 = new FolderBean();
                folderBean2.setDir(WCTakePhotoActivity.ALL_IMG_DIR);
                folderBean2.setImgCount(-1);
                folderBean2.setFirstImgPath(WCTakePhotoActivity.this.mAllImgList.size() > 0 ? (String) WCTakePhotoActivity.this.mAllImgList.get(0) : "");
                WCTakePhotoActivity.this.mFolderBeans.add(0, folderBean2);
                WCTakePhotoActivity.this.mCurrentDirFile = new File(WCTakePhotoActivity.ALL_IMG_DIR);
                WCTakePhotoActivity.this.mAllImgList.add(0, WCTakePhotoActivity.TAKE_CAMERA_POSITION);
                WCTakePhotoActivity.this.mHandler.sendEmptyMessage(1);
            }
        }.start();
    }

    private void initEvent() {
        this.mTVCurrentDirName.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                WCTakePhotoActivity.this.mDirPopupWindow.showAsDropDown(WCTakePhotoActivity.this.mTVCurrentDirName, 0, 0);
                WCTakePhotoActivity.this.lightOff();
            }
        });
        this.mTVComplete.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                WCTakePhotoActivity.this.response2Act();
            }
        });
    }

    /* access modifiers changed from: private */
    public void initPopupWindow() {
        this.mDirPopupWindow = new ListImageDirPopupWindow(this, this.mFolderBeans);
        this.mDirPopupWindow.setAnimationStyle(R.style.dir_popup_window_anim);
        this.mDirPopupWindow.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                WCTakePhotoActivity.this.lightOn();
            }
        });
        this.mDirPopupWindow.setOnDirSelectedListener(new OnDirSelectedListener() {
            public void onSelect(FolderBean folderBean) {
                WCTakePhotoActivity.this.mCurrentDirFile = new File(folderBean.getDir());
                if (WCTakePhotoActivity.ALL_IMG_DIR.equals(folderBean.getDir())) {
                    WCTakePhotoActivity.this.data2View(DirType.ALL);
                } else {
                    WCTakePhotoActivity.this.data2View(DirType.DIR);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void data2View(DirType dirType) {
        if (this.mFolderBeans.size() == 1) {
            Toast.makeText(this, "未扫描到任何图片", 0).show();
        }
        if (dirType == DirType.ALL) {
            this.mCurrentImgList = this.mAllImgList;
        } else if (dirType == DirType.DIR && this.mCurrentDirFile.exists()) {
            this.mCurrentImgList = Arrays.asList(this.mCurrentDirFile.list(this.mFilenameFilter));
        }
        if (this.adapter == null) {
            initAdapter(dirType);
        } else {
            this.adapter.changeData(this.mCurrentImgList, this.mCurrentDirFile.getAbsolutePath(), dirType, this.mSelectCount, this.mSelectType, this.mTempImageUri);
        }
        this.mTVCurrentDirName.setText(this.mCurrentDirFile.exists() ? this.mCurrentDirFile.getName() : "所有图片");
    }

    private void initAdapter(DirType dirType) {
        this.adapter = new ImageAdapter(this, this.mCurrentImgList, this.mCurrentDirFile.getAbsolutePath(), dirType, this.mSelectCount, this.mSelectType, this.mTempImageUri);
        this.adapter.setOnSelectedChangeListener(new OnSelectedChangeListener() {
            public void onSelectedChange(List<String> selectImg) {
                WCTakePhotoActivity.this.mSelectImg = (ArrayList) selectImg;
                if (WCTakePhotoActivity.this.mSelectImg.size() == 0) {
                    WCTakePhotoActivity.this.mTVComplete.setText("完成");
                } else {
                    WCTakePhotoActivity.this.mTVComplete.setText("完成 " + WCTakePhotoActivity.this.mSelectImg.size() + CookieSpec.PATH_DELIM + WCTakePhotoActivity.this.mSelectCount);
                }
            }
        });
        this.adapter.setOnImg2CropClickListener(new OnImg2CropClickListener() {
            public void onImg2CropClick(String imgPath) {
                if (new File(imgPath).isFile()) {
                    WCTakePhotoActivity.this.cropImageUri(Uri.fromFile(new File(imgPath)), WCTakePhotoActivity.this.mTempImageUri, WCTakePhotoActivity.this.mCropWidth, WCTakePhotoActivity.this.mCropHeight);
                }
            }
        });
        this.adapter.setOnImgClickListener(new OnImgClickListener() {
            public void onImgClick(String imgPath) {
            }
        });
        this.mGridView.setAdapter(this.adapter);
    }

    /* access modifiers changed from: private */
    public void lightOn() {
        LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1.0f;
        getWindow().setAttributes(lp);
    }

    /* access modifiers changed from: private */
    public void lightOff() {
        LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            switch (requestCode) {
                case REQ_CODE_TAKE_CAMERA_CROP /*272*/:
                    cropImageUri(this.mTempImageUri, this.mCropWidth, this.mCropHeight);
                    return;
                case REQ_CODE_TAKE_CAMERA /*273*/:
                    clearSelectedImg();
                    if (this.mSelectImg == null) {
                        this.mSelectImg = new ArrayList<>();
                    }
                    if (new File(this.mTempImagePath).exists()) {
                        this.mSelectImg.add(this.mTempImagePath);
                        response2Act();
                        return;
                    }
                    Toast.makeText(this, "拍照失败", 0).show();
                    finish();
                    return;
                case REQ_CODE_CROP_IMG /*274*/:
                    clearSelectedImg();
                    if (this.mSelectImg == null) {
                        this.mSelectImg = new ArrayList<>();
                    }
                    if (new File(this.mTempImagePath).exists()) {
                        this.mSelectImg.add(this.mTempImagePath);
                        response2Act();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cropImageUri(Uri uriOutput, int outputX, int outputY) {
        cropImageUri(uriOutput, uriOutput, outputX, outputY);
    }

    /* access modifiers changed from: private */
    public void cropImageUri(Uri uriInput, Uri uriOutput, int outputX, int outputY) {
        int i;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uriInput, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", this.mCropWidth > this.mCropHeight ? this.mCropWidth / this.mCropHeight : 1);
        String str = "aspectY";
        if (this.mCropHeight > this.mCropWidth) {
            i = this.mCropHeight / this.mCropWidth;
        } else {
            i = 1;
        }
        intent.putExtra(str, i);
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra("scale", true);
        intent.putExtra("output", uriOutput);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, REQ_CODE_CROP_IMG);
    }

    /* access modifiers changed from: private */
    public void response2Act() {
        if (this.mSelectImg != null && this.mSelectImg.size() != 0) {
            ArrayList<String> respImgList = new ArrayList<>();
            for (int i = 0; i < this.mSelectImg.size(); i++) {
                respImgList.add(ImageTaker.INSTANCE.compressImageFile((String) this.mSelectImg.get(i)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra(ACT_RESP_KEY, respImgList);
            setResult(-1, intent);
            finish();
        }
    }

    private void clearSelectedImg() {
        if (this.mSelectImg != null && this.mSelectImg.size() > 0) {
            this.mSelectImg.clear();
        }
        if (this.adapter != null) {
            this.adapter.clearSelectImg();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        clearSelectedImg();
        MyImageLoader.getInstance(3, Type.LIFO).clearLruCache();
        super.onDestroy();
    }

    public void onBackClick(View view) {
        finish();
    }
}
