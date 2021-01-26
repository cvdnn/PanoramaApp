package e.c.f.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sofire.rp.receiver.Receiver;
import e.c.f.c;
import e.c.f.i;
import e.c.f.j.b;
import e.c.f.n.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Service */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public C0077a f7030a = new C0077a(f.f7059c.f7061b.getLooper());

    /* renamed from: b reason: collision with root package name */
    public i f7031b = new i(this.f7032c);

    /* renamed from: c reason: collision with root package name */
    public Context f7032c;

    /* renamed from: d reason: collision with root package name */
    public e.c.f.k.a f7033d = new e.c.f.k.a(this.f7032c);

    /* renamed from: e reason: collision with root package name */
    public Receiver f7034e;

    /* renamed from: e.c.f.m.a$a reason: collision with other inner class name */
    /* compiled from: Service */
    public class C0077a extends Handler {
        public C0077a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: type inference failed for: r4v3 */
        /* JADX WARNING: type inference failed for: r4v4, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r4v5, types: [android.content.SharedPreferences] */
        /* JADX WARNING: type inference failed for: r4v8 */
        /* JADX WARNING: type inference failed for: r4v9, types: [android.content.SharedPreferences] */
        /* JADX WARNING: type inference failed for: r3v25, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r3v26 */
        /* JADX WARNING: type inference failed for: r4v10 */
        /* JADX WARNING: type inference failed for: r3v27 */
        /* JADX WARNING: type inference failed for: r3v28, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r4v14 */
        /* JADX WARNING: type inference failed for: r4v15 */
        /* JADX WARNING: type inference failed for: r4v16 */
        /* JADX WARNING: type inference failed for: r4v17 */
        /* JADX WARNING: type inference failed for: r4v18 */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:40|41) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:34|35|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:62|63|64|65) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
            if (r3 != 0) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
            if (r3 == 0) goto L_0x00a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0105, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0106, code lost:
            r4 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x010d */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v8
  assigns: []
  uses: []
  mth insns count: 267
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00d7 A[Catch:{ all -> 0x00c6, all -> 0x02b3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd A[Catch:{ all -> 0x00c6, all -> 0x02b3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0109 A[SYNTHETIC, Splitter:B:62:0x0109] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x00a5=Splitter:B:40:0x00a5, B:64:0x010d=Splitter:B:64:0x010d, B:7:0x003f=Splitter:B:7:0x003f} */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r18) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                java.lang.String r2 = "re_last_ofline_time"
                int r3 = r0.what     // Catch:{ all -> 0x02b3 }
                r4 = 10
                r5 = 2
                r6 = 0
                r7 = 1
                switch(r3) {
                    case 0: goto L_0x02ad;
                    case 1: goto L_0x0290;
                    case 2: goto L_0x027a;
                    case 3: goto L_0x01d2;
                    case 4: goto L_0x01b5;
                    case 5: goto L_0x0153;
                    case 6: goto L_0x0145;
                    case 7: goto L_0x0132;
                    case 8: goto L_0x0123;
                    case 9: goto L_0x011d;
                    case 10: goto L_0x0064;
                    case 11: goto L_0x0012;
                    default: goto L_0x0010;
                }     // Catch:{ all -> 0x02b3 }
            L_0x0010:
                goto L_0x02b2
            L_0x0012:
                java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x02b3 }
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r2 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x02b3 }
                r3.<init>(r0)     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r2 = e.c.f.n.a.a(r2, r3)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r3 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.k.a r3 = r3.f7033d     // Catch:{ all -> 0x02b3 }
                org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x02b3 }
                r4.<init>()     // Catch:{ all -> 0x02b3 }
                org.json.JSONArray r2 = r4.put(r2)     // Catch:{ all -> 0x02b3 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x02b3 }
                r4.<init>(r0)     // Catch:{ all -> 0x02b3 }
                java.lang.String r5 = "12"
                java.lang.String r6 = "Common_section"
                org.json.JSONObject r4 = r4.getJSONObject(r6)     // Catch:{ all -> 0x0052 }
                if (r4 == 0) goto L_0x0055
                boolean r6 = r4.has(r5)     // Catch:{ all -> 0x0052 }
                if (r6 != 0) goto L_0x004c
                goto L_0x0055
            L_0x004c:
                java.lang.String r6 = ""
                r4.optString(r5, r6)     // Catch:{ all -> 0x0052 }
                goto L_0x0055
            L_0x0052:
                e.c.f.c.d()     // Catch:{ all -> 0x02b3 }
            L_0x0055:
                boolean r2 = r3.a(r2)     // Catch:{ all -> 0x02b3 }
                if (r2 != 0) goto L_0x02b2
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r2 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.n.a.a(r2, r0)     // Catch:{ all -> 0x02b3 }
                goto L_0x02b2
            L_0x0064:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r0 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                int r2 = e.c.f.n.a.i(r0)     // Catch:{ all -> 0x02b3 }
                r0 = 4
                if (r5 != r2) goto L_0x0112
                e.c.f.c.a()     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r3 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r3 = r3.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r3 = e.c.f.h.a.a(r3)     // Catch:{ all -> 0x02b3 }
                r4 = 0
                if (r3 == 0) goto L_0x0111
                android.database.sqlite.SQLiteDatabase r8 = r3.f7005b     // Catch:{ Exception -> 0x009a, all -> 0x0098 }
                java.lang.String r9 = "r"
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                android.database.Cursor r3 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x009a, all -> 0x0098 }
                if (r3 == 0) goto L_0x0094
                int r5 = r3.getCount()     // Catch:{ Exception -> 0x009b }
                goto L_0x0095
            L_0x0094:
                r5 = r6
            L_0x0095:
                if (r3 == 0) goto L_0x00a8
                goto L_0x00a1
            L_0x0098:
                r0 = move-exception
                goto L_0x0107
            L_0x009a:
                r3 = r4
            L_0x009b:
                e.c.f.c.d()     // Catch:{ all -> 0x0105 }
                r5 = r6
                if (r3 == 0) goto L_0x00a8
            L_0x00a1:
                r3.close()     // Catch:{ Exception -> 0x00a5 }
                goto L_0x00a8
            L_0x00a5:
                e.c.f.c.d()     // Catch:{ all -> 0x02b3 }
            L_0x00a8:
                e.c.f.m.a r3 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r3 = r3.f7032c     // Catch:{ all -> 0x02b3 }
                java.lang.String r8 = "leroadcfg"
                android.content.SharedPreferences r9 = r3.getSharedPreferences(r8, r0)     // Catch:{ all -> 0x00c6 }
                r9.edit()     // Catch:{ all -> 0x00c6 }
                android.content.SharedPreferences r8 = r3.getSharedPreferences(r8, r0)     // Catch:{ all -> 0x00c6 }
                r8.edit()     // Catch:{ all -> 0x00c6 }
                java.lang.String r8 = "re_po_rt"
                android.content.SharedPreferences r4 = r3.getSharedPreferences(r8, r0)     // Catch:{ all -> 0x00c6 }
                r4.edit()     // Catch:{ all -> 0x00c6 }
                goto L_0x00cd
            L_0x00c6:
                r0 = move-exception
                r0.getMessage()     // Catch:{ all -> 0x02b3 }
                e.c.f.c.c()     // Catch:{ all -> 0x02b3 }
            L_0x00cd:
                java.lang.String r0 = "up_nu_co"
                r3 = 50
                int r0 = r4.getInt(r0, r3)     // Catch:{ all -> 0x02b3 }
                if (r5 < r0) goto L_0x00dd
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0, r6, r2)     // Catch:{ all -> 0x02b3 }
                return
            L_0x00dd:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r0 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r0 = e.c.f.h.a.a(r0)     // Catch:{ all -> 0x02b3 }
                java.util.List r0 = r0.a(r7, r2)     // Catch:{ all -> 0x02b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b3 }
                java.lang.String r4 = " Dela "
                r3.<init>(r4)     // Catch:{ all -> 0x02b3 }
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                int r4 = r0.size()     // Catch:{ all -> 0x02b3 }
                r3.append(r4)     // Catch:{ all -> 0x02b3 }
                int r0 = r0.size()     // Catch:{ all -> 0x02b3 }
                if (r0 <= 0) goto L_0x0104
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0, r6, r2)     // Catch:{ all -> 0x02b3 }
            L_0x0104:
                return
            L_0x0105:
                r0 = move-exception
                r4 = r3
            L_0x0107:
                if (r4 == 0) goto L_0x0110
                r4.close()     // Catch:{ Exception -> 0x010d }
                goto L_0x0110
            L_0x010d:
                e.c.f.c.d()     // Catch:{ all -> 0x02b3 }
            L_0x0110:
                throw r0     // Catch:{ all -> 0x02b3 }
            L_0x0111:
                throw r4     // Catch:{ all -> 0x02b3 }
            L_0x0112:
                if (r7 != r2) goto L_0x02b2
                e.c.f.c.a()     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r3 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r3, r0, r2)     // Catch:{ all -> 0x02b3 }
                return
            L_0x011d:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0, r6, r5)     // Catch:{ all -> 0x02b3 }
                return
            L_0x0123:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                r2 = 3
                e.c.f.m.a r3 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r3 = r3.f7032c     // Catch:{ all -> 0x02b3 }
                int r3 = e.c.f.n.a.i(r3)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0, r2, r3)     // Catch:{ all -> 0x02b3 }
                return
            L_0x0132:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r2 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                int r2 = e.c.f.n.a.i(r2)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0, r7, r2)     // Catch:{ all -> 0x02b3 }
                return
            L_0x0145:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r2 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                int r2 = e.c.f.n.a.i(r2)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0, r7, r2)     // Catch:{ all -> 0x02b3 }
                return
            L_0x0153:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.i r3 = new e.c.f.i     // Catch:{ all -> 0x02b3 }
                android.content.Context r5 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                r3.<init>(r5)     // Catch:{ all -> 0x02b3 }
                int r5 = r3.i()     // Catch:{ all -> 0x02b3 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b3 }
                java.lang.String r7 = " 2"
                r6.<init>(r7)     // Catch:{ all -> 0x02b3 }
                java.lang.String r7 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x02b3 }
                r6.append(r7)     // Catch:{ all -> 0x02b3 }
                e.c.f.c.a()     // Catch:{ all -> 0x02b3 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b3 }
                android.content.SharedPreferences r8 = r3.f7011e     // Catch:{ all -> 0x02b3 }
                r9 = 0
                long r8 = r8.getLong(r2, r9)     // Catch:{ all -> 0x02b3 }
                long r6 = r6 - r8
                r8 = 3600000(0x36ee80, float:5.044674E-39)
                int r5 = r5 * r8
                long r8 = (long) r5     // Catch:{ all -> 0x02b3 }
                int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r5 < 0) goto L_0x01a4
                android.content.Context r5 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.n.b r5 = e.c.f.n.b.a(r5)     // Catch:{ all -> 0x02b3 }
                r5.b()     // Catch:{ all -> 0x02b3 }
                android.content.Context r0 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.n.a.a(r0, r8)     // Catch:{ all -> 0x02b3 }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b3 }
                android.content.SharedPreferences$Editor r0 = r3.f7012f     // Catch:{ all -> 0x02b3 }
                r0.putLong(r2, r5)     // Catch:{ all -> 0x02b3 }
                android.content.SharedPreferences$Editor r0 = r3.f7012f     // Catch:{ all -> 0x02b3 }
                r0.commit()     // Catch:{ all -> 0x02b3 }
                goto L_0x01aa
            L_0x01a4:
                android.content.Context r0 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                long r8 = r8 - r6
                e.c.f.n.a.a(r0, r8)     // Catch:{ all -> 0x02b3 }
            L_0x01aa:
                android.os.Message r0 = new android.os.Message     // Catch:{ all -> 0x02b3 }
                r0.<init>()     // Catch:{ all -> 0x02b3 }
                r0.what = r4     // Catch:{ all -> 0x02b3 }
                r1.sendMessage(r0)     // Catch:{ all -> 0x02b3 }
                return
            L_0x01b5:
                java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x02b3 }
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x02b3 }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02b3 }
                if (r2 == 0) goto L_0x01c2
                return
            L_0x01c2:
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r2 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r2 = e.c.f.h.a.a(r2)     // Catch:{ all -> 0x02b3 }
                java.lang.String r0 = e.c.f.n.h.a(r0)     // Catch:{ all -> 0x02b3 }
                r2.a(r0)     // Catch:{ all -> 0x02b3 }
                return
            L_0x01d2:
                java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x02b3 }
                e.c.f.g$b r0 = (e.c.f.g.b) r0     // Catch:{ all -> 0x02b3 }
                if (r0 != 0) goto L_0x01d9
                return
            L_0x01d9:
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.i r3 = r2.f7031b     // Catch:{ all -> 0x02b3 }
                java.lang.String r4 = r0.f7001e     // Catch:{ all -> 0x02b3 }
                java.lang.String r3 = r3.a(r4)     // Catch:{ all -> 0x02b3 }
                e.c.f.j.a r4 = new e.c.f.j.a     // Catch:{ all -> 0x02b3 }
                r4.<init>()     // Catch:{ all -> 0x02b3 }
                java.lang.String r5 = r0.f7001e     // Catch:{ all -> 0x02b3 }
                r4.f7015b = r5     // Catch:{ all -> 0x02b3 }
                r4.f7020g = r6     // Catch:{ all -> 0x02b3 }
                r4.f7016c = r7     // Catch:{ all -> 0x02b3 }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b3 }
                r4.f7018e = r5     // Catch:{ all -> 0x02b3 }
                r4.f7019f = r7     // Catch:{ all -> 0x02b3 }
                android.content.Context r5 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                java.lang.String r6 = r0.f6997a     // Catch:{ all -> 0x02b3 }
                java.lang.String r8 = r0.f6999c     // Catch:{ all -> 0x02b3 }
                java.lang.String r9 = r0.f7001e     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r3 = e.c.f.n.a.a(r5, r6, r8, r9, r3)     // Catch:{ all -> 0x02b3 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02b3 }
                r4.f7017d = r3     // Catch:{ all -> 0x02b3 }
                android.content.Context r3 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r3 = e.c.f.h.a.a(r3)     // Catch:{ all -> 0x02b3 }
                r3.a(r4)     // Catch:{ all -> 0x02b3 }
                e.c.f.i r3 = r2.f7031b     // Catch:{ all -> 0x02b3 }
                java.lang.String r5 = r0.f7001e     // Catch:{ all -> 0x02b3 }
                android.content.SharedPreferences$Editor r6 = r3.f7012f     // Catch:{ all -> 0x02b3 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b3 }
                java.lang.String r9 = "re_net_ins_"
                r8.<init>(r9)     // Catch:{ all -> 0x02b3 }
                r8.append(r5)     // Catch:{ all -> 0x02b3 }
                java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x02b3 }
                r6.putBoolean(r5, r7)     // Catch:{ all -> 0x02b3 }
                android.content.SharedPreferences$Editor r3 = r3.f7012f     // Catch:{ all -> 0x02b3 }
                r3.commit()     // Catch:{ all -> 0x02b3 }
                android.content.Context r3 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r3 = e.c.f.n.a.h(r3)     // Catch:{ all -> 0x02b3 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02b3 }
                java.lang.String r3 = e.c.f.n.h.a(r3)     // Catch:{ all -> 0x02b3 }
                android.content.Context r5 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r5 = e.c.f.h.a.a(r5)     // Catch:{ all -> 0x02b3 }
                boolean r5 = r5.b(r3)     // Catch:{ all -> 0x02b3 }
                if (r5 == 0) goto L_0x0279
                java.lang.String r5 = "1001001"
                r4.f7015b = r5     // Catch:{ all -> 0x02b3 }
                android.content.Context r6 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                java.lang.String r7 = r0.f6997a     // Catch:{ all -> 0x02b3 }
                java.lang.String r0 = r0.f6999c     // Catch:{ all -> 0x02b3 }
                android.content.Context r8 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r8 = e.c.f.n.a.h(r8)     // Catch:{ all -> 0x02b3 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x02b3 }
                org.json.JSONObject r0 = e.c.f.n.a.a(r6, r7, r0, r5, r8)     // Catch:{ all -> 0x02b3 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02b3 }
                r4.f7017d = r0     // Catch:{ all -> 0x02b3 }
                android.content.Context r0 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r0 = e.c.f.h.a.a(r0)     // Catch:{ all -> 0x02b3 }
                r0.a(r4)     // Catch:{ all -> 0x02b3 }
                android.content.Context r0 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r0 = e.c.f.h.a.a(r0)     // Catch:{ all -> 0x02b3 }
                r0.a(r3)     // Catch:{ all -> 0x02b3 }
            L_0x0279:
                return
            L_0x027a:
                e.c.f.c.a()     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r0 = r0.f7032c     // Catch:{ all -> 0x02b3 }
                int r0 = e.c.f.n.a.i(r0)     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r2, r6, r0)     // Catch:{ all -> 0x02b3 }
                return
            L_0x0290:
                java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x02b3 }
                e.c.f.j.a r0 = (e.c.f.j.a) r0     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a r2 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                android.content.Context r2 = r2.f7032c     // Catch:{ all -> 0x02b3 }
                e.c.f.h.a r2 = e.c.f.h.a.a(r2)     // Catch:{ all -> 0x02b3 }
                r2.a(r0)     // Catch:{ all -> 0x02b3 }
                e.c.f.c.a()     // Catch:{ all -> 0x02b3 }
                android.os.Message r0 = new android.os.Message     // Catch:{ all -> 0x02b3 }
                r0.<init>()     // Catch:{ all -> 0x02b3 }
                r0.what = r4     // Catch:{ all -> 0x02b3 }
                r1.sendMessage(r0)     // Catch:{ all -> 0x02b3 }
                return
            L_0x02ad:
                e.c.f.m.a r0 = e.c.f.m.a.this     // Catch:{ all -> 0x02b3 }
                e.c.f.m.a.a(r0)     // Catch:{ all -> 0x02b3 }
            L_0x02b2:
                return
            L_0x02b3:
                e.c.f.c.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.m.a.C0077a.handleMessage(android.os.Message):void");
        }
    }

    public a(Context context) {
        this.f7032c = context.getApplicationContext();
    }

    public static boolean a() {
        if (e.c.f.h.a.f7002d > 0 && System.currentTimeMillis() - e.c.f.h.a.f7002d < 600000) {
            return false;
        }
        if (System.currentTimeMillis() - e.c.f.h.a.f7002d > 600000) {
            e.c.f.h.a.f7002d = 0;
        }
        return true;
    }

    public final List<e.c.f.j.a> a(int i2, int i3) {
        if (i2 == 0 && i3 == 2) {
            return e.c.f.h.a.a(this.f7032c).a(i3);
        }
        return null;
    }

    public final void a(List<e.c.f.j.a> list, int i2, long j2) {
        int i3 = this.f7031b.f7011e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            e.c.f.j.a aVar = (e.c.f.j.a) it.next();
            try {
                String jSONObject = e.c.f.n.a.a(this.f7032c, new JSONObject(aVar.f7017d)).toString();
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject);
                    int length = jSONObject.length() + i4;
                    if (length >= 1048576 * i3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i3);
                        sb.append(" : ");
                        sb.append(length);
                        c.a();
                        break;
                    }
                    arrayList.add(Integer.valueOf(aVar.f7014a));
                    arrayList2.add(new b(jSONObject2, aVar.f7023j, aVar.f7014a));
                    i4 = length;
                } catch (Exception unused) {
                    c.d();
                }
            } catch (Exception unused2) {
                c.d();
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            b bVar = (b) arrayList2.get(i5);
            if (bVar != null) {
                String str = bVar.f7025b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f7024a);
                    arrayList3.add(Integer.valueOf(bVar.f7026c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f7024a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f7024a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.f7026c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        if (jSONArray.length() > 0 && this.f7033d.a(jSONArray.toString())) {
            e.c.f.h.a.a(this.f7032c).a((List<Integer>) arrayList3);
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.f7033d.a(jSONArray4.toString())) {
                    e.c.f.h.a.a(this.f7032c).a((List) hashMap2.get(str2));
                }
            }
        }
        e.c.f.h.a a2 = e.c.f.h.a.a(this.f7032c);
        Context context = a2.f7006c;
        String str3 = "leroadcfg";
        SharedPreferences sharedPreferences = null;
        try {
            context.getSharedPreferences(str3, 4).edit();
            context.getSharedPreferences(str3, 4).edit();
            sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            sharedPreferences.edit();
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = sharedPreferences.getInt("re_net_over", 7) * 86400000;
        try {
            StringBuilder sb2 = new StringBuilder("(d <= ? or (d < (");
            sb2.append(currentTimeMillis);
            sb2.append("-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ");
            a2.f7005b.delete("r", sb2.toString(), new String[]{String.valueOf(currentTimeMillis - ((long) i6))});
        } catch (Exception unused3) {
            c.d();
        }
        if (2 != i2) {
            i iVar = this.f7031b;
            iVar.f7012f.putLong("re_day_len", ((long) i4) + j2);
            iVar.f7012f.commit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x000c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(e.c.f.m.a r13) {
        /*
            e.c.f.i r0 = r13.f7031b
            java.util.List r0 = r0.h()
            if (r0 == 0) goto L_0x0142
            java.util.Iterator r0 = r0.iterator()
        L_0x000c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0142
            java.lang.Object r1 = r0.next()
            e.c.f.g$b r1 = (e.c.f.g.b) r1
            e.c.f.i r2 = r13.f7031b
            android.content.SharedPreferences r2 = r2.f7011e
            java.lang.String r3 = ""
            java.lang.String r4 = "li_pk_s"
            java.lang.String r2 = r2.getString(r4, r3)
            java.lang.String r4 = r1.f6998b
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x002f
            goto L_0x005d
        L_0x002f:
            android.content.Context r5 = r13.f7032c
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x003c
            goto L_0x0058
        L_0x003c:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x005d
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x005d }
            r5.<init>(r2)     // Catch:{ Exception -> 0x005d }
            r2 = r6
        L_0x0048:
            int r8 = r5.length()     // Catch:{ Exception -> 0x005d }
            if (r2 >= r8) goto L_0x005d
            java.lang.Object r8 = r5.get(r2)     // Catch:{ Exception -> 0x005d }
            boolean r8 = r4.equals(r8)     // Catch:{ Exception -> 0x005d }
            if (r8 == 0) goto L_0x005a
        L_0x0058:
            r2 = r7
            goto L_0x005e
        L_0x005a:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x005d:
            r2 = r6
        L_0x005e:
            if (r2 == 0) goto L_0x000c
            e.c.f.i r2 = r13.f7031b
            java.lang.String r4 = r1.f7000d
            android.content.SharedPreferences r2 = r2.f7011e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "re_net_ali2_"
            r5.<init>(r8)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r2 = r2.getString(r4, r3)
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            int r4 = r3.get(r7)
            r5 = 2
            int r9 = r3.get(r5)
            r10 = 5
            int r3 = r3.get(r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r4)
            r11.append(r9)
            r11.append(r3)
            java.lang.String r3 = r11.toString()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x000c
            e.c.f.i r2 = r13.f7031b
            java.lang.String r4 = r1.f7000d
            java.lang.String r2 = r2.a(r4)
            e.c.f.j.a r4 = new e.c.f.j.a
            r4.<init>()
            java.lang.String r9 = r1.f7000d
            r4.f7015b = r9
            r4.f7020g = r6
            r4.f7016c = r5
            long r11 = java.lang.System.currentTimeMillis()
            r4.f7018e = r11
            r4.f7019f = r7
            r4.f7022i = r10
            android.content.Context r5 = r13.f7032c
            java.lang.String r7 = r1.f6997a
            java.lang.String r9 = r1.f6999c
            java.lang.String r10 = r1.f7000d
            org.json.JSONObject r2 = e.c.f.n.a.a(r5, r7, r9, r10, r2)
            java.lang.String r2 = r2.toString()
            r4.f7017d = r2
            android.content.Context r2 = r13.f7032c
            e.c.f.h.a r2 = e.c.f.h.a.a(r2)
            r2.a(r4)
            android.content.Context r2 = r13.f7032c
            org.json.JSONObject r2 = e.c.f.n.a.h(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = e.c.f.n.h.a(r2)
            android.content.Context r5 = r13.f7032c
            e.c.f.h.a r5 = e.c.f.h.a.a(r5)
            boolean r5 = r5.b(r2)
            if (r5 == 0) goto L_0x0126
            java.lang.String r5 = "1001001"
            r4.f7015b = r5
            r4.f7022i = r6
            android.content.Context r6 = r13.f7032c
            java.lang.String r7 = r1.f6997a
            java.lang.String r9 = r1.f6999c
            org.json.JSONObject r10 = e.c.f.n.a.h(r6)
            java.lang.String r10 = r10.toString()
            org.json.JSONObject r5 = e.c.f.n.a.a(r6, r7, r9, r5, r10)
            java.lang.String r5 = r5.toString()
            r4.f7017d = r5
            android.content.Context r5 = r13.f7032c
            e.c.f.h.a r5 = e.c.f.h.a.a(r5)
            r5.a(r4)
            android.content.Context r4 = r13.f7032c
            e.c.f.h.a r4 = e.c.f.h.a.a(r4)
            r4.a(r2)
        L_0x0126:
            e.c.f.i r2 = r13.f7031b
            java.lang.String r1 = r1.f7000d
            android.content.SharedPreferences$Editor r4 = r2.f7012f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r8)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4.putString(r1, r3)
            android.content.SharedPreferences$Editor r1 = r2.f7012f
            r1.commit()
            goto L_0x000c
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.m.a.a(e.c.f.m.a):void");
    }

    /* JADX WARNING: type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r8v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r7v7, types: [java.lang.Throwable] */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|75) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00df, code lost:
        if (r7 != 0) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ed, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0104, code lost:
        if (r7 != 0) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010a, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00d5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00e4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014e  */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(e.c.f.m.a r18, int r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            if (r2 != 0) goto L_0x000c
            e.c.f.c.a()
            return
        L_0x000c:
            boolean r3 = a()
            if (r3 == 0) goto L_0x0203
            r3 = 3
            r4 = 1
            r5 = 0
            if (r1 != r4) goto L_0x010f
            android.content.Context r6 = r0.f7032c
            e.c.f.h.a r6 = e.c.f.h.a.a(r6)
            r7 = 0
            if (r6 == 0) goto L_0x010e
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r12 = "i=5"
            java.lang.String r16 = "d desc"
            android.database.sqlite.SQLiteDatabase r9 = r6.f7005b     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r10 = "r"
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r17 = "100"
            android.database.Cursor r7 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00e4 }
            if (r7 == 0) goto L_0x00df
        L_0x0039:
            boolean r6 = r7.moveToNext()     // Catch:{ Exception -> 0x00e4 }
            if (r6 == 0) goto L_0x00df
            e.c.f.j.a r6 = new e.c.f.j.a     // Catch:{ Exception -> 0x00e4 }
            r6.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "a"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7014a = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "b"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7015b = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "c"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7016c = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "d"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            long r9 = r7.getLong(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7018e = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "g"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7019f = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "e"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7020g = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "f"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7021h = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "i"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7022i = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "j"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x00e4 }
            r6.f7023j = r9     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = "h"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x00e4 }
            com.baidu.sofire.ac.F r10 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ Exception -> 0x00d5 }
            byte[] r11 = android.util.Base64.decode(r9, r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r12 = "xVOTuxgN3lkRN2v4"
            java.lang.String r13 = "utf-8"
            byte[] r12 = r12.getBytes(r13)     // Catch:{ Exception -> 0x00d5 }
            byte[] r10 = r10.ad(r11, r12)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x00d5 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x00d5 }
            r9 = r11
            goto L_0x00d8
        L_0x00d5:
            e.c.f.c.d()     // Catch:{ Exception -> 0x00e4 }
        L_0x00d8:
            r6.f7017d = r9     // Catch:{ Exception -> 0x00e4 }
            r8.add(r6)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0039
        L_0x00df:
            if (r7 == 0) goto L_0x00f0
            goto L_0x00e9
        L_0x00e2:
            r0 = move-exception
            goto L_0x0104
        L_0x00e4:
            e.c.f.c.d()     // Catch:{ all -> 0x00e2 }
            if (r7 == 0) goto L_0x00f0
        L_0x00e9:
            r7.close()     // Catch:{ Exception -> 0x00ed }
            goto L_0x00f0
        L_0x00ed:
            e.c.f.c.d()
        L_0x00f0:
            if (r4 != r2) goto L_0x0148
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = " 3g "
            r6.<init>(r7)
            int r7 = r8.size()
            r6.append(r7)
            e.c.f.c.a()
            goto L_0x0148
        L_0x0104:
            if (r7 == 0) goto L_0x010d
            r7.close()     // Catch:{ Exception -> 0x010a }
            goto L_0x010d
        L_0x010a:
            e.c.f.c.d()
        L_0x010d:
            throw r0
        L_0x010e:
            throw r7
        L_0x010f:
            if (r1 != r3) goto L_0x011c
            android.content.Context r6 = r0.f7032c
            e.c.f.h.a r6 = e.c.f.h.a.a(r6)
            java.util.List r8 = r6.a(r5, r2)
            goto L_0x0148
        L_0x011c:
            r6 = 4
            if (r1 != r6) goto L_0x013e
            android.content.Context r6 = r0.f7032c
            e.c.f.h.a r6 = e.c.f.h.a.a(r6)
            java.util.List r8 = r6.a(r4, r2)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = " 3g to report "
            r6.<init>(r7)
            r7 = r8
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            int r7 = r7.size()
            r6.append(r7)
            e.c.f.c.a()
            goto L_0x0148
        L_0x013e:
            android.content.Context r6 = r0.f7032c
            e.c.f.h.a r6 = e.c.f.h.a.a(r6)
            java.util.List r8 = r6.a(r2)
        L_0x0148:
            int r6 = r8.size()
            if (r6 <= 0) goto L_0x0203
            e.c.f.i r6 = r0.f7031b
            android.content.SharedPreferences r6 = r6.f7011e
            java.lang.String r7 = "re_day_len"
            r9 = 0
            long r11 = r6.getLong(r7, r9)
            long r13 = java.lang.System.currentTimeMillis()
            e.c.f.i r6 = r0.f7031b
            android.content.SharedPreferences r6 = r6.f7011e
            java.lang.String r15 = "re_day_b_t"
            long r16 = r6.getLong(r15, r9)
            e.c.f.i r6 = r0.f7031b
            android.content.SharedPreferences r6 = r6.f7011e
            r4 = 50
            java.lang.String r5 = "re_net_dy_lt"
            int r4 = r6.getInt(r5, r4)
            int r5 = (r16 > r9 ? 1 : (r16 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x0186
            e.c.f.i r5 = r0.f7031b
            android.content.SharedPreferences$Editor r6 = r5.f7012f
            r6.putLong(r15, r13)
            android.content.SharedPreferences$Editor r5 = r5.f7012f
            r5.commit()
            r16 = r13
        L_0x0186:
            e.c.f.c.a()
            long r5 = r13 - r16
            r16 = 86400000(0x5265c00, double:4.2687272E-316)
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            java.lang.String r6 = "g_r_d_d_n"
            if (r5 >= 0) goto L_0x01b9
            if (r1 != r3) goto L_0x01b0
            e.c.f.i r3 = r0.f7031b
            android.content.SharedPreferences r3 = r3.f7011e
            r5 = 0
            int r3 = r3.getInt(r6, r5)
            r5 = 5
            if (r3 >= r5) goto L_0x0203
            e.c.f.i r5 = r0.f7031b
            r7 = 1
            int r3 = r3 + r7
            android.content.SharedPreferences$Editor r7 = r5.f7012f
            r7.putInt(r6, r3)
            android.content.SharedPreferences$Editor r3 = r5.f7012f
            r3.commit()
        L_0x01b0:
            r3 = 1048576(0x100000, float:1.469368E-39)
            int r4 = r4 * r3
            long r3 = (long) r4
            int r3 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x01e0
            return
        L_0x01b9:
            e.c.f.i r4 = r0.f7031b
            android.content.SharedPreferences$Editor r5 = r4.f7012f
            r5.putLong(r7, r9)
            android.content.SharedPreferences$Editor r4 = r4.f7012f
            r4.commit()
            e.c.f.i r4 = r0.f7031b
            android.content.SharedPreferences$Editor r5 = r4.f7012f
            r5.putLong(r15, r13)
            android.content.SharedPreferences$Editor r4 = r4.f7012f
            r4.commit()
            if (r1 != r3) goto L_0x01e0
            e.c.f.i r3 = r0.f7031b
            android.content.SharedPreferences$Editor r4 = r3.f7012f
            r5 = 0
            r4.putInt(r6, r5)
            android.content.SharedPreferences$Editor r3 = r3.f7012f
            r3.commit()
        L_0x01e0:
            r0.a(r8, r2, r11)
            boolean r3 = a()
            if (r3 == 0) goto L_0x0203
            java.util.List r3 = r18.a(r19, r20)
        L_0x01ed:
            if (r3 == 0) goto L_0x0203
            int r4 = r3.size()
            if (r4 == 0) goto L_0x0203
            r0.a(r3, r2, r11)
            boolean r3 = a()
            if (r3 == 0) goto L_0x0203
            java.util.List r3 = r18.a(r19, r20)
            goto L_0x01ed
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.m.a.a(e.c.f.m.a, int, int):void");
    }
}
