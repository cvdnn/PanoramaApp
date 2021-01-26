package g.d0.f;

import g.d0.c;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: HttpDate */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public static final ThreadLocal<DateFormat> f9234a = new a();

    /* renamed from: b reason: collision with root package name */
    public static final String[] f9235b;

    /* renamed from: c reason: collision with root package name */
    public static final DateFormat[] f9236c;

    /* compiled from: HttpDate */
    public class a extends ThreadLocal<DateFormat> {
        public Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(c.o);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f9235b = strArr;
        f9236c = new DateFormat[strArr.length];
    }

    public static Date a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f9234a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f9235b) {
            int length = f9235b.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat dateFormat = f9236c[i2];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f9235b[i2], Locale.US);
                    dateFormat.setTimeZone(c.o);
                    f9236c[i2] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }
}
