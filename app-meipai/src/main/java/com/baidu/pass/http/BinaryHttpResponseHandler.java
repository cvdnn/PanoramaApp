package com.baidu.pass.http;

import android.os.Looper;
import android.util.Log;
import java.util.HashMap;

public class BinaryHttpResponseHandler extends HttpResponseHandler {

    /* renamed from: a reason: collision with root package name */
    public String[] f1923a;

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.f1923a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
    }

    public void a(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            b(i2, hashMap, bArr);
            return;
        }
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), hashMap, bArr}));
    }

    public void b(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        String str = "dragon";
        Log.i(str, "in handleSuccessMessage");
        if (hashMap != null) {
            String str2 = "Content-Type";
            if (hashMap.get(str2) != null) {
                String str3 = (String) hashMap.get(str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Type = ");
                sb.append(str3);
                Log.i(str, sb.toString());
                String[] strArr = this.f1923a;
                int length = strArr.length;
                boolean z = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (strArr[i3].equalsIgnoreCase(str3)) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    a(new HttpErrorException(i2, "Content-Type not allowed!"), null);
                    return;
                } else {
                    onSuccess(i2, bArr);
                    return;
                }
            }
        }
        a(new HttpErrorException(i2, "None or more than one Content-Type Header found!"), null);
    }

    public void onSuccess(int i2, byte[] bArr) {
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        this.f1923a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
        this.f1923a = strArr;
        this.executCallbackInChildThread = z;
    }
}
