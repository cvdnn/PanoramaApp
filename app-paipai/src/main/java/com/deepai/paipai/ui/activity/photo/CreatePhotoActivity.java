package com.deepai.paipai.ui.activity.photo;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.dao.ShareInformManage;
import com.deepai.paipai.support.bean.HideInfo;
import com.deepai.paipai.support.bean.SaveShareDataBean;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.support.photodeal.BitmapUtil;
import com.deepai.paipai.support.photodeal.ImageSplite;
import com.deepai.paipai.ui.activity.share.SaveShareActivity;
import com.deepai.paipai.wechattakephoto.WCTakePhotoActivity;
import com.deepai.paipai.wechattakephoto.manager.ImageTaker;
import com.deepai.paipai.wxapi.AddHideInformPopupWindow;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.panoramagl.PLCylindricalPanorama;
import com.panoramagl.PLIImage;
import com.panoramagl.PLIView;
import com.panoramagl.PLImage;
import com.panoramagl.PLView;
import com.panoramagl.PLViewListener;
import com.panoramagl.hotspots.PLHotspot;
import com.panoramagl.hotspots.PLIHotspot;
import com.panoramagl.ios.structs.CGPoint;
import com.panoramagl.structs.PLPosition;
import com.panoramagl.utils.PLUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class CreatePhotoActivity extends PLView {
    public static final String EK_BIG_IMG_PATH = "imagePath";
    private static final int SELECT_MUSIC = 3001;
    private float bitmapHalfX;
    private float bitmapHalfY;
    /* access modifiers changed from: private */
    public String filePath = "";
    /* access modifiers changed from: private */
    public List<HideInfo> mHideInformBeans = new ArrayList();
    private ImageButton mImageMusic;
    /* access modifiers changed from: private */
    public LinearLayout mLinearPhoto;
    private Bitmap mShowBitmap;
    private MediaPlayer mediaPlayer;
    private String musicPathName = "";
    private ShareInformManage shareInformManage;
    private float xS;
    private float yS;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListener(new PLViewListener() {
            public void onDidClickHotspot(PLIView view, PLIHotspot hotspot, CGPoint screenPoint, PLPosition scene3DPoint) {
                if (CreatePhotoActivity.this.mHideInformBeans == null || CreatePhotoActivity.this.mHideInformBeans.size() <= 0) {
                    ToastFactory.getToast((Context) view.getActivity(), "暂无隐藏信息").show();
                    return;
                }
                new AddHideInformPopupWindow(CreatePhotoActivity.this, (HideInfo) CreatePhotoActivity.this.mHideInformBeans.get((int) hotspot.getIdentifier())).showPopupWindow(CreatePhotoActivity.this.mLinearPhoto, screenPoint.x, screenPoint.y);
            }
        });
        this.shareInformManage = ShareInformManage.getManage(PaiApp.getPaiApplication().getSQLHelper());
        ImageTaker.INSTANCE.initTemp();
        getData(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getData(intent);
    }

    private void getData(Intent intent) {
        this.filePath = intent.getStringExtra(EK_BIG_IMG_PATH);
        if (!TextUtils.isEmpty(this.filePath)) {
            SaveShareDataBean beanSaveData = this.shareInformManage.getSaveDataFromDB(this.filePath.substring(this.filePath.lastIndexOf(CookieSpec.PATH_DELIM) + 1, this.filePath.length() - 4));
            if (beanSaveData != null) {
                createPhotoView(beanSaveData.getPhotoImagPath(), beanSaveData);
            } else {
                createPhotoView(this.filePath, null);
            }
        }
    }

    private void initView(ViewGroup viewGroup) {
        this.mImageMusic = (ImageButton) viewGroup.findViewById(R.id.image_create_music);
    }

    private void createPhotoView(String minePath, SaveShareDataBean saveShareDataBean) {
        if ("pano".equals(minePath.substring(0, 4))) {
            this.mShowBitmap = BitmapUtil.getImageFromAssetsFile(minePath, this);
        } else {
            this.mShowBitmap = BitmapUtil.getBitmapFromFile(minePath, this);
        }
        if (this.mShowBitmap != null) {
            this.xS = ((float) this.mShowBitmap.getWidth()) / 1024.0f;
            this.yS = ((float) this.mShowBitmap.getHeight()) / 512.0f;
            this.mShowBitmap = ImageSplite.zoomImg(this.mShowBitmap, 1024, 512);
            this.bitmapHalfX = ((float) this.mShowBitmap.getWidth()) / 2.0f;
            this.bitmapHalfY = ((float) this.mShowBitmap.getHeight()) / 2.0f;
            PLCylindricalPanorama cylindricalPanorama = new PLCylindricalPanorama();
            cylindricalPanorama.setHeight(1.0f);
            cylindricalPanorama.getCamera().setPitchRange(0.0f, 0.0f);
            cylindricalPanorama.setImage(new PLImage(this.mShowBitmap, false));
            if (saveShareDataBean != null) {
                String hide = saveShareDataBean.getHideInform();
                if (!TextUtils.isEmpty(hide)) {
                    List<HideInfo> mineHideInformBeans = (List) new Gson().fromJson(hide, new TypeToken<List<HideInfo>>() {
                    }.getType());
                    if (mineHideInformBeans != null && mineHideInformBeans.size() > 0) {
                        this.mHideInformBeans.addAll(mineHideInformBeans);
                        for (int i = 0; i < mineHideInformBeans.size(); i++) {
                            HideInfo bean = (HideInfo) mineHideInformBeans.get(i);
                            float showY = ((this.bitmapHalfY - (((float) bean.getPoint().y) / this.yS)) * 24.0f) / 256.0f;
                            cylindricalPanorama.addHotspot(new PLHotspot((long) i, (PLIImage) new PLImage(PLUtils.getBitmap((Context) this, (int) R.mipmap.hide_point)), showY, (((((float) bean.getPoint().x) / this.xS) - this.bitmapHalfX) * 180.0f) / 512.0f, 0.03f, 0.03f));
                        }
                    }
                }
                String music = saveShareDataBean.getMusicName();
                if (!TextUtils.isEmpty(music) && !"null".equals(music)) {
                    this.mImageMusic.setVisibility(0);
                    this.musicPathName = music;
                    showMusic(music);
                }
            }
            setPanorama(cylindricalPanorama);
        }
    }

    /* access modifiers changed from: protected */
    public View onContentViewCreated(View contentView) {
        ViewGroup mainView = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_create_photo, null);
        this.mLinearPhoto = (LinearLayout) mainView.findViewById(R.id.linear_create_photo);
        initView(mainView);
        this.mLinearPhoto.addView(contentView, 0);
        mainView.findViewById(R.id.tv_add_hide_info).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                HideInfoActivity.startForResult(CreatePhotoActivity.this, CreatePhotoActivity.this.filePath, CreatePhotoActivity.this.mHideInformBeans);
            }
        });
        mainView.findViewById(R.id.tv_add_cut_img).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CreatePhotoActivity.this, WCTakePhotoActivity.class);
                intent.putExtra(WCTakePhotoActivity.EK_SELECT_TYPE, -3);
                intent.putExtra(WCTakePhotoActivity.EK_SELECT_COUNT, 1);
                CreatePhotoActivity.this.startActivityForResult(intent, 17);
            }
        });
        mainView.findViewById(R.id.tv_add_music_click).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CreatePhotoActivity.this.startActivityForResult(new Intent(CreatePhotoActivity.this, MusicListActivity.class), 3001);
            }
        });
        return super.onContentViewCreated(mainView);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String photoPath = "";
        if (resultCode != -1) {
            Log.e("UserInfoActivity", "ActivityResult resultCode error");
            return;
        }
        if (requestCode == 17) {
            ArrayList stringArrayListExtra = data.getStringArrayListExtra(WCTakePhotoActivity.ACT_RESP_KEY);
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                photoPath = (String) stringArrayListExtra.get(0);
            }
            if (new File(photoPath).exists()) {
                Intent intent = new Intent(this, CutImgActivity.class);
                intent.putExtra(CutImgActivity.EK_PHOTO_PATH, photoPath);
                Intent intent2 = intent;
                intent2.putExtra("bigImgPath", this.filePath);
                startActivity(intent);
            }
        }
        if (requestCode == 3001) {
            String musicName = data.getStringExtra("musicName");
            if (!TextUtils.isEmpty(musicName)) {
                this.mImageMusic.setVisibility(0);
                this.musicPathName = musicName;
                showMusic(musicName);
            }
        }
        if (requestCode == 3) {
            String hideInform = data.getStringExtra(HideInfoActivity.EK_HIDE_INFOS);
            if (!TextUtils.isEmpty(hideInform)) {
                List<HideInfo> mineHideInformBeans = (List) new Gson().fromJson(hideInform, new TypeToken<List<HideInfo>>() {
                }.getType());
                if (mineHideInformBeans == null || mineHideInformBeans.size() <= 0) {
                    this.mHideInformBeans.clear();
                } else {
                    this.mHideInformBeans.clear();
                    this.mHideInformBeans.addAll(mineHideInformBeans);
                }
            } else {
                this.mHideInformBeans.clear();
            }
            PLCylindricalPanorama cylindricalPanorama = new PLCylindricalPanorama();
            cylindricalPanorama.setHeight(1.0f);
            cylindricalPanorama.getCamera().setPitchRange(0.0f, 0.0f);
            cylindricalPanorama.setImage(new PLImage(this.mShowBitmap, false));
            for (int i = 0; i < this.mHideInformBeans.size(); i++) {
                HideInfo bean = (HideInfo) this.mHideInformBeans.get(i);
                float showY = ((this.bitmapHalfY - (((float) bean.getPoint().y) / this.yS)) * 24.0f) / 256.0f;
                cylindricalPanorama.addHotspot(new PLHotspot((long) i, (PLIImage) new PLImage(PLUtils.getBitmap((Context) this, (int) R.mipmap.hide_point)), showY, (((((float) bean.getPoint().x) / this.xS) - this.bitmapHalfX) * 180.0f) / 512.0f, 0.03f, 0.03f));
            }
            setPanorama(cylindricalPanorama);
        }
    }

    public void onBackClick(View view) {
        finish();
    }

    public void onSaveShareClick(View view) {
        saveShareWorkData();
    }

    private void saveShareWorkData() {
        String imagePath;
        SaveShareDataBean bean = new SaveShareDataBean();
        if ("pano".equals(this.filePath.substring(0, 4))) {
            imagePath = FileUtils.getPanoDir() + CookieSpec.PATH_DELIM + this.filePath;
        } else {
            imagePath = this.filePath;
        }
        String type = imagePath.substring(imagePath.lastIndexOf(CookieSpec.PATH_DELIM) + 1, imagePath.length() - 4);
        bean.setPhotoImagPath(imagePath);
        bean.setMusicName(this.musicPathName);
        bean.setHideInform(new Gson().toJson((Object) this.mHideInformBeans));
        if (this.shareInformManage.getSaveDataFromDB(type) == null) {
            this.shareInformManage.saveNewsToDB(bean, type);
        } else if (this.shareInformManage.deleteTableData(type)) {
            this.shareInformManage.saveNewsToDB(bean, type);
        } else {
            ToastFactory.getToast((Context) this, "保存分享失败，请稍后再试").show();
        }
        Intent intent = new Intent(this, SaveShareActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("saveShareData", bean);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void musicClick(View view) {
        if (this.mediaPlayer == null) {
            return;
        }
        if (this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
            this.mImageMusic.setImageResource(R.mipmap.play_music);
            return;
        }
        this.mediaPlayer.start();
        this.mImageMusic.setImageResource(R.mipmap.pause_music);
    }

    private void showMusic(String musicName) {
        try {
            AssetFileDescriptor afd = getAssets().openFd("ogg/" + musicName);
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            this.mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.mShowBitmap != null && !this.mShowBitmap.isRecycled()) {
            this.mShowBitmap.recycle();
            this.mShowBitmap = null;
        }
        ImageTaker.INSTANCE.clearTemp();
        if (this.mediaPlayer != null) {
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        super.onDestroy();
    }
}
