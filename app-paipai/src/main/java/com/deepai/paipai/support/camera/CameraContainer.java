package com.deepai.paipai.support.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.deepai.library.support.utils.BitmapUtil;
import com.deepai.paipai.R;
import com.deepai.paipai.support.camera.CameraView.FlashMode;
import com.deepai.paipai.support.file.FileOperateUtil;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.ui.widget.MyProgressView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CameraContainer extends RelativeLayout implements CameraOperation {
    public static final String TAG = "CameraContainer";
    /* access modifiers changed from: private */
    public final AutoFocusCallback autoFocusCallback = new AutoFocusCallback() {
        public void onAutoFocus(boolean success, Camera camera) {
            if (success) {
                CameraContainer.this.mFocusImageView.onFocusSuccess();
            } else {
                CameraContainer.this.mFocusImageView.onFocusFailed();
            }
        }
    };
    public CameraView mCameraView;
    /* access modifiers changed from: private */
    public DataHandler mDataHandler;
    /* access modifiers changed from: private */
    public FocusImageView mFocusImageView;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public TakePictureListener mListener;
    /* access modifiers changed from: private */
    public long mRecordStartTime;
    /* access modifiers changed from: private */
    public TextView mRecordingInfoTextView;
    /* access modifiers changed from: private */
    public String mSavePath;
    /* access modifiers changed from: private */
    public SimpleDateFormat mTimeFormat;
    private ImageView mWaterMarkImageView;
    /* access modifiers changed from: private */
    public SeekBar mZoomSeekBar;
    public MyProgressView myProgressView;
    int myT = 0;
    private final OnSeekBarChangeListener onSeekBarChangeListener = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            CameraContainer.this.mCameraView.setZoom(progress);
            CameraContainer.this.mHandler.removeCallbacksAndMessages(CameraContainer.this.mZoomSeekBar);
            CameraContainer.this.mHandler.postAtTime(new Runnable() {
                public void run() {
                    CameraContainer.this.mZoomSeekBar.setVisibility(8);
                }
            }, CameraContainer.this.mZoomSeekBar, SystemClock.uptimeMillis() + 2000);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private final PictureCallback pictureCallback = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            if (CameraContainer.this.mSavePath == null) {
                throw new RuntimeException("mSavePath is null");
            }
            if (CameraContainer.this.mDataHandler == null) {
                CameraContainer.this.mDataHandler = new DataHandler();
            }
            CameraContainer.this.mDataHandler.setMaxSize(500);
            Bitmap bm = CameraContainer.this.mDataHandler.save(data);
            camera.startPreview();
            if (CameraContainer.this.mListener != null) {
                CameraContainer.this.mListener.onTakePictureEnd(bm);
            }
        }
    };
    Runnable recordRunnable = new Runnable() {
        public void run() {
            if (CameraContainer.this.mCameraView.isRecording()) {
                CameraContainer.this.mRecordingInfoTextView.setText(CameraContainer.this.mTimeFormat.format(new Date(SystemClock.uptimeMillis() - CameraContainer.this.mRecordStartTime)));
                CameraContainer.this.mHandler.postAtTime(this, CameraContainer.this.mRecordingInfoTextView, SystemClock.uptimeMillis() + 500);
                MyProgressView myProgressView = CameraContainer.this.myProgressView;
                CameraContainer cameraContainer = CameraContainer.this;
                int i = cameraContainer.myT;
                cameraContainer.myT = i + 1;
                myProgressView.setNumAndMax(i, 57);
                return;
            }
            CameraContainer.this.mRecordingInfoTextView.setVisibility(8);
        }
    };

    private final class DataHandler {
        private String mImageFolder;
        private String mThumbnailFolder;
        private int maxSize = 500;

        public DataHandler() {
            this.mImageFolder = FileOperateUtil.getFolderPath(CameraContainer.this.getContext(), 1, CameraContainer.this.mSavePath);
            this.mThumbnailFolder = FileOperateUtil.getFolderPath(CameraContainer.this.getContext(), 2, CameraContainer.this.mSavePath);
            File folder = new File(this.mImageFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File folder2 = new File(this.mThumbnailFolder);
            if (!folder2.exists()) {
                folder2.mkdirs();
            }
        }

        public Bitmap save(byte[] data) {
            Log.d("", "保存图片");
            if (data != null) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(data, 0, data.length, options);
                options.inSampleSize = BitmapUtil.calculateInSampleSize(options);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Config.RGB_565;
                Bitmap bm = BitmapUtil.zoomImage(BitmapFactory.decodeByteArray(data, 0, data.length, options), PicStitcher.imgSize[0], PicStitcher.imgSize[1]);
                if (CameraConstants.savePictureFileNum % 1 == 0) {
                    try {
                        FileOutputStream fos = new FileOutputStream(new File(FileUtils.getPictureFileName(CameraConstants.savePictureFileNum / 1)));
                        fos.write(compress(bm).toByteArray());
                        fos.flush();
                        fos.close();
                        bm.recycle();
                    } catch (Exception e) {
                        Log.e(CameraContainer.TAG, e.toString());
                        Toast.makeText(CameraContainer.this.getContext(), "解析相机返回流失败", 0).show();
                    }
                }
            } else {
                Toast.makeText(CameraContainer.this.getContext(), "拍照失败，请重试", 0).show();
            }
            return null;
        }

        public Bitmap drawableToBitmap(Drawable drawable) {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        }

        public ByteArrayOutputStream compress(Bitmap bitmap) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 100, baos);
            int options = 99;
            while (baos.toByteArray().length / 1024 > this.maxSize) {
                options -= 3;
                if (options < 0) {
                    break;
                }
                Log.i(CameraContainer.TAG, (baos.toByteArray().length / 1024) + "");
                baos.reset();
                bitmap.compress(CompressFormat.JPEG, options, baos);
            }
            return baos;
        }

        public void setMaxSize(int maxSize2) {
            this.maxSize = maxSize2;
        }
    }

    public interface TakePictureListener {
        void onAnimtionEnd(Bitmap bitmap, boolean z);

        void onTakePictureEnd(Bitmap bitmap);
    }

    private final class TouchListener implements OnTouchListener {
        private static final int MODE_INIT = 0;
        private static final int MODE_ZOOM = 1;
        private int mode;
        private float startDis;

        private TouchListener() {
            this.mode = 0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction() & 255) {
                case 0:
                    this.mode = 0;
                    break;
                case 1:
                    if (this.mode == 1) {
                        CameraContainer.this.mHandler.postAtTime(new Runnable() {
                            public void run() {
                                CameraContainer.this.mZoomSeekBar.setVisibility(8);
                            }
                        }, CameraContainer.this.mZoomSeekBar, SystemClock.uptimeMillis() + 2000);
                        break;
                    } else {
                        Point point = new Point((int) event.getX(), (int) event.getY());
                        CameraContainer.this.mCameraView.onFocus(point, CameraContainer.this.autoFocusCallback);
                        CameraContainer.this.mFocusImageView.startFocus(point);
                        break;
                    }
                case 2:
                    if (this.mode == 1 && event.getPointerCount() >= 2) {
                        float endDis = distance(event);
                        int scale = (int) ((endDis - this.startDis) / 10.0f);
                        if (scale >= 1 || scale <= -1) {
                            int zoom = CameraContainer.this.mCameraView.getZoom() + scale;
                            if (zoom > CameraContainer.this.mCameraView.getMaxZoom()) {
                                zoom = CameraContainer.this.mCameraView.getMaxZoom();
                            }
                            if (zoom < 0) {
                                zoom = 0;
                            }
                            CameraContainer.this.mCameraView.setZoom(zoom);
                            CameraContainer.this.mZoomSeekBar.setProgress(zoom);
                            this.startDis = endDis;
                            break;
                        }
                    }
            }
            return true;
        }

        private float distance(MotionEvent event) {
            float dx = event.getX(1) - event.getX(0);
            float dy = event.getY(1) - event.getY(0);
            return (float) Math.sqrt((double) ((dx * dx) + (dy * dy)));
        }
    }

    public CameraContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        this.mHandler = new Handler();
        this.mTimeFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        setOnTouchListener(new TouchListener());
    }

    private void initView(Context context) {
        inflate(context, R.layout.camera_container, this);
        this.mCameraView = (CameraView) findViewById(R.id.cameraView);
        this.mFocusImageView = (FocusImageView) findViewById(R.id.focusImageView);
        this.mRecordingInfoTextView = (TextView) findViewById(R.id.recordInfo);
        this.mWaterMarkImageView = (ImageView) findViewById(R.id.waterMark);
        this.mZoomSeekBar = (SeekBar) findViewById(R.id.zoomSeekBar);
        int maxZoom = this.mCameraView.getMaxZoom();
        if (maxZoom > 0) {
            this.mZoomSeekBar.setMax(maxZoom);
            this.mZoomSeekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        }
    }

    public boolean startRecord() {
        this.mRecordStartTime = SystemClock.uptimeMillis();
        this.mRecordingInfoTextView.setText("00:00");
        if (!this.mCameraView.startRecord()) {
            return false;
        }
        this.mHandler.postAtTime(this.recordRunnable, this.mRecordingInfoTextView, SystemClock.uptimeMillis() + 1000);
        return true;
    }

    public Bitmap stopRecord(TakePictureListener listener) {
        this.mListener = listener;
        return stopRecord();
    }

    public Bitmap stopRecord() {
        this.mRecordingInfoTextView.setVisibility(8);
        Bitmap thumbnailBitmap = this.mCameraView.stopRecord();
        this.mListener.onAnimtionEnd(null, true);
        if (thumbnailBitmap != null) {
        }
        return thumbnailBitmap;
    }

    public void stopCamera() {
        this.mCameraView.stopCamera();
    }

    public void switchMode(int zoom) {
        this.mZoomSeekBar.setProgress(zoom);
        this.mCameraView.setZoom(zoom);
        this.mCameraView.onFocus(new Point(getWidth() / 2, getHeight() / 2), this.autoFocusCallback);
        this.mWaterMarkImageView.setVisibility(8);
    }

    public void setWaterMark() {
        if (this.mWaterMarkImageView.getVisibility() == 0) {
            this.mWaterMarkImageView.setVisibility(8);
        } else {
            this.mWaterMarkImageView.setVisibility(0);
        }
    }

    public void switchCamera() {
        this.mCameraView.switchCamera();
    }

    public FlashMode getFlashMode() {
        return this.mCameraView.getFlashMode();
    }

    public void setFlashMode(FlashMode flashMode) {
        this.mCameraView.setFlashMode(flashMode);
    }

    public void setRootPath(String rootPath) {
        this.mSavePath = rootPath;
    }

    public void takePicture() {
        takePicture(this.pictureCallback, this.mListener);
    }

    public void takePicture(TakePictureListener listener) {
        this.mListener = listener;
        takePicture(this.pictureCallback, this.mListener);
    }

    public void takePicture(PictureCallback callback, TakePictureListener listener) {
        this.mCameraView.takePicture(callback, listener);
    }

    public int getMaxZoom() {
        return this.mCameraView.getMaxZoom();
    }

    public void setZoom(int zoom) {
        this.mCameraView.setZoom(zoom);
    }

    public int getZoom() {
        return this.mCameraView.getZoom();
    }

    private int dip2px(float dipValue) {
        return (int) ((dipValue * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
