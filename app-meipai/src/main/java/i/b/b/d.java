package i.b.b;

import android.database.SQLException;
import android.util.Log;

/* compiled from: DaoException */
public class d extends SQLException {
    public d(String str) {
        super(str);
    }

    public d(String str, Throwable th) {
        super(str);
        try {
            initCause(th);
        } catch (Throwable th2) {
            String str2 = "greenDAO";
            Log.e(str2, "Could not set initial cause", th2);
            Log.e(str2, "Initial cause is:", th);
        }
    }
}
