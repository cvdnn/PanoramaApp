package e.c.d.i.a;

import com.baidu.picapture.hardware.ble.BleHistoryBean;
import e.c.b.e.Utils;
import e.g.b.j;

/* compiled from: BleHistoryRecord */
public class BleHistoryRecord {

    /* renamed from: c reason: collision with root package name */
    public static volatile BleHistoryRecord f6146c;

    /* renamed from: a reason: collision with root package name */
    public BleHistoryBean bleHistoryBean;

    /* renamed from: b reason: collision with root package name */
    public String f6148b;

    public static BleHistoryRecord impl() {
        if (f6146c == null) {
            synchronized (BleHistoryRecord.class) {
                if (f6146c == null) {
                    f6146c = new BleHistoryRecord();
                }
            }
        }
        return f6146c;
    }

    public final void a() {
        if (this.bleHistoryBean != null) {
            Utils.write(this.f6148b, new j().a((Object) this.bleHistoryBean));
        }
    }
}
