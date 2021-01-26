package e.l.a.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog.Calls;

/* compiled from: StrictChecker */
public final class l implements e {
    public static boolean a(Context context) throws Throwable {
        ContentResolver contentResolver = context.getContentResolver();
        String str = "number=?";
        String str2 = "1";
        try {
            ContentValues contentValues = new ContentValues();
            boolean z = true;
            contentValues.put("type", Integer.valueOf(1));
            contentValues.put("number", str2);
            contentValues.put("date", Integer.valueOf(20080808));
            contentValues.put("new", "0");
            if (ContentUris.parseId(contentResolver.insert(Calls.CONTENT_URI, contentValues)) <= 0) {
                z = false;
            }
            return z;
        } finally {
            contentResolver.delete(Calls.CONTENT_URI, str, new String[]{str2});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0249, code lost:
        r3 = true ^ r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r11, java.lang.String... r12) {
        /*
            r10 = this;
            int r0 = r12.length
            r1 = 0
            r2 = r1
        L_0x0003:
            r3 = 1
            if (r2 >= r0) goto L_0x02dd
            r4 = r12[r2]
            r5 = -1
            int r6 = r4.hashCode()     // Catch:{ all -> 0x0179 }
            switch(r6) {
                case -2062386608: goto L_0x0121;
                case -1928411001: goto L_0x0117;
                case -1921431796: goto L_0x010c;
                case -1888586689: goto L_0x0102;
                case -1479758289: goto L_0x00f7;
                case -1238066820: goto L_0x00ec;
                case -895679497: goto L_0x00e1;
                case -895673731: goto L_0x00d6;
                case -406040016: goto L_0x00cb;
                case -63024214: goto L_0x00c1;
                case -5573545: goto L_0x00b5;
                case 52602690: goto L_0x00a9;
                case 112197485: goto L_0x009d;
                case 214526995: goto L_0x0092;
                case 463403621: goto L_0x0087;
                case 603653886: goto L_0x007c;
                case 610633091: goto L_0x0070;
                case 784519842: goto L_0x0064;
                case 952819282: goto L_0x0058;
                case 1271781903: goto L_0x004d;
                case 1365911975: goto L_0x0041;
                case 1780337063: goto L_0x0035;
                case 1831139720: goto L_0x0029;
                case 1977429404: goto L_0x001e;
                case 2133799037: goto L_0x0012;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x0179 }
        L_0x0010:
            goto L_0x012b
        L_0x0012:
            java.lang.String r6 = "com.android.voicemail.permission.ADD_VOICEMAIL"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 13
            goto L_0x012b
        L_0x001e:
            java.lang.String r6 = "android.permission.READ_CONTACTS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 3
            goto L_0x012b
        L_0x0029:
            java.lang.String r6 = "android.permission.RECORD_AUDIO"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 8
            goto L_0x012b
        L_0x0035:
            java.lang.String r6 = "android.permission.ACTIVITY_RECOGNITION"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 17
            goto L_0x012b
        L_0x0041:
            java.lang.String r6 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 24
            goto L_0x012b
        L_0x004d:
            java.lang.String r6 = "android.permission.GET_ACCOUNTS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 5
            goto L_0x012b
        L_0x0058:
            java.lang.String r6 = "android.permission.PROCESS_OUTGOING_CALLS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 15
            goto L_0x012b
        L_0x0064:
            java.lang.String r6 = "android.permission.USE_SIP"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 14
            goto L_0x012b
        L_0x0070:
            java.lang.String r6 = "android.permission.WRITE_CALL_LOG"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 12
            goto L_0x012b
        L_0x007c:
            java.lang.String r6 = "android.permission.WRITE_CALENDAR"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = r3
            goto L_0x012b
        L_0x0087:
            java.lang.String r6 = "android.permission.CAMERA"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 2
            goto L_0x012b
        L_0x0092:
            java.lang.String r6 = "android.permission.WRITE_CONTACTS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 4
            goto L_0x012b
        L_0x009d:
            java.lang.String r6 = "android.permission.CALL_PHONE"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 10
            goto L_0x012b
        L_0x00a9:
            java.lang.String r6 = "android.permission.SEND_SMS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 18
            goto L_0x012b
        L_0x00b5:
            java.lang.String r6 = "android.permission.READ_PHONE_STATE"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 9
            goto L_0x012b
        L_0x00c1:
            java.lang.String r6 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 6
            goto L_0x012b
        L_0x00cb:
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 23
            goto L_0x012b
        L_0x00d6:
            java.lang.String r6 = "android.permission.RECEIVE_SMS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 22
            goto L_0x012b
        L_0x00e1:
            java.lang.String r6 = "android.permission.RECEIVE_MMS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 19
            goto L_0x012b
        L_0x00ec:
            java.lang.String r6 = "android.permission.BODY_SENSORS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 16
            goto L_0x012b
        L_0x00f7:
            java.lang.String r6 = "android.permission.RECEIVE_WAP_PUSH"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 21
            goto L_0x012b
        L_0x0102:
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 7
            goto L_0x012b
        L_0x010c:
            java.lang.String r6 = "android.permission.READ_CALL_LOG"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 11
            goto L_0x012b
        L_0x0117:
            java.lang.String r6 = "android.permission.READ_CALENDAR"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = r1
            goto L_0x012b
        L_0x0121:
            java.lang.String r6 = "android.permission.READ_SMS"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x012b
            r5 = 20
        L_0x012b:
            r4 = 29
            java.lang.String r6 = "location"
            java.lang.String r7 = "_id"
            switch(r5) {
                case 0: goto L_0x02b5;
                case 1: goto L_0x02ab;
                case 2: goto L_0x02a1;
                case 3: goto L_0x0280;
                case 4: goto L_0x0272;
                case 5: goto L_0x0134;
                case 6: goto L_0x024c;
                case 7: goto L_0x021b;
                case 8: goto L_0x0210;
                case 9: goto L_0x01ec;
                case 10: goto L_0x0134;
                case 11: goto L_0x01c8;
                case 12: goto L_0x01c2;
                case 13: goto L_0x0134;
                case 14: goto L_0x01b8;
                case 15: goto L_0x0134;
                case 16: goto L_0x01ad;
                case 17: goto L_0x01a2;
                case 18: goto L_0x0134;
                case 19: goto L_0x0134;
                case 20: goto L_0x017c;
                case 21: goto L_0x0134;
                case 22: goto L_0x0134;
                case 23: goto L_0x0141;
                case 24: goto L_0x0136;
                default: goto L_0x0134;
            }
        L_0x0134:
            goto L_0x02d6
        L_0x0136:
            e.l.a.i.k r3 = new e.l.a.i.k     // Catch:{ all -> 0x0179 }
            r3.<init>()     // Catch:{ all -> 0x0179 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x0141:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0179 }
            if (r5 < r4) goto L_0x014d
            boolean r4 = android.os.Environment.isExternalStorageLegacy()     // Catch:{ all -> 0x0179 }
            if (r4 != 0) goto L_0x014d
            goto L_0x02d6
        L_0x014d:
            java.lang.String r4 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x0179 }
            java.lang.String r5 = "mounted"
            boolean r4 = android.text.TextUtils.equals(r5, r4)     // Catch:{ all -> 0x0179 }
            if (r4 != 0) goto L_0x015b
            goto L_0x02d6
        L_0x015b:
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0179 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0179 }
            if (r5 != 0) goto L_0x0167
            goto L_0x02d6
        L_0x0167:
            long r5 = r4.lastModified()     // Catch:{ all -> 0x0179 }
            java.lang.String[] r4 = r4.list()     // Catch:{ all -> 0x0179 }
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0179
            if (r4 == 0) goto L_0x0179
            goto L_0x02d6
        L_0x0179:
            r3 = r1
            goto L_0x02d6
        L_0x017c:
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ all -> 0x0179 }
            java.lang.String r5 = "address"
            java.lang.String r6 = "person"
            java.lang.String r8 = "body"
            java.lang.String[] r6 = new java.lang.String[]{r7, r5, r6, r8}     // Catch:{ all -> 0x0179 }
            android.net.Uri r5 = android.provider.Telephony.Sms.CONTENT_URI     // Catch:{ all -> 0x0179 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0179
            e.c.f.n.n.a(r4)     // Catch:{ all -> 0x019d }
            r4.close()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x019d:
            r3 = move-exception
            r4.close()     // Catch:{ all -> 0x0179 }
            throw r3     // Catch:{ all -> 0x0179 }
        L_0x01a2:
            e.l.a.i.g r3 = new e.l.a.i.g     // Catch:{ all -> 0x0179 }
            r3.<init>(r11)     // Catch:{ all -> 0x0179 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x01ad:
            e.l.a.i.h r3 = new e.l.a.i.h     // Catch:{ all -> 0x0179 }
            r3.<init>(r11)     // Catch:{ all -> 0x0179 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x01b8:
            e.l.a.i.i r4 = new e.l.a.i.i     // Catch:{ all -> 0x0179 }
            r4.<init>(r11)     // Catch:{ all -> 0x0179 }
            r4.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x01c2:
            boolean r3 = a(r11)     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x01c8:
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ all -> 0x0179 }
            java.lang.String r5 = "number"
            java.lang.String r6 = "type"
            java.lang.String[] r6 = new java.lang.String[]{r7, r5, r6}     // Catch:{ all -> 0x0179 }
            android.net.Uri r5 = android.provider.CallLog.Calls.CONTENT_URI     // Catch:{ all -> 0x0179 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0179
            e.c.f.n.n.a(r4)     // Catch:{ all -> 0x01e7 }
            r4.close()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x01e7:
            r3 = move-exception
            r4.close()     // Catch:{ all -> 0x0179 }
            throw r3     // Catch:{ all -> 0x0179 }
        L_0x01ec:
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ all -> 0x0179 }
            java.lang.String r6 = "android.hardware.telephony"
            boolean r5 = r5.hasSystemFeature(r6)     // Catch:{ all -> 0x0179 }
            if (r5 != 0) goto L_0x01fa
            goto L_0x02d6
        L_0x01fa:
            java.lang.String r5 = "phone"
            java.lang.Object r5 = r11.getSystemService(r5)     // Catch:{ all -> 0x0179 }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ all -> 0x0179 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0179 }
            if (r6 >= r4) goto L_0x020b
            r5.getDeviceId()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x020b:
            r5.getDeviceSoftwareVersion()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x0210:
            e.l.a.i.f r3 = new e.l.a.i.f     // Catch:{ all -> 0x0179 }
            r3.<init>(r11)     // Catch:{ all -> 0x0179 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x021b:
            java.lang.Object r4 = r11.getSystemService(r6)     // Catch:{ all -> 0x0179 }
            android.location.LocationManager r4 = (android.location.LocationManager) r4     // Catch:{ all -> 0x0179 }
            java.util.List r5 = r4.getProviders(r3)     // Catch:{ all -> 0x0179 }
            java.lang.String r6 = "gps"
            boolean r7 = r5.contains(r6)     // Catch:{ all -> 0x0179 }
            java.lang.String r8 = "passive"
            boolean r5 = r5.contains(r8)     // Catch:{ all -> 0x0179 }
            if (r7 != 0) goto L_0x02d6
            if (r5 == 0) goto L_0x0237
            goto L_0x02d6
        L_0x0237:
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ all -> 0x0179 }
            java.lang.String r7 = "android.hardware.location.gps"
            boolean r5 = r5.hasSystemFeature(r7)     // Catch:{ all -> 0x0179 }
            if (r5 != 0) goto L_0x0245
            goto L_0x02d6
        L_0x0245:
            boolean r4 = r4.isProviderEnabled(r6)     // Catch:{ all -> 0x0179 }
        L_0x0249:
            r3 = r3 ^ r4
            goto L_0x02d6
        L_0x024c:
            java.lang.Object r4 = r11.getSystemService(r6)     // Catch:{ all -> 0x0179 }
            android.location.LocationManager r4 = (android.location.LocationManager) r4     // Catch:{ all -> 0x0179 }
            java.util.List r5 = r4.getProviders(r3)     // Catch:{ all -> 0x0179 }
            java.lang.String r6 = "network"
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x0179 }
            if (r5 == 0) goto L_0x0260
            goto L_0x02d6
        L_0x0260:
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ all -> 0x0179 }
            java.lang.String r7 = "android.hardware.location.network"
            boolean r5 = r5.hasSystemFeature(r7)     // Catch:{ all -> 0x0179 }
            if (r5 != 0) goto L_0x026d
            goto L_0x02d6
        L_0x026d:
            boolean r4 = r4.isProviderEnabled(r6)     // Catch:{ all -> 0x0179 }
            goto L_0x0249
        L_0x0272:
            android.content.ContentResolver r3 = r11.getContentResolver()     // Catch:{ all -> 0x0179 }
            e.l.a.i.c r4 = new e.l.a.i.c     // Catch:{ all -> 0x0179 }
            r4.<init>(r3)     // Catch:{ all -> 0x0179 }
            boolean r3 = r4.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x0280:
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ all -> 0x0179 }
            java.lang.String r5 = "data1"
            java.lang.String[] r6 = new java.lang.String[]{r7, r5}     // Catch:{ all -> 0x0179 }
            android.net.Uri r5 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ all -> 0x0179 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0179
            e.c.f.n.n.a(r4)     // Catch:{ all -> 0x029c }
            r4.close()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x029c:
            r3 = move-exception
            r4.close()     // Catch:{ all -> 0x0179 }
            throw r3     // Catch:{ all -> 0x0179 }
        L_0x02a1:
            e.l.a.i.b r3 = new e.l.a.i.b     // Catch:{ all -> 0x0179 }
            r3.<init>(r11)     // Catch:{ all -> 0x0179 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x02ab:
            e.l.a.i.a r3 = new e.l.a.i.a     // Catch:{ all -> 0x0179 }
            r3.<init>(r11)     // Catch:{ all -> 0x0179 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x02b5:
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ all -> 0x0179 }
            java.lang.String r5 = "name"
            java.lang.String[] r6 = new java.lang.String[]{r7, r5}     // Catch:{ all -> 0x0179 }
            android.net.Uri r5 = android.provider.CalendarContract.Calendars.CONTENT_URI     // Catch:{ all -> 0x0179 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0179
            e.c.f.n.n.a(r4)     // Catch:{ all -> 0x02d1 }
            r4.close()     // Catch:{ all -> 0x0179 }
            goto L_0x02d6
        L_0x02d1:
            r3 = move-exception
            r4.close()     // Catch:{ all -> 0x0179 }
            throw r3     // Catch:{ all -> 0x0179 }
        L_0x02d6:
            if (r3 != 0) goto L_0x02d9
            return r1
        L_0x02d9:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x02dd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.a.i.l.a(android.content.Context, java.lang.String[]):boolean");
    }
}
