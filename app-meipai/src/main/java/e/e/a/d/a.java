package e.e.a.d;

import android.os.Handler;

/* compiled from: BleBaseCallback */
public abstract class a {
    public Handler handler;
    public String key;

    public Handler getHandler() {
        return this.handler;
    }

    public String getKey() {
        return this.key;
    }

    public void setHandler(Handler handler2) {
        this.handler = handler2;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
