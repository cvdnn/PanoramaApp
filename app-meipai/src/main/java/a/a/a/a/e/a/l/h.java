package a.a.a.a.e.a.l;

import a.a.a.a.e.a.a;
import a.a.a.a.e.a.e.b;
import a.a.a.a.e.a.e.j;
import a.a.a.a.e.a.e.m;
import a.a.a.a.e.a.e.o;
import a.a.a.a.e.a.e.q;
import android.text.TextUtils;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.image.IImageParams;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.arashivision.insta360.basemedia.util.FileUtils;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public class h {
    static {
        MediaLogger.getLogger(h.class);
    }

    public static int a(IVideoParams iVideoParams, String str, int i2) {
        a aVar = new a();
        iVideoParams.addReference(aVar);
        iVideoParams.loadExtraData();
        iVideoParams.removeReference(aVar);
        if (aVar.f446a) {
            return i2;
        }
        return 0;
    }

    public static int b(IVideoParams iVideoParams, String str, int i2) {
        if (!iVideoParams.hasAAAList()) {
            return 0;
        }
        a aVar = new a();
        iVideoParams.addReference(aVar);
        iVideoParams.loadAAA();
        iVideoParams.removeReference(aVar);
        if (!aVar.f446a) {
            i2 = 0;
        }
        return i2;
    }

    public static int c(IVideoParams iVideoParams, String str, int i2) {
        if (!iVideoParams.hasExposureList()) {
            return 0;
        }
        a aVar = new a();
        iVideoParams.addReference(aVar);
        iVideoParams.loadExposure();
        iVideoParams.removeReference(aVar);
        if (!aVar.f446a) {
            i2 = 0;
        }
        return i2;
    }

    public static int d(IVideoParams iVideoParams, String str, int i2) {
        if (!iVideoParams.hasGpsList()) {
            return 0;
        }
        a aVar = new a();
        iVideoParams.addReference(aVar);
        iVideoParams.loadGps();
        iVideoParams.removeReference(aVar);
        if (!aVar.f446a) {
            i2 = 0;
        }
        return i2;
    }

    public static int a(IImageParams iImageParams, String str, int i2) {
        a aVar = new a();
        iImageParams.addReference(aVar);
        iImageParams.loadExtraData();
        iImageParams.removeReference(aVar);
        if (aVar.f446a) {
            return i2;
        }
        return 0;
    }

    public static int a(IImageParams iImageParams, a.a.a.a.a.e.a aVar, String str, int i2, int i3) {
        if (!iImageParams.hasGyroList()) {
            return 0;
        }
        a aVar2 = new a();
        iImageParams.addReference(aVar2);
        iImageParams.createStabilizer(false);
        boolean loadStabilizer = iImageParams.loadStabilizer(aVar);
        iImageParams.removeReference(aVar2);
        if (!loadStabilizer) {
            return i2;
        }
        iImageParams.updateStabilizer(iImageParams.getStabType());
        iImageParams.updateStabilizerByFovAndDistanceIfNeeded();
        if (!aVar2.f446a) {
            i3 = 0;
        }
        return i3;
    }

    public static int a(IVideoParams iVideoParams, a.a.a.a.a.e.a aVar, String str, int i2, int i3) {
        if (!iVideoParams.hasGyroList()) {
            return 0;
        }
        a aVar2 = new a();
        iVideoParams.addReference(aVar2);
        iVideoParams.createStabilizer(iVideoParams.inputGyroBySegment());
        boolean loadStabilizer = iVideoParams.loadStabilizer(aVar);
        iVideoParams.removeReference(aVar2);
        if (!loadStabilizer) {
            return i2;
        }
        iVideoParams.updateStabilizer(iVideoParams.getStabType());
        iVideoParams.updateStabilizerByFovAndDistanceIfNeeded();
        if (!aVar2.f446a) {
            i3 = 0;
        }
        return i3;
    }

    public static int a(IVideoParams iVideoParams, q qVar, String str, int i2) {
        boolean z;
        boolean z2;
        IVideoParams iVideoParams2 = iVideoParams;
        q qVar2 = qVar;
        a aVar = new a();
        iVideoParams2.addReference(aVar);
        if (qVar2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = 0;
            if (!qVar.d()) {
                q.f565d.d("no need to generate proxy!");
            } else {
                String[] a2 = qVar.a();
                if (!(qVar2.f566a == null || a2.length == 0)) {
                    int length = a2.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            z = false;
                            break;
                        } else if (TextUtils.isEmpty(a2[i4])) {
                            z = true;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        if (qVar2.f566a != null) {
                            o oVar = qVar2.f568c;
                            j jVar = new j(qVar2);
                            m mVar = new m(qVar2);
                            oVar.f543c = jVar;
                            oVar.f547g = mVar;
                            String[] a3 = jVar.f531a.a();
                            String[] a4 = oVar.a();
                            int i5 = 0;
                            while (true) {
                                if (i5 < a3.length) {
                                    File file = new File(a3[i5]);
                                    File file2 = new File(a4[i5]);
                                    if (!file.exists() || !file2.exists()) {
                                        break;
                                    }
                                    i5++;
                                } else if (a3.length != 0) {
                                    z2 = true;
                                }
                            }
                            z2 = false;
                            if (!z2) {
                                if (((j) oVar.f543c).f531a.f566a.getUrlsForPlay()[0].startsWith("http")) {
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    String[] b2 = oVar.b();
                                    for (String file3 : b2) {
                                        FileUtils.fullDelete(new File(file3));
                                    }
                                    int[] iArr = {0};
                                    String[] strArr = {""};
                                    CountDownLatch countDownLatch = new CountDownLatch(1);
                                    b bVar = r10;
                                    int[] iArr2 = iArr;
                                    b bVar2 = new b(oVar, b2, countDownLatch, iArr, strArr);
                                    new Thread(bVar).start();
                                    try {
                                        countDownLatch.await();
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                    }
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    MediaLogger mediaLogger = o.f540h;
                                    StringBuilder a5 = e.a.a.a.a.a("proxy step1 trim cost : ");
                                    a5.append(currentTimeMillis3 - currentTimeMillis2);
                                    mediaLogger.i(a5.toString());
                                    if (!oVar.f544d) {
                                        oVar.a(true);
                                        i3 = 0;
                                    } else {
                                        o.a aVar2 = oVar.f547g;
                                        if (aVar2 != null) {
                                            if (iArr2[0] == -1) {
                                                m mVar2 = (m) aVar2;
                                            } else {
                                                int i6 = iArr2[0];
                                                String str2 = strArr[0];
                                                m mVar3 = (m) aVar2;
                                            }
                                        }
                                        i3 = 0;
                                    }
                                } else {
                                    oVar.a(false);
                                }
                            }
                            long currentTimeMillis4 = System.currentTimeMillis();
                            MediaLogger mediaLogger2 = q.f565d;
                            StringBuilder a6 = e.a.a.a.a.a("proxy all cost : ");
                            a6.append(currentTimeMillis4 - currentTimeMillis);
                            mediaLogger2.i(a6.toString());
                            iVideoParams2 = iVideoParams;
                        }
                    }
                }
                q.f565d.e("use proxy url, but proxy url is null");
                long currentTimeMillis42 = System.currentTimeMillis();
                MediaLogger mediaLogger22 = q.f565d;
                StringBuilder a62 = e.a.a.a.a.a("proxy all cost : ");
                a62.append(currentTimeMillis42 - currentTimeMillis);
                mediaLogger22.i(a62.toString());
                iVideoParams2 = iVideoParams;
            }
            iVideoParams2.removeReference(aVar);
            return aVar.f446a ? i2 : i3;
        }
        throw null;
    }
}
