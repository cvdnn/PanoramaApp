package com.arashivision.onecamera;

import android.util.Log;
import e.a.a.a.a;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class ByteDump {
    public static final String TAG = "ByteDump";
    public String mDumpPath;
    public int mLength;
    public FileOutputStream mOut;

    public ByteDump(String str) {
        String str2 = TAG;
        this.mDumpPath = str;
        try {
            this.mOut = new FileOutputStream(this.mDumpPath);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("open stream meets exception: ");
            sb.append(e2);
            Log.e(str2, sb.toString());
        }
        StringBuilder a2 = a.a("ByteDump() : ");
        a2.append(this.mDumpPath);
        Log.d(str2, a2.toString());
    }

    public void finalize() throws Throwable {
        if (this.mOut != null) {
            release();
        }
        super.finalize();
    }

    public void put(byte[] bArr, int i2, int i3) {
        String str = TAG;
        FileOutputStream fileOutputStream = this.mOut;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(bArr, i2, i3);
                this.mLength += i3;
                Log.i(str, String.format(Locale.getDefault(), "put one buffer, size: %d, start: %x %x %x %x %x", new Object[]{Integer.valueOf(i3), Byte.valueOf(bArr[i2]), Byte.valueOf(bArr[i2 + 1]), Byte.valueOf(bArr[i2 + 2]), Byte.valueOf(bArr[i2 + 3]), Byte.valueOf(bArr[i2 + 4])}));
            } catch (IOException e2) {
                e2.printStackTrace();
                StringBuilder sb = new StringBuilder();
                sb.append("write stream meets exception: ");
                sb.append(e2);
                Log.e(str, sb.toString());
            }
        }
    }

    public void release() {
        String str = TAG;
        try {
            if (this.mOut != null) {
                this.mOut.close();
                this.mOut = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("close stream meets exception: ");
            sb.append(e2);
            Log.e(str, sb.toString());
        }
        Log.d(str, "H264Dump released");
    }
}
