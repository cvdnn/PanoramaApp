package e.i.a.h.d;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import e.i.a.h.c;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: RemitSyncExecutor */
public class j implements Callback {

    /* renamed from: a reason: collision with root package name */
    public final Handler f8730a;

    /* renamed from: b reason: collision with root package name */
    public final Set<Integer> f8731b = new HashSet();

    /* renamed from: c reason: collision with root package name */
    public final a f8732c;

    /* compiled from: RemitSyncExecutor */
    public interface a {
    }

    public j(a aVar) {
        this.f8732c = aVar;
        HandlerThread handlerThread = new HandlerThread("OkDownload RemitHandoverToDB");
        handlerThread.start();
        this.f8730a = new Handler(handlerThread.getLooper(), this);
    }

    public void a(int i2) {
        Message obtainMessage = this.f8730a.obtainMessage(-2);
        obtainMessage.arg1 = i2;
        this.f8730a.sendMessage(obtainMessage);
    }

    public boolean handleMessage(Message message) {
        SQLiteDatabase writableDatabase;
        int i2 = message.what;
        String str = "RemitSyncExecutor";
        if (i2 == -3) {
            int i3 = message.arg1;
            this.f8731b.remove(Integer.valueOf(i3));
            ((i) this.f8732c).f8728c.a(i3);
            StringBuilder sb = new StringBuilder();
            sb.append("remove info ");
            sb.append(i3);
            c.a(str, sb.toString());
        } else if (i2 == -2) {
            int i4 = message.arg1;
            this.f8731b.remove(Integer.valueOf(i4));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remove free bunch id ");
            sb2.append(i4);
            c.a(str, sb2.toString());
        } else if (i2 == -1) {
            List list = (List) message.obj;
            this.f8731b.removeAll(list);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("remove free bunch ids ");
            sb3.append(list);
            c.a(str, sb3.toString());
        } else if (i2 != 0) {
            try {
                ((i) this.f8732c).f(i2);
                this.f8731b.add(Integer.valueOf(i2));
                StringBuilder sb4 = new StringBuilder();
                sb4.append("sync info with id: ");
                sb4.append(i2);
                c.a(str, sb4.toString());
            } catch (IOException unused) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sync cache to db failed for id: ");
                sb5.append(i2);
                c.b(str, sb5.toString());
            }
        } else {
            List<Integer> list2 = (List) message.obj;
            try {
                i iVar = (i) this.f8732c;
                writableDatabase = iVar.f8728c.getWritableDatabase();
                writableDatabase.beginTransaction();
                for (Integer intValue : list2) {
                    iVar.f(intValue.intValue());
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                this.f8731b.addAll(list2);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("sync bunch info with ids: ");
                sb6.append(list2);
                c.a(str, sb6.toString());
            } catch (IOException unused2) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("sync info to db failed for ids: ");
                sb7.append(list2);
                c.b(str, sb7.toString());
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
        return true;
    }
}
