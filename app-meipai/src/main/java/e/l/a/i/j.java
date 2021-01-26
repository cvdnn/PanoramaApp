package e.l.a.i;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: StandardChecker */
public final class j implements e {
    public boolean a(Context context, String... strArr) {
        AppOpsManager appOpsManager = null;
        for (String str : Arrays.asList(strArr)) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (!TextUtils.isEmpty(permissionToOp)) {
                if (appOpsManager == null) {
                    appOpsManager = (AppOpsManager) context.getSystemService("appops");
                }
                int checkOpNoThrow = appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                if (!(checkOpNoThrow == 0 || checkOpNoThrow == 4)) {
                    return false;
                }
            }
        }
        return true;
    }
}
