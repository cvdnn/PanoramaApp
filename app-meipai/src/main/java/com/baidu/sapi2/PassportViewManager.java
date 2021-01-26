package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import com.baidu.sapi2.callback.TitleBtnCallback;
import e.c.c.a.b;
import e.c.c.a.c;
import e.c.c.a.d;

public class PassportViewManager implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static SapiConfiguration f2174a;

    /* renamed from: b reason: collision with root package name */
    public static PassportViewManager f2175b;

    /* renamed from: c reason: collision with root package name */
    public TitleBtnCallback f2176c;

    /* renamed from: d reason: collision with root package name */
    public TitleViewModule f2177d = null;

    public static class TitleViewModule implements NoProguard {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.f2174a.context.getResources().getColor(b.sapi_sdk_edit_text_color);
        public int bgColor = Integer.MAX_VALUE;
        public int bgHeight = Integer.MAX_VALUE;
        public int dividerLineVisible = 0;
        public Drawable leftBtnDrawableBottom = null;
        public Drawable leftBtnDrawableLeft = null;
        public Drawable leftBtnDrawableRight = null;
        public Drawable leftBtnDrawableTop = null;
        public int leftBtnImgResId = Integer.MAX_VALUE;
        public int leftBtnImgVisible = 0;
        public String leftBtnText = null;
        public int leftBtnTextColor = DEFAULT_TEXT_COLOR;
        public float leftBtnTextSize = PassportViewManager.f2174a.context.getResources().getDimension(c.sapi_sdk_title_left_btn_text_size);
        public int leftBtnTextVisible = 4;
        public String rightBtnText = null;
        public int rightBtnTextColor = DEFAULT_TEXT_COLOR;
        public float rightBtnTextSize = PassportViewManager.f2174a.context.getResources().getDimension(c.sapi_sdk_title_right_btn_text_size);
        public int rightBtnVisible = 4;
        public Drawable titleDrawableBottom = null;
        public Drawable titleDrawableLeft = null;
        public Drawable titleDrawableRight = null;
        public Drawable titleDrawableTop = null;
        public String titleText = null;
        public boolean titleTextBold = false;
        public int titleTextColor = DEFAULT_TEXT_COLOR;
        public float titleTextSize = PassportViewManager.f2174a.context.getResources().getDimension(c.sapi_sdk_title_text_size);
        public int titleVisible = 0;
        public boolean useWebviewTitle = true;
    }

    public PassportViewManager() {
        f2174a = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        PassportViewManager passportViewManager;
        synchronized (PassportViewManager.class) {
            if (f2175b == null) {
                f2175b = new PassportViewManager();
            }
            passportViewManager = f2175b;
        }
        return passportViewManager;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        this.f2177d = titleViewModule;
        if (titleViewModule.bgColor == Integer.MAX_VALUE) {
            titleViewModule.bgColor = -1;
        }
        if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
            titleViewModule.leftBtnImgResId = d.sapi_sdk_btn_back;
        }
    }

    public TitleBtnCallback getTitleBtnCallback() {
        return this.f2176c;
    }

    public TitleViewModule getTitleViewModule() {
        return this.f2177d;
    }

    public void release() {
        this.f2176c = null;
        this.f2177d = null;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.f2176c = titleBtnCallback;
    }
}
