package com.deepai.paipai.wxapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.deepai.library.support.net.HttpDownloader;
import com.deepai.paipai.R;
import com.deepai.paipai.support.bean.HideInfo;
import com.deepai.paipai.support.file.FileUtils;
import java.io.File;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class AddHideInformPopupWindow extends PopupWindow {
    private View conentView;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            AddHideInformPopupWindow.this.mediaPlayer = MediaPlayer.create((Context) msg.obj, Uri.fromFile(new File(FileUtils.getRecordDir() + "/temp.amr")));
            AddHideInformPopupWindow.this.playRecord();
        }
    };
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    private TextView textView;

    public AddHideInformPopupWindow(final Activity context, final HideInfo hideInfoBean) {
        this.conentView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_custom_addhideinform, null);
        this.textView = (TextView) this.conentView.findViewById(R.id.text_add_hide_inform);
        setContentView(this.conentView);
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(0));
        if (hideInfoBean.getType() == 1) {
            this.textView.setText(hideInfoBean.getText());
            this.textView.setBackground(null);
        } else if (hideInfoBean.getType() == 2 || hideInfoBean.getType() == 3) {
            this.textView.setText("");
            this.textView.setBackground(context.getResources().getDrawable(R.mipmap.record_play));
            if (hideInfoBean.getType() == 2) {
                new Thread() {
                    public void run() {
                        if (new HttpDownloader().download(hideInfoBean.getRecordUrl(), FileUtils.getRecordDir() + CookieSpec.PATH_DELIM, "temp.amr") == 0) {
                            Message msg = AddHideInformPopupWindow.this.handler.obtainMessage();
                            msg.what = 0;
                            msg.obj = context;
                            AddHideInformPopupWindow.this.handler.sendMessage(msg);
                        }
                    }
                }.start();
            } else {
                this.mediaPlayer = MediaPlayer.create(context, Uri.fromFile(new File(hideInfoBean.getRecordUrlLocal())));
                playRecord();
            }
        }
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                if ((hideInfoBean.getType() == 2 || hideInfoBean.getType() == 3) && AddHideInformPopupWindow.this.mediaPlayer != null && AddHideInformPopupWindow.this.mediaPlayer.isPlaying()) {
                    AddHideInformPopupWindow.this.mediaPlayer.stop();
                    AddHideInformPopupWindow.this.mediaPlayer.release();
                    AddHideInformPopupWindow.this.mediaPlayer = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void playRecord() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.start();
            this.mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer arg0) {
                    AddHideInformPopupWindow.this.mediaPlayer.release();
                    AddHideInformPopupWindow.this.mediaPlayer = null;
                    AddHideInformPopupWindow.this.dismiss();
                }
            });
        }
    }

    public void showPopupWindow(View view, float w, float h) {
        showAtLocation(view, 0, ((int) w) - 30, ((int) h) + 60);
    }
}
