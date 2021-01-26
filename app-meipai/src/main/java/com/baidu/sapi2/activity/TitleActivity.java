package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.PassportViewManager.TitleViewModule;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.p;
import com.baidu.sapi2.utils.t;
import com.baidu.sapi2.views.ViewUtility;
import e.c.c.a.a;
import e.c.c.a.b;
import e.c.c.a.d;
import e.c.c.a.e;
import e.c.c.a.f;
import e.c.c.a.h;
import java.util.HashMap;
import java.util.Map;

public abstract class TitleActivity extends Activity implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public PassportViewManager f2691a;
    public View bottomBackView;
    public SapiConfiguration configuration;
    public View dividerLine;
    public boolean executeSubClassMethod = true;
    public ImageView mBottomBackBtnIv;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public TextView mLeftBtnTv;
    public Button mRightBtn;
    public ImageView mRightBtnClose;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;
    public RelativeLayout mTitleLayout;
    public TitleBtnCallback titleBtnCallback;
    public boolean useTitle = true;

    public TitleActivity() {
        PassportViewManager instance = PassportViewManager.getInstance();
        this.f2691a = instance;
        this.titleBtnCallback = instance.getTitleBtnCallback();
        this.configuration = SapiAccountManager.getInstance().getConfignation();
    }

    private void a(boolean z) {
        SapiConfiguration sapiConfiguration = this.configuration;
        int i2 = sapiConfiguration.activityOpenAnimId;
        int i3 = sapiConfiguration.activityExitAnimId;
        SapiWebDTO webDTO = getWebDTO();
        if (webDTO != null) {
            int i4 = webDTO.openEnterAnimId;
            if (i4 != 0) {
                i2 = i4;
            }
        }
        if (webDTO != null) {
            int i5 = webDTO.closeExitAnimId;
            if (i5 != 0) {
                i3 = i5;
            }
        }
        if (i2 == 0) {
            i2 = a.sapi_sdk_slide_right_in;
        }
        if (i3 == 0) {
            i3 = a.sapi_sdk_slide_right_out;
        }
        if (z) {
            int i6 = a.sapi_sdk_slide_left_out;
            if (webDTO != null) {
                int i7 = webDTO.openExitAnimId;
                if (i7 != 0) {
                    i6 = i7;
                }
            }
            overridePendingTransition(i2, i6);
            return;
        }
        int i8 = a.sapi_sdk_slide_left_in;
        if (webDTO != null) {
            int i9 = webDTO.closeEnterAnimId;
            if (i9 != 0) {
                i8 = i9;
            }
        }
        overridePendingTransition(i8, i3);
    }

    public void configCustomTitle() {
        TitleViewModule titleViewModule = this.f2691a.getTitleViewModule();
        if (titleViewModule != null) {
            setTitleLayoutBg(titleViewModule.bgColor);
            setTitleLayoutHeight(titleViewModule.bgHeight);
            setLeftBtnImage(titleViewModule.leftBtnImgResId);
            setLeftBtnImgVisible(titleViewModule.leftBtnImgVisible);
            setLeftBtnTextVisible(titleViewModule.leftBtnTextVisible);
            setLeftBtnTextColor(titleViewModule.leftBtnTextColor);
            setLeftBtnText(titleViewModule.leftBtnText);
            setLeftBtnTextSize((float) SapiUtils.px2sp(this, titleViewModule.leftBtnTextSize));
            setLeftBtnDrawable(titleViewModule.leftBtnDrawableLeft, titleViewModule.leftBtnDrawableTop, titleViewModule.leftBtnDrawableRight, titleViewModule.leftBtnDrawableBottom);
            setTitleVisible(titleViewModule.titleVisible);
            setTitleText(titleViewModule.titleText);
            setTitleTextColor(titleViewModule.titleTextColor);
            setTitleTextSize((float) SapiUtils.px2sp(this, titleViewModule.titleTextSize));
            setTitleDrawable(titleViewModule.titleDrawableLeft, titleViewModule.titleDrawableTop, titleViewModule.titleDrawableRight, titleViewModule.titleDrawableBottom);
            setTitleTextBold(titleViewModule.titleTextBold);
            setRightBtnVisible(titleViewModule.rightBtnVisible);
            setRightBtnText(titleViewModule.rightBtnText);
            setRightBtnTextSize((float) SapiUtils.px2sp(this, titleViewModule.rightBtnTextSize));
            setRightBtnColor(titleViewModule.rightBtnTextColor);
            this.dividerLine.setVisibility(titleViewModule.dividerLineVisible);
        }
        switchDarkmode();
        if (this.configuration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    public void configTitle() {
        if (this.configuration.customActionBarEnabled) {
            configCustomTitle();
        } else {
            setTitleLayoutVisible(8);
        }
    }

    public void finish() {
        super.finish();
        a(false);
    }

    public SapiWebDTO getWebDTO() {
        return null;
    }

    public void init() {
        a(true);
    }

    public void onBottomBackBtnClick() {
    }

    public void onClick(View view) {
        if (view == this.mLeftBtnIv || view == this.mLeftBtnTv) {
            onLeftBtnClick();
        } else if (view == this.mRightBtn) {
            onRightBtnClick();
        } else if (view == this.mBottomBackBtnIv) {
            onBottomBackBtnClick();
        } else if (view == this.mRightBtnClose) {
            onTitleRightBtnClick();
        }
    }

    public void onClose() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration.isDarkMode) {
            setTheme(h.SDKDarkTheme);
        } else if (sapiConfiguration.isNightMode) {
            setTheme(h.SDKNightTheme);
        }
    }

    public void onLeftBtnClick() {
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onRightBtnClick() {
        TitleBtnCallback titleBtnCallback2 = this.titleBtnCallback;
        if (titleBtnCallback2 != null) {
            titleBtnCallback2.onRightClick();
        }
    }

    public void onTitleRightBtnClick() {
        onClose();
    }

    public void reportWebviewError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.f3014b, Log.getStackTraceString(th));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put("os_version", VERSION.RELEASE);
        t.a("webview_init_error", (Map<String, String>) hashMap);
    }

    public void setBtnVisibility(int i2, int i3, int i4) {
        TextView textView = this.mLeftBtnTv;
        if (textView != null) {
            textView.setVisibility(i2);
        }
        ImageView imageView = this.mLeftBtnIv;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
        Button button = this.mRightBtn;
        if (button != null) {
            button.setVisibility(i4);
        }
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mLeftBtnTv.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setLeftBtnImage(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            this.mLeftBtnIv.setImageResource(i2);
        }
    }

    public void setLeftBtnImgVisible(int i2) {
        this.mLeftBtnIv.setVisibility(i2);
    }

    public void setLeftBtnLayoutVisible(int i2) {
        this.mLeftBtnLayout.setVisibility(i2);
    }

    public void setLeftBtnText(String str) {
        this.mLeftBtnTv.setText(str);
    }

    public void setLeftBtnTextColor(int i2) {
        this.mLeftBtnTv.setTextColor(i2);
    }

    public void setLeftBtnTextSize(float f2) {
        this.mLeftBtnTv.setTextSize(f2);
    }

    public void setLeftBtnTextVisible(int i2) {
        this.mLeftBtnTv.setVisibility(i2);
    }

    public void setRightBtnColor(int i2) {
        this.mRightBtn.setTextColor(i2);
    }

    public void setRightBtnText(String str) {
        this.mRightBtn.setText(str);
    }

    public void setRightBtnTextSize(float f2) {
        this.mRightBtn.setTextSize(f2);
    }

    public void setRightBtnVisible(int i2) {
        this.mRightBtn.setVisibility(i2);
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mTitle.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setTitleLayoutBg(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            this.mTitleBgLayout.setBackgroundColor(i2);
        }
    }

    public void setTitleLayoutHeight(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            LayoutParams layoutParams = this.mTitleLayout.getLayoutParams();
            layoutParams.height = i2;
            this.mTitleLayout.setLayoutParams(layoutParams);
        }
    }

    public void setTitleLayoutVisible(int i2) {
        this.mTitleLayout.setVisibility(i2);
    }

    public void setTitleText(String str) {
        TitleViewModule titleViewModule = this.f2691a.getTitleViewModule();
        if (titleViewModule != null) {
            if (!titleViewModule.useWebviewTitle) {
                this.mTitle.setText(titleViewModule.titleText);
            } else if (!TextUtils.isEmpty(str)) {
                this.mTitle.setText(str);
            }
        } else if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void setTitleTextBold(boolean z) {
        this.mTitle.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }

    public void setTitleTextColor(int i2) {
        this.mTitle.setTextColor(i2);
    }

    public void setTitleTextSize(float f2) {
        this.mTitle.setTextSize(f2);
    }

    public void setTitleVisible(int i2) {
        this.mTitle.setVisibility(i2);
    }

    public void setupViews() {
        ViewUtility.enableStatusBarTint(this, -1);
        View childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        if (this.useTitle) {
            this.mTitle = (TextView) findViewById(e.title);
            this.mLeftBtnLayout = (LinearLayout) findViewById(e.title_left_btn_layout);
            this.mLeftBtnTv = (TextView) findViewById(e.title_btn_left_tv);
            this.mLeftBtnIv = (ImageView) findViewById(e.title_btn_left_iv);
            this.mRightBtn = (Button) findViewById(e.title_btn_right);
            this.mTitleLayout = (RelativeLayout) findViewById(e.sapi_title_layout);
            this.mTitleBgLayout = (RelativeLayout) findViewById(e.sapi_title_bg_layout);
            this.dividerLine = findViewById(e.title_divider_line);
            this.mRightBtnClose = (ImageView) findViewById(e.title_right_close);
            if (this.configuration.showBottomBack && this.bottomBackView == null) {
                ViewStub viewStub = (ViewStub) findViewById(e.stub_bottom_back);
                if (viewStub != null) {
                    this.bottomBackView = viewStub.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(e.sapi_bottom_back);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(e.sapi_layout_bottom_back);
                    this.mBottomDividerLine = (ImageView) findViewById(e.sapi_sdk_bottom_divider_line);
                    this.mBottomBackBtnIv.setOnClickListener(this);
                    ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                }
            }
            ImageView imageView = this.mRightBtnClose;
            if (imageView != null) {
                imageView.setOnClickListener(this);
                ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            }
            this.mLeftBtnIv.setOnClickListener(this);
            this.mLeftBtnTv.setOnClickListener(this);
            this.mRightBtn.setOnClickListener(this);
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        if (!sapiConfiguration.isDarkMode && sapiConfiguration.isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(f.layout_sapi_sdk_night_mode_mask, null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
        if (this.bottomBackView != null) {
            p.a(this, new p.a() {
                public void keyBoardHide(int i2) {
                    View view = TitleActivity.this.bottomBackView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }

                public void keyBoardShow(int i2) {
                    View view = TitleActivity.this.bottomBackView;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            });
        }
    }

    public void switchDarkmode() {
        if (this.configuration.isDarkMode) {
            if (this.useTitle) {
                setTitleLayoutBg(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                setLeftBtnImage(d.sapi_sdk_btn_back_dark_mode);
                setLeftBtnTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                setTitleTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                setRightBtnColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                this.mRightBtnClose.setImageResource(d.sapi_sdk_title_close_dark_mode);
                this.dividerLine.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView = this.mBottomBackBtnIv;
            if (imageView != null) {
                imageView.setImageResource(d.sapi_sdk_btn_back_dark_mode);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView2 = this.mBottomDividerLine;
            if (imageView2 != null) {
                imageView2.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
        }
    }

    public void updateBottomBack(int i2) {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration.showBottomBack) {
            if (i2 == 1) {
                this.bottomBackView.setVisibility(8);
                this.mRightBtnClose.setVisibility(0);
                return;
            }
            this.bottomBackView.setVisibility(0);
            this.mRightBtnClose.setVisibility(8);
        } else if (!sapiConfiguration.showCloseBtn) {
        } else {
            if (i2 == 1) {
                this.mRightBtnClose.setVisibility(0);
                this.mLeftBtnLayout.setVisibility(8);
                return;
            }
            this.mRightBtnClose.setVisibility(8);
            this.mLeftBtnLayout.setVisibility(0);
        }
    }

    public void setTitleText(int i2) {
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(i2);
        }
    }
}
