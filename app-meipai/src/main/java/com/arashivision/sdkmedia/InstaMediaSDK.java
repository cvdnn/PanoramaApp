package com.arashivision.sdkmedia;

import android.app.Application;
import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.insbase.InsBase;
import com.arashivision.insbase.NativeLibsLoader;
import com.arashivision.insta360.basemedia.MediaModule;

public class InstaMediaSDK {
    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public static String m53O8oO888() {
        StringBuilder sb = new StringBuilder();
        sb.append(MediaModule.getApplication().getCacheDir());
        sb.append("/cut_scene");
        return sb.toString();
    }

    public static void init(Application application) {
        InsBase.init(application);
        InsMediaLibsLoader.load();
        NativeLibsLoader.load();
        MediaModule.init(application);
    }

    /* renamed from: 〇O8 reason: contains not printable characters */
    public static String m54O8() {
        StringBuilder sb = new StringBuilder();
        sb.append(MediaModule.getApplication().getCacheDir());
        sb.append("/stabilizer");
        return sb.toString();
    }

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public static String m55Ooo() {
        StringBuilder sb = new StringBuilder();
        sb.append(MediaModule.getApplication().getCacheDir());
        sb.append("/work_thumbnail");
        return sb.toString();
    }
}
