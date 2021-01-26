package f.a.a.c;

import f.a.a.c.o.a;
import java.util.Comparator;

/* compiled from: TranscodeInfo */
public class n implements Comparator<a> {
    public n(o oVar) {
    }

    public int compare(Object obj, Object obj2) {
        int i2 = (((a) obj).f9108b > ((a) obj2).f9108b ? 1 : (((a) obj).f9108b == ((a) obj2).f9108b ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }
}
