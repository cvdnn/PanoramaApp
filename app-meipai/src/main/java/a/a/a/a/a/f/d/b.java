package a.a.a.a.a.f.d;

import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.baidubce.BceConfig;
import java.util.Calendar;

public class b {

    /* renamed from: a reason: collision with root package name */
    public static final MediaLogger f384a = MediaLogger.getLogger(b.class);

    public static long a(String str) {
        try {
            String[] split = str.split(BceConfig.BOS_DELIMITER);
            if (split.length == 0) {
                return 0;
            }
            String[] split2 = split[split.length - 1].split("\\.");
            if (split2.length == 0) {
                return 0;
            }
            String[] split3 = split2[0].split("_");
            if (split3.length != 5) {
                return 0;
            }
            Calendar instance = Calendar.getInstance();
            String str2 = split3[1];
            String str3 = split3[2];
            instance.set(Integer.valueOf(str2.substring(0, 4)).intValue(), Integer.valueOf(str2.substring(4, 6)).intValue() - 1, Integer.valueOf(str2.substring(6, 8)).intValue(), Integer.valueOf(str3.substring(0, 2)).intValue(), Integer.valueOf(str3.substring(2, 4)).intValue(), Integer.valueOf(str3.substring(4, 6)).intValue());
            instance.set(14, Integer.valueOf(split3[3]).intValue());
            return 0 + instance.getTimeInMillis();
        } catch (Exception unused) {
            MediaLogger mediaLogger = f384a;
            StringBuilder sb = new StringBuilder();
            sb.append("parse file name for creation time error, file name is: ");
            sb.append(str);
            mediaLogger.w(sb.toString());
            return 0;
        }
    }
}
