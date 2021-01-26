package com.deepai.paipai.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.deepai.library.support.net.HttpDownloader;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.library.ui.gesture.ClickGestureDetector;
import com.deepai.library.ui.gesture.ClickGestureDetector.OnClickGestureListener;
import com.deepai.library.ui.gesture.LongPressGestureDetector;
import com.deepai.library.ui.gesture.LongPressGestureDetector.OnLongPressGestureListener;
import com.deepai.library.ui.gesture.MoveGestureDetector;
import com.deepai.library.ui.gesture.MoveGestureDetector.SimpleOnMoveGestureListener;
import com.deepai.library.ui.widget.BigImageView;
import com.deepai.library.ui.widget.BigImageView.OnOverlayClickListener;
import com.deepai.library.ui.widget.BigImageView.Overlay;
import com.deepai.paipai.R;
import com.deepai.paipai.support.bean.HideInfo;
import com.deepai.paipai.support.file.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class AddHideInfoView extends RelativeLayout {
    private static final String TAG = "AddHideInfoView";
    /* access modifiers changed from: private */
    public BigImageView bigImageView;
    /* access modifiers changed from: private */
    public View btnView;
    /* access modifiers changed from: private */
    public String currentRecordPath;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            AddHideInfoView.this.mediaPlayer = MediaPlayer.create((Context) msg.obj, Uri.fromFile(new File(FileUtils.getRecordDir() + "/temp.amr")));
            AddHideInfoView.this.playRecord();
        }
    };
    private ClickGestureDetector mClickDetector;
    private boolean mClickable = true;
    /* access modifiers changed from: private */
    public PopupWindow mContentPopup;
    /* access modifiers changed from: private */
    public List<HideInfo> mHideInfos;
    /* access modifiers changed from: private */
    public OnHideInfoChangeListener mInfoChangeListener;
    private LongPressGestureDetector mLongPressDetector;
    private MoveGestureDetector mMoveDetector;
    /* access modifiers changed from: private */
    public PopupWindow mRecordPopup;
    /* access modifiers changed from: private */
    public PopupWindow mTextPopup;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public MediaRecorder recorder;

    public interface OnHideInfoChangeListener {
        void onHideInfoChange(List<HideInfo> list);
    }

    public AddHideInfoView(Context context) {
        super(context);
        init(context);
    }

    public AddHideInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AddHideInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        addImage(context);
        initBtn(context);
        initEvent(context);
        this.mHideInfos = new ArrayList();
    }

    private void addImage(final Context context) {
        this.bigImageView = new BigImageView(context);
        this.bigImageView.setLayoutParams(new LayoutParams(-1, -1));
        this.bigImageView.setDrawableOverlay(true);
        this.bigImageView.setOnOverlayClickListener(new OnOverlayClickListener() {
            public void onOverlayClick(int position, Overlay overlay) {
                final HideInfo hideInfo = (HideInfo) AddHideInfoView.this.mHideInfos.get(position);
                switch (hideInfo.getType()) {
                    case 0:
                        ToastFactory.getToast(context, "空的").show();
                        return;
                    case 1:
                        AddHideInfoView.this.showContentPopup(context, hideInfo.getText(), AddHideInfoView.this.getPointOnScreen(overlay), hideInfo.getType());
                        return;
                    case 2:
                    case 3:
                        AddHideInfoView.this.showContentPopup(context, hideInfo.getText(), AddHideInfoView.this.getPointOnScreen(overlay), hideInfo.getType());
                        if (hideInfo.getType() == 2) {
                            new Thread() {
                                public void run() {
                                    if (new HttpDownloader().download(hideInfo.getRecordUrl(), FileUtils.getRecordDir() + CookieSpec.PATH_DELIM, "temp.amr") == 0) {
                                        Message msg = AddHideInfoView.this.handler.obtainMessage();
                                        msg.what = 0;
                                        msg.obj = context;
                                        AddHideInfoView.this.handler.sendMessage(msg);
                                    }
                                }
                            }.start();
                            return;
                        } else if (hideInfo.getType() == 3) {
                            AddHideInfoView.this.mediaPlayer = MediaPlayer.create(context, Uri.fromFile(new File(hideInfo.getRecordUrlLocal())));
                            AddHideInfoView.this.playRecord();
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }

            public void onAddOverlayClick(Overlay overlay) {
                AddHideInfoView.this.mHideInfos.add(new HideInfo(overlay.getCenterPoint2Img()));
                if (AddHideInfoView.this.mInfoChangeListener != null) {
                    AddHideInfoView.this.mInfoChangeListener.onHideInfoChange(AddHideInfoView.this.mHideInfos);
                }
            }
        });
        addView(this.bigImageView);
    }

    /* access modifiers changed from: private */
    @NonNull
    public Point getPointOnScreen(Overlay overlay) {
        Point point = new Point();
        int[] location = new int[2];
        getLocationOnScreen(location);
        point.x = location[0] + ((int) overlay.getOverlayTopMidPointF2View().x);
        point.y = location[1] + ((int) overlay.getOverlayTopMidPointF2View().y);
        return point;
    }

    /* access modifiers changed from: private */
    public void playRecord() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.start();
            this.mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer arg0) {
                    if (AddHideInfoView.this.mediaPlayer != null) {
                        AddHideInfoView.this.mediaPlayer.release();
                        AddHideInfoView.this.mediaPlayer = null;
                    }
                    if (AddHideInfoView.this.mContentPopup != null) {
                        AddHideInfoView.this.mContentPopup.dismiss();
                    }
                }
            });
        }
    }

    private void initBtn(final Context context) {
        this.btnView = LayoutInflater.from(context).inflate(R.layout.layout_add_hide_button, this, false);
        this.btnView.setLayoutParams(new LayoutParams(-1, -1));
        this.btnView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            }
        });
        this.btnView.findViewById(R.id.iv_add_hide_text).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AddHideInfoView.this.showEditTextPopup(context);
                AddHideInfoView.this.btnView.setVisibility(8);
            }
        });
        this.btnView.findViewById(R.id.iv_add_hide_record).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AddHideInfoView.this.showRecordPopup(context);
                AddHideInfoView.this.btnView.setVisibility(8);
            }
        });
        addView(this.btnView);
    }

    /* access modifiers changed from: private */
    public void showEditTextPopup(final Context context) {
        if (this.mTextPopup == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_add_hide_edit_text, null, false);
            this.mTextPopup = new PopupWindow(view);
            this.mTextPopup.setWidth(-1);
            this.mTextPopup.setHeight(-2);
            this.mTextPopup.setOutsideTouchable(false);
            this.mTextPopup.setFocusable(true);
            this.mTextPopup.setSoftInputMode(16);
            final EditText editText = (EditText) view.findViewById(R.id.et_hide_text);
            ((TextView) view.findViewById(R.id.tv_btn_add_hide)).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (TextUtils.isEmpty(editText.getText().toString())) {
                        ToastFactory.getToast(context, (int) R.string.add_hide_tips_text_null).show();
                        return;
                    }
                    HideInfo hideInfo = (HideInfo) AddHideInfoView.this.mHideInfos.get(AddHideInfoView.this.mHideInfos.size() - 1);
                    if (hideInfo.getType() == 0) {
                        hideInfo.setText(editText.getText().toString());
                        editText.setText("");
                        AddHideInfoView.this.mTextPopup.dismiss();
                    }
                }
            });
        }
        this.mTextPopup.showAtLocation(this, 80, 0, 0);
        popupInputMethodWindow(context);
    }

    private void popupInputMethodWindow(final Context context) {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        }, 0);
    }

    /* access modifiers changed from: private */
    public void showRecordPopup(final Context context) {
        if (this.mRecordPopup == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_add_hide_record_btn, null, false);
            this.mRecordPopup = new PopupWindow(view);
            this.mRecordPopup.setWidth(-1);
            this.mRecordPopup.setHeight(-2);
            this.mRecordPopup.setOutsideTouchable(false);
            this.mRecordPopup.setFocusable(true);
            final ImageView ivRecordDB = (ImageView) view.findViewById(R.id.iv_record_db);
            view.findViewById(R.id.iv_btn_record).setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case 0:
                            AddHideInfoView.this.recorder = new MediaRecorder();
                            AddHideInfoView.this.recorder.setAudioSource(1);
                            AddHideInfoView.this.recorder.setOutputFormat(1);
                            AddHideInfoView.this.recorder.setAudioEncoder(1);
                            AddHideInfoView.this.currentRecordPath = AddHideInfoView.this.getRecordPath();
                            AddHideInfoView.this.recorder.setOutputFile(AddHideInfoView.this.currentRecordPath);
                            try {
                                AddHideInfoView.this.recorder.prepare();
                                AddHideInfoView.this.recorder.start();
                                ivRecordDB.setVisibility(0);
                                break;
                            } catch (Exception e) {
                                ToastFactory.getToast(context, "录制失败，请重新录制").show();
                                break;
                            }
                        case 1:
                            if (AddHideInfoView.this.recorder != null) {
                                try {
                                    AddHideInfoView.this.recorder.stop();
                                    HideInfo hideInfo = (HideInfo) AddHideInfoView.this.mHideInfos.get(AddHideInfoView.this.mHideInfos.size() - 1);
                                    if (hideInfo.getType() == 0) {
                                        hideInfo.setRecordUrlLocal(AddHideInfoView.this.currentRecordPath);
                                        AddHideInfoView.this.mRecordPopup.dismiss();
                                    }
                                    break;
                                } catch (RuntimeException stopException) {
                                    stopException.printStackTrace();
                                    File file = new File(AddHideInfoView.this.currentRecordPath);
                                    if (file.exists()) {
                                        file.delete();
                                        AddHideInfoView.this.currentRecordPath = null;
                                        ToastFactory.getToast(context, "录制失败，请重新录制").show();
                                    }
                                    break;
                                } finally {
                                    AddHideInfoView.this.recorder.reset();
                                    AddHideInfoView.this.recorder.release();
                                    AddHideInfoView.this.recorder = null;
                                    ivRecordDB.setVisibility(4);
                                }
                            }
                            break;
                    }
                    return true;
                }
            });
        }
        this.mRecordPopup.showAtLocation(this, 80, 0, 0);
    }

    /* access modifiers changed from: private */
    public String getRecordPath() {
        return FileUtils.getRecordDir() + CookieSpec.PATH_DELIM + System.currentTimeMillis() + ".amr";
    }

    /* access modifiers changed from: private */
    public void showContentPopup(Context context, String text, Point point, final int hideInfoType) {
        if (this.mContentPopup == null) {
            this.mContentPopup = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.layout_custom_addhideinform, null, false));
            this.mContentPopup.setWidth(-2);
            this.mContentPopup.setHeight(-2);
            this.mContentPopup.setBackgroundDrawable(new ColorDrawable(0));
            this.mContentPopup.setOutsideTouchable(false);
            this.mContentPopup.setFocusable(true);
        }
        TextView textView = (TextView) this.mContentPopup.getContentView().findViewById(R.id.text_add_hide_inform);
        if (hideInfoType == 1) {
            textView.setText(text);
            textView.setBackground(null);
        } else if (hideInfoType == 2 || hideInfoType == 3) {
            textView.setText("");
            textView.setBackground(context.getResources().getDrawable(R.mipmap.record_play));
        }
        this.mContentPopup.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                if ((hideInfoType == 2 || hideInfoType == 3) && AddHideInfoView.this.mediaPlayer != null && AddHideInfoView.this.mediaPlayer.isPlaying()) {
                    AddHideInfoView.this.mediaPlayer.stop();
                    AddHideInfoView.this.mediaPlayer.release();
                    AddHideInfoView.this.mediaPlayer = null;
                }
            }
        });
        this.mContentPopup.showAtLocation(this, 0, point.x, point.y);
    }

    private void initEvent(final Context context) {
        this.mMoveDetector = new MoveGestureDetector(context, new SimpleOnMoveGestureListener() {
            public boolean onMove(MoveGestureDetector detector) {
                AddHideInfoView.this.bigImageView.moveImg(detector);
                return true;
            }
        });
        this.mClickDetector = new ClickGestureDetector(context, new OnClickGestureListener() {
            public void onSingleClick(ClickGestureDetector detector) {
                int result = AddHideInfoView.this.bigImageView.addOverlay(detector.getPointF(), R.raw.hide_point);
                if (result == -2) {
                    ToastFactory.getToast(context, (int) R.string.add_hide_out_limit).show();
                } else if (result != -3 && result == -1) {
                    AddHideInfoView.this.btnView.setVisibility(0);
                }
            }
        });
        this.mLongPressDetector = new LongPressGestureDetector(context, new OnLongPressGestureListener() {
            public void onLongPressBegin(LongPressGestureDetector detector) {
                int index = AddHideInfoView.this.bigImageView.removeOverlay(detector.getPointF());
                if (index >= 0) {
                    AddHideInfoView.this.mHideInfos.remove(index);
                }
            }

            public void onLongPressEnd(LongPressGestureDetector detector) {
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.mMoveDetector.onTouchEvent(event);
        if (this.mClickable && event.getPointerCount() == 1) {
            this.mClickDetector.onTouchEvent(event);
        }
        this.mLongPressDetector.onTouchEvent(event);
        return true;
    }

    public void setImage(String filePath) {
        this.bigImageView.setImage(filePath);
    }

    public void setClickable(boolean clickable) {
        this.mClickable = clickable;
    }

    public void setHideInfos(List<HideInfo> hideInfos) {
        this.mHideInfos.addAll(hideInfos);
        List<Point> points = new ArrayList<>();
        for (HideInfo info : hideInfos) {
            points.add(info.getPoint());
        }
        this.bigImageView.addMultiOverlay(points, R.raw.hide_point);
    }

    public List<HideInfo> getHideInfos() {
        return this.mHideInfos;
    }

    public PointF getPointF2Img(PointF pointF) {
        return this.bigImageView.getPointF2Img(pointF);
    }

    public float getScaleRatio() {
        return this.bigImageView.getScaleRatio();
    }

    public void release() {
        this.bigImageView.release();
        this.mHideInfos.clear();
        if (this.mediaPlayer != null) {
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        if (this.recorder != null) {
            this.recorder.release();
            this.recorder = null;
        }
    }

    public void setOnHideInfoChangeListener(OnHideInfoChangeListener listener) {
        this.mInfoChangeListener = listener;
    }
}
