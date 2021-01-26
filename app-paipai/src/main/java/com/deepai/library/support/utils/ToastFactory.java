package com.deepai.library.support.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastFactory {
    private static Context context = null;
    private static Toast toast = null;

    public static Toast getToast(Context context2, String text) {
        if (context == context2) {
            toast.setText(text);
            toast.setDuration(0);
        } else {
            context = context2;
            toast = Toast.makeText(context2, text, 0);
        }
        return toast;
    }

    public static Toast getToast(Context context2, int textRes) {
        return getToast(context2, context2.getResources().getString(textRes));
    }

    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }
}
