package com.baidu.pass.biometrics.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.pass.biometrics.base.R;

@SuppressLint({"InlinedApi", "NewApi"})
public final class PassBioGlobalUtils {
    public static String getZid(Context context) {
        try {
            Object invoke = Class.forName("com.baidu.sofire.ac.FH").getDeclaredMethod("gz", new Class[]{Context.class}).invoke(null, new Object[]{context});
            if (invoke != null) {
                return invoke.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        if (!TextUtils.isEmpty(charSequence)) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.pass_bio_toast_tips, null);
            if (inflate != null) {
                TextView textView = (TextView) inflate.findViewById(R.id.rim_base_toast_message);
                if (textView != null) {
                    textView.setText(charSequence);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.rim_base_toast_icon);
                    if (imageView != null && i2 > 0) {
                        imageView.setImageResource(i2);
                        imageView.setVisibility(0);
                    }
                    Toast toast = new Toast(context);
                    toast.setGravity(17, 0, 0);
                    toast.setDuration(i3);
                    toast.setView(inflate);
                    toast.show();
                }
            }
        }
    }

    public static void toastWithText(Context context, CharSequence charSequence, int i2) {
        toast(context, charSequence, -1, i2);
    }
}
