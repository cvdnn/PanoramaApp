package e.l.a.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBridge */
public interface b extends IInterface {

    /* compiled from: IBridge */
    public static abstract class a extends Binder implements b {

        /* renamed from: e.l.a.h.b$a$a reason: collision with other inner class name */
        /* compiled from: IBridge */
        public static class C0132a implements b {

            /* renamed from: a reason: collision with root package name */
            public IBinder f8929a;

            public C0132a(IBinder iBinder) {
                this.f8929a = iBinder;
            }

            public void a(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    boolean transact = this.f8929a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f8929a;
            }

            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    boolean transact = this.f8929a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.yanzhenjie.permission.bridge.IBridge");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.yanzhenjie.permission.bridge.IBridge");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0132a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = "com.yanzhenjie.permission.bridge.IBridge";
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface(str);
                        b(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(str);
                        a(parcel.readString(), parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(str);
                        g(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(str);
                        e(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(str);
                        c(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(str);
                        a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(str);
                        d(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(str);
                        f(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    void a(String str) throws RemoteException;

    void a(String str, String[] strArr) throws RemoteException;

    void b(String str) throws RemoteException;

    void c(String str) throws RemoteException;

    void d(String str) throws RemoteException;

    void e(String str) throws RemoteException;

    void f(String str) throws RemoteException;

    void g(String str) throws RemoteException;
}
