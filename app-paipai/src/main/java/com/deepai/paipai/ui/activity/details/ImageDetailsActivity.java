package com.deepai.paipai.ui.activity.details;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.Json2EntityPostRequest;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.library.support.utils.FormatUtil;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.library.ui.widget.BigIVJust360;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.support.bean.CommentShowBean;
import com.deepai.paipai.support.bean.DetailsInformBean;
import com.deepai.paipai.support.bean.HideInfo;
import com.deepai.paipai.support.bean.IndexPhotoBean;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.support.imageloader.UniversalImageLoadTool;
import com.deepai.paipai.support.net.NetConstants;
import com.deepai.paipai.support.photodeal.BitmapUtil;
import com.deepai.paipai.support.photodeal.ImageSplite;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.widget.CustomCommentShowView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONException;

public class ImageDetailsActivity extends PLView implements OnClickListener, OnEditorActionListener {
    /* access modifiers changed from: private */
    public String bitmapPath;
    /* access modifiers changed from: private */
    public BigIVJust360 bivImg;
    /* access modifiers changed from: private */
    public int commentNum;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (ImageDetailsActivity.this.mProgressBar != null && ImageDetailsActivity.this.mProgressBar.isShowing()) {
                    ImageDetailsActivity.this.mProgressBar.dismiss();
                }
                ImageDetailsActivity.this.mTextChangeImage.setClickable(true);
                ImageDetailsActivity.this.createPhotoView((String) msg.obj);
                if (ImageDetailsActivity.this.bitmapPath != null) {
                    File img = new File(ImageDetailsActivity.this.bitmapPath);
                    if (img.isFile() && img.exists()) {
                        ImageDetailsActivity.this.bivImg.setImage(ImageDetailsActivity.this.bitmapPath);
                    }
                }
            } else if (msg.what == 1 && ImageDetailsActivity.this.mProgressBar != null && ImageDetailsActivity.this.mProgressBar.isShowing()) {
                ImageDetailsActivity.this.mProgressBar.dismiss();
            }
        }
    };
    private boolean isBigDisplay;
    /* access modifiers changed from: private */
    public boolean isPraise = false;
    /* access modifiers changed from: private */
    public CustomCommentShowView mCommentView;
    /* access modifiers changed from: private */
    public EditText mEditComment;
    /* access modifiers changed from: private */
    public List<HideInfo> mHideInformBeans;
    private ImageView mImageHead;
    private ImageView mImageMusic;
    /* access modifiers changed from: private */
    public LinearLayout mLinearPhoto;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressBar;
    /* access modifiers changed from: private */
    public Bitmap mShowBitmap;
    /* access modifiers changed from: private */
    public TextView mTextChangeImage;
    /* access modifiers changed from: private */
    public TextView mTextComment;
    private TextView mTextContent;
    private TextView mTextName;
    /* access modifiers changed from: private */
    public PopupWindow mTextPopup;
    private TextView mTextPublish;
    private TextView mTextTime;
    /* access modifiers changed from: private */
    public TextView mTextZan;
    private TextView mTvAutoPlay;
    private MediaPlayer mediaPlayer;
    private String myContentShow = "";
    private String photoId;
    /* access modifiers changed from: private */
    public int praiseNum;
    /* access modifiers changed from: private */
    public float xS;
    /* access modifiers changed from: private */
    public float yS;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListener(new PLViewListener() {
            public void onDidClickHotspot(PLIView view, PLIHotspot hotspot, CGPoint screenPoint, PLPosition scene3DPoint) {
                if (ImageDetailsActivity.this.mHideInformBeans == null || ImageDetailsActivity.this.mHideInformBeans.size() <= 0) {
                    ToastFactory.getToast((Context) view.getActivity(), "暂无隐藏信息").show();
                    return;
                }
                new AddHideInformPopupWindow(ImageDetailsActivity.this, (HideInfo) ImageDetailsActivity.this.mHideInformBeans.get((int) hotspot.getIdentifier())).showPopupWindow(ImageDetailsActivity.this.mLinearPhoto, screenPoint.x, (screenPoint.y / 3.0f) * 4.0f);
            }
        });
        getBundleData();
    }

    private void getBundleData() {
        IndexPhotoBean bean = (IndexPhotoBean) getIntent().getExtras().getSerializable("detailsData");
        if (bean != null) {
            workDetailsView(bean);
        }
    }

    /* access modifiers changed from: private */
    public void createPhotoView(String hide) {
        PLCylindricalPanorama cylindricalPanorama = new PLCylindricalPanorama();
        cylindricalPanorama.setHeight(1.0f);
        cylindricalPanorama.getCamera().setPitchRange(0.0f, 0.0f);
        cylindricalPanorama.setImage(new PLImage(this.mShowBitmap, false));
        if (!TextUtils.isEmpty(hide)) {
            this.mHideInformBeans = (List) new Gson().fromJson(hide, new TypeToken<List<HideInfo>>() {
            }.getType());
            if (this.mHideInformBeans != null && this.mHideInformBeans.size() > 0) {
                float bitmapHalfX = ((float) this.mShowBitmap.getWidth()) / 2.0f;
                float bitmapHalfY = ((float) this.mShowBitmap.getHeight()) / 2.0f;
                for (int i = 0; i < this.mHideInformBeans.size(); i++) {
                    HideInfo bean = (HideInfo) this.mHideInformBeans.get(i);
                    float showY = ((bitmapHalfY - (((float) bean.getPoint().y) / this.yS)) * 24.0f) / 256.0f;
                    PLCylindricalPanorama pLCylindricalPanorama = cylindricalPanorama;
                    pLCylindricalPanorama.addHotspot(new PLHotspot((long) i, (PLIImage) new PLImage(PLUtils.getBitmap((Context) this, (int) R.mipmap.hide_point)), showY, (((((float) bean.getPoint().x) / this.xS) - bitmapHalfX) * 180.0f) / 512.0f, 0.03f, 0.03f));
                }
            }
        }
        setPanorama(cylindricalPanorama);
    }

    /* access modifiers changed from: protected */
    public View onContentViewCreated(View contentView) {
        ViewGroup mainView = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_image_details, null);
        this.mLinearPhoto = (LinearLayout) mainView.findViewById(R.id.linear_details_image_show);
        this.mLinearPhoto.addView(contentView, 0);
        initDetailsView(mainView);
        return super.onContentViewCreated(mainView);
    }

    private void initDetailsView(ViewGroup viewGroup) {
        this.mImageHead = (ImageView) viewGroup.findViewById(R.id.image_details_head);
        this.mTextName = (TextView) viewGroup.findViewById(R.id.text_details_head);
        this.mTextTime = (TextView) viewGroup.findViewById(R.id.text_details_head_time);
        this.mTextContent = (TextView) viewGroup.findViewById(R.id.text_details_content);
        this.mTextComment = (TextView) viewGroup.findViewById(R.id.text_details_comment);
        this.mTextZan = (TextView) viewGroup.findViewById(R.id.text_details_zan);
        this.mTextPublish = (TextView) viewGroup.findViewById(R.id.text_details_comment_publish);
        this.mCommentView = (CustomCommentShowView) viewGroup.findViewById(R.id.custom_comment_show);
        this.mImageMusic = (ImageButton) viewGroup.findViewById(R.id.image_details_music);
        this.mTextChangeImage = (TextView) viewGroup.findViewById(R.id.text_details_change_image);
        this.bivImg = (BigIVJust360) viewGroup.findViewById(R.id.biv_show_img);
        this.bivImg.setDrawableOverlay(false);
        this.mTextChangeImage.setClickable(false);
        this.mTvAutoPlay = (TextView) viewGroup.findViewById(R.id.tv_details_auto_play);
    }

    private void workDetailsView(IndexPhotoBean bean) {
        String headUrl;
        this.mProgressBar = new ProgressDialog(this);
        this.mProgressBar.setProgressStyle(0);
        this.mProgressBar.setMessage("正在加载图片中，请稍后...");
        this.mProgressBar.setIndeterminate(false);
        this.mProgressBar.setCancelable(true);
        this.mProgressBar.show();
        this.photoId = bean.getId();
        if (!TextUtils.isEmpty(this.photoId)) {
            getCommentData();
        }
        String imageHead = bean.getHeadimgurl();
        if (!TextUtils.isEmpty(imageHead)) {
            if (imageHead.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                headUrl = imageHead;
            } else {
                headUrl = "http://www.paipai360.cn/paipai360" + imageHead;
            }
            UniversalImageLoadTool.disCirclePlay(headUrl, this.mImageHead, R.mipmap.image_moren_fang, this);
        }
        this.mTextName.setText(bean.getNickname());
        this.mTextTime.setText(bean.getHowLong());
        this.myContentShow = bean.getTitle();
        this.mTextContent.setText(this.myContentShow);
        String cNum = bean.getCommentnum();
        String pNum = bean.getPraisenum();
        if (!TextUtils.isEmpty(cNum)) {
            this.commentNum = Integer.parseInt(cNum);
        } else {
            this.commentNum = 0;
        }
        if (!TextUtils.isEmpty(pNum)) {
            this.praiseNum = Integer.parseInt(pNum);
        } else {
            this.praiseNum = 0;
        }
        this.mTextComment.setText(this.commentNum + "");
        this.mTextComment.setOnClickListener(this);
        this.mTextZan.setText(this.praiseNum + "");
        this.mTextZan.setOnClickListener(this);
        this.mTextPublish.setOnClickListener(this);
        showEditTextPopup(this);
        final String photoUrl = bean.getUrl();
        final String hideConntent = bean.getHidecontent();
        if (!TextUtils.isEmpty(photoUrl)) {
            new Thread(new Runnable() {
                public void run() {
                    if (BitmapUtil.getNetImage("http://www.paipai360.cn/paipai360" + photoUrl, FileUtils.getImageCacheDir() + "/details_image")) {
                        ImageDetailsActivity.this.bitmapPath = FileUtils.getImageCacheDir() + "/details_image" + photoUrl.substring(photoUrl.lastIndexOf("."));
                        ImageDetailsActivity.this.mShowBitmap = BitmapUtil.getBitmapFromFile(ImageDetailsActivity.this.bitmapPath, ImageDetailsActivity.this);
                        if (ImageDetailsActivity.this.mShowBitmap != null) {
                            ImageDetailsActivity.this.xS = ((float) ImageDetailsActivity.this.mShowBitmap.getWidth()) / 1024.0f;
                            ImageDetailsActivity.this.yS = ((float) ImageDetailsActivity.this.mShowBitmap.getHeight()) / 512.0f;
                            ImageDetailsActivity.this.mShowBitmap = ImageSplite.zoomImg(ImageDetailsActivity.this.mShowBitmap, 1024, 512);
                            Message message = ImageDetailsActivity.this.handler.obtainMessage(0);
                            message.obj = hideConntent;
                            ImageDetailsActivity.this.handler.sendMessage(message);
                            return;
                        }
                        return;
                    }
                    ImageDetailsActivity.this.handler.sendEmptyMessage(1);
                }
            }).start();
        } else if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
            this.mProgressBar.dismiss();
        }
        String musicInform = bean.getSongname();
        if (!TextUtils.isEmpty(musicInform) && !"null".equals(musicInform)) {
            if (!musicInform.contains("ogg")) {
                musicInform = musicInform + ".ogg";
            }
            this.mImageMusic.setVisibility(0);
            showMusic(musicInform);
        }
        this.isBigDisplay = true;
        this.mTextChangeImage.setOnClickListener(this);
        this.mTvAutoPlay.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void getCommentData() {
        Map<String, String> params = new HashMap<>();
        String token = AppSP.getToken(this, "").toString();
        params.put("id", this.photoId);
        params.put(RequestKey.TOKEN, token);
        PaiApp.vQueue.add(new Json2EntityPostRequest(NetConstants.DETAILS_COMMENT, params, new TypeToken<DetailsInformBean>() {
        }.getType(), new Listener<DetailsInformBean>() {
            public void onResponse(DetailsInformBean response) {
                if (response != null) {
                    String praise = response.getIfpraise();
                    if (!TextUtils.isEmpty(praise)) {
                        int flag = Integer.parseInt(praise);
                        if (flag == 1) {
                            ImageDetailsActivity.this.isPraise = false;
                        } else if (flag == 0) {
                            ImageDetailsActivity.this.isPraise = true;
                        }
                    }
                    List<CommentShowBean> list = response.getCommentList();
                    if (list != null && list.size() > 0) {
                        ImageDetailsActivity.this.mCommentView.setViewData(list);
                    }
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }));
    }

    /* access modifiers changed from: private */
    public void publishComment() {
        String token = AppSP.getToken(this, "").toString();
        String strContent = this.mEditComment.getText().toString().trim();
        if (!TextUtils.isEmpty(strContent)) {
            String content = strContent;
            Map<String, String> params = new HashMap<>();
            params.put(RequestKey.TOKEN, token);
            params.put("pictureid", this.photoId);
            params.put("content", content);
            PaiApp.vQueue.add(new StringPostRequest(NetConstants.PUBLISH_COMMENT, params, new Listener<String>() {
                public void onResponse(String response) {
                    try {
                        if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                            ImageDetailsActivity.this.getCommentData();
                            ImageDetailsActivity.this.commentNum = ImageDetailsActivity.this.commentNum + 1;
                            ImageDetailsActivity.this.mTextComment.setText(ImageDetailsActivity.this.commentNum + "");
                            ImageDetailsActivity.this.mEditComment.setText("");
                            ToastFactory.getToast((Context) ImageDetailsActivity.this, "评论成功").show();
                            ImageDetailsActivity.this.mTextPopup.dismiss();
                            return;
                        }
                        ToastFactory.getToast((Context) ImageDetailsActivity.this, "评论失败").show();
                        ImageDetailsActivity.this.mTextPopup.dismiss();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        ImageDetailsActivity.this.mTextPopup.dismiss();
                        ToastFactory.getToast((Context) ImageDetailsActivity.this, "评论失败").show();
                    }
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    ImageDetailsActivity.this.mEditComment.setText("");
                    Toast.makeText(ImageDetailsActivity.this, "服务器正忙，请稍候再试", 0).show();
                    ImageDetailsActivity.this.mTextPopup.dismiss();
                }
            }));
            return;
        }
        ToastFactory.getToast((Context) this, "请输入评论内容").show();
    }

    private void workPraise() {
        String token = AppSP.getToken(this, "").toString();
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.TOKEN, token);
        params.put("pictureid", this.photoId);
        PaiApp.vQueue.add(new StringPostRequest(NetConstants.DETAILS_PRAISE, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        ImageDetailsActivity.this.isPraise = true;
                        ImageDetailsActivity.this.praiseNum = ImageDetailsActivity.this.praiseNum + 1;
                        ImageDetailsActivity.this.mTextZan.setText(ImageDetailsActivity.this.praiseNum + "");
                        ToastFactory.getToast((Context) ImageDetailsActivity.this, "点赞成功").show();
                        return;
                    }
                    ToastFactory.getToast((Context) ImageDetailsActivity.this, "点赞失败").show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    ToastFactory.getToast((Context) ImageDetailsActivity.this, "点赞失败").show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) ImageDetailsActivity.this, "点赞失败").show();
                } else {
                    ToastFactory.getToast((Context) ImageDetailsActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.bivImg.isPlaying()) {
            this.bivImg.stopPlay();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.mShowBitmap != null && !this.mShowBitmap.isRecycled()) {
            this.mShowBitmap.recycle();
            this.mShowBitmap = null;
        }
        if (this.mediaPlayer != null) {
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        this.bivImg.release();
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View v) {
        String token = AppSP.getToken(this, "").toString();
        switch (v.getId()) {
            case R.id.text_details_change_image /*2131624085*/:
                onChangeImageClick();
                return;
            case R.id.tv_details_auto_play /*2131624086*/:
                if (this.mShowBitmap == null) {
                    return;
                }
                if (!this.bivImg.isPlaying()) {
                    this.bivImg.startPlay();
                    this.mTvAutoPlay.setText(R.string.auto_play_stop);
                    return;
                }
                this.bivImg.stopPlay();
                this.mTvAutoPlay.setText(R.string.auto_play_start);
                return;
            case R.id.text_details_comment /*2131624087*/:
            case R.id.text_details_comment_publish /*2131624090*/:
                if (!TextUtils.isEmpty(token)) {
                    this.mTextPopup.showAtLocation(this.mTextPublish, 80, 0, 24);
                    popupInputMethodWindow();
                    return;
                }
                ToastFactory.getToast((Context) this, "请登录后再进行评论").show();
                return;
            case R.id.text_details_zan /*2131624088*/:
                if (TextUtils.isEmpty(token)) {
                    ToastFactory.getToast((Context) this, "请登录后再进行点赞").show();
                    return;
                } else if (!this.isPraise) {
                    workPraise();
                    return;
                } else {
                    ToastFactory.getToast((Context) this, "已点过赞").show();
                    return;
                }
            default:
                return;
        }
    }

    public void onChangeImageClick() {
        if (this.mShowBitmap != null) {
            if (this.isBigDisplay) {
                this.mTextChangeImage.setText(R.string.show_big_img);
                this.bivImg.setVisibility(4);
                this.mTvAutoPlay.setText(R.string.auto_play_start);
                this.mTvAutoPlay.setVisibility(4);
                this.bivImg.stopPlay();
                this.mLinearPhoto.setVisibility(0);
                this.isBigDisplay = false;
                return;
            }
            this.mTextChangeImage.setText(R.string.show_fish_eye_img);
            this.bivImg.setVisibility(0);
            this.mTvAutoPlay.setVisibility(0);
            this.mLinearPhoto.setVisibility(4);
            this.isBigDisplay = true;
        }
    }

    public void musicDetailClick(View view) {
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

    public void onDetailBackClick(View view) {
        onBackPressed();
    }

    private void showEditTextPopup(final Context context) {
        if (this.mTextPopup == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_edit_comment_input, null, false);
            this.mTextPopup = new PopupWindow(view);
            this.mTextPopup.setWidth(-1);
            this.mTextPopup.setHeight(-2);
            this.mTextPopup.setOutsideTouchable(false);
            this.mTextPopup.setFocusable(true);
            this.mTextPopup.setBackgroundDrawable(new BitmapDrawable());
            this.mTextPopup.setSoftInputMode(16);
            this.mEditComment = (EditText) view.findViewById(R.id.et_comment_input_text);
            TextView btnAdd = (TextView) view.findViewById(R.id.tv_btn_publish_comment);
            this.mEditComment.setOnEditorActionListener(this);
            btnAdd.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (TextUtils.isEmpty(ImageDetailsActivity.this.mEditComment.getText().toString())) {
                        ToastFactory.getToast(context, (int) R.string.comment_edit_input).show();
                    } else {
                        ImageDetailsActivity.this.publishComment();
                    }
                }
            });
        }
    }

    private void popupInputMethodWindow() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) ImageDetailsActivity.this.getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        }, 0);
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (!TextUtils.isEmpty(AppSP.getToken(this, "").toString())) {
            publishComment();
        } else {
            ToastFactory.getToast((Context) this, "请登录后再进行评论").show();
        }
        return false;
    }
}
