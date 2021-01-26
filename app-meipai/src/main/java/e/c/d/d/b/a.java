package e.c.d.d.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IEventAidlInterface */
public interface a extends IInterface {

    /* renamed from: e.c.d.d.b.a$a reason: collision with other inner class name */
    /* compiled from: IEventAidlInterface */
    public static abstract class C0063a extends Binder implements a {

        /* renamed from: e.c.d.d.b.a$a$a reason: collision with other inner class name */
        /* compiled from: IEventAidlInterface */
        public static class C0064a implements a {

            /* renamed from: a reason: collision with root package name */
            public IBinder f5995a;

            public C0064a(IBinder iBinder) {
                this.f5995a = iBinder;
            }

            public void a(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.picapture.common.ipc.IEventAidlInterface");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        obtain.writeString(cVar.f6000a);
                        obtain.writeString(cVar.f6001b);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5995a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f5995a;
            }
        }

        public C0063a() {
            attachInterface(this, "com.baidu.picapture.common.ipc.IEventAidlInterface");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.picapture.common.ipc.IEventAidlInterface");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0064a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = "com.baidu.picapture.common.ipc.IEventAidlInterface";
            if (i2 == 1) {
                parcel.enforceInterface(str);
                a(parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    void a(c cVar) throws RemoteException;
}
