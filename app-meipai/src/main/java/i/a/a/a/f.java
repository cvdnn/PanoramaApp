package i.a.a.a;

import com.arashivision.insbase.arlog.MultipartUtility;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: HelpFormatter */
public class f {

    /* renamed from: a reason: collision with root package name */
    public int f9700a = 74;

    /* renamed from: b reason: collision with root package name */
    public int f9701b = 1;

    /* renamed from: c reason: collision with root package name */
    public int f9702c = 3;

    /* renamed from: d reason: collision with root package name */
    public String f9703d = System.getProperty("line.separator");

    /* renamed from: e reason: collision with root package name */
    public String f9704e = "-";

    /* renamed from: f reason: collision with root package name */
    public String f9705f = MultipartUtility.TWO_HYPHENS;

    /* renamed from: g reason: collision with root package name */
    public Comparator f9706g = new a(null);

    /* compiled from: HelpFormatter */
    public static class a implements Comparator {
        public /* synthetic */ a(e eVar) {
        }

        public int compare(Object obj, Object obj2) {
            return ((i) obj).a().compareToIgnoreCase(((i) obj2).a());
        }
    }

    public void a(PrintWriter printWriter, int i2, k kVar, int i3, int i4) {
        int i5 = i2;
        k kVar2 = kVar;
        int i6 = i4;
        StringBuffer stringBuffer = new StringBuffer();
        String a2 = a(i3);
        String a3 = a(i6);
        ArrayList arrayList = new ArrayList();
        if (kVar2 != null) {
            ArrayList arrayList2 = new ArrayList(kVar2.f9715a.values());
            Collections.sort(arrayList2, this.f9706g);
            Iterator it = arrayList2.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                i iVar = (i) it.next();
                StringBuffer stringBuffer2 = new StringBuffer(8);
                if (iVar.f9707a == null) {
                    stringBuffer2.append(a2);
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("   ");
                    stringBuffer3.append(this.f9705f);
                    stringBuffer2.append(stringBuffer3.toString());
                    stringBuffer2.append(iVar.f9708b);
                } else {
                    stringBuffer2.append(a2);
                    stringBuffer2.append(this.f9704e);
                    stringBuffer2.append(iVar.f9707a);
                    if (iVar.f9708b != null) {
                        stringBuffer2.append(',');
                        stringBuffer2.append(this.f9705f);
                        stringBuffer2.append(iVar.f9708b);
                    }
                }
                if (iVar.c()) {
                    String str = iVar.f9709c;
                    if (str != null && str.length() > 0) {
                        stringBuffer2.append(" <");
                        stringBuffer2.append(iVar.f9709c);
                        stringBuffer2.append(">");
                    } else {
                        stringBuffer2.append(' ');
                    }
                }
                arrayList.add(stringBuffer2);
                if (stringBuffer2.length() > i7) {
                    i7 = stringBuffer2.length();
                }
            }
            Iterator it2 = arrayList2.iterator();
            int i8 = 0;
            while (it2.hasNext()) {
                i iVar2 = (i) it2.next();
                int i9 = i8 + 1;
                StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i8).toString());
                if (stringBuffer4.length() < i7) {
                    stringBuffer4.append(a(i7 - stringBuffer4.length()));
                }
                stringBuffer4.append(a3);
                int i10 = i7 + i6;
                String str2 = iVar2.f9710d;
                if (str2 != null) {
                    stringBuffer4.append(str2);
                }
                String stringBuffer5 = stringBuffer4.toString();
                int a4 = a(stringBuffer5, i5, 0);
                if (a4 == -1) {
                    stringBuffer.append(a(stringBuffer5));
                } else {
                    stringBuffer.append(a(stringBuffer5.substring(0, a4)));
                    stringBuffer.append(this.f9703d);
                    if (i10 >= i5) {
                        i10 = 1;
                    }
                    String a5 = a(i10);
                    while (true) {
                        StringBuffer stringBuffer6 = new StringBuffer();
                        stringBuffer6.append(a5);
                        stringBuffer6.append(stringBuffer5.substring(a4).trim());
                        stringBuffer5 = stringBuffer6.toString();
                        a4 = a(stringBuffer5, i5, 0);
                        if (a4 == -1) {
                            break;
                        }
                        if (stringBuffer5.length() > i5 && a4 == i10 - 1) {
                            a4 = i5;
                        }
                        stringBuffer.append(a(stringBuffer5.substring(0, a4)));
                        stringBuffer.append(this.f9703d);
                    }
                    stringBuffer.append(stringBuffer5);
                }
                if (it2.hasNext()) {
                    stringBuffer.append(this.f9703d);
                }
                i8 = i9;
            }
            printWriter.println(stringBuffer.toString());
            return;
        }
        throw null;
    }

    public int a(String str, int i2, int i3) {
        int indexOf = str.indexOf(10, i3);
        int i4 = -1;
        if (indexOf == -1 || indexOf > i2) {
            indexOf = str.indexOf(9, i3);
            if (indexOf == -1 || indexOf > i2) {
                int i5 = i2 + i3;
                if (i5 >= str.length()) {
                    return -1;
                }
                int i6 = i5;
                while (i6 >= i3) {
                    char charAt = str.charAt(i6);
                    if (charAt == ' ' || charAt == 10 || charAt == 13) {
                        break;
                    }
                    i6--;
                }
                if (i6 > i3) {
                    return i6;
                }
                while (i5 <= str.length()) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 == ' ' || charAt2 == 10 || charAt2 == 13) {
                        break;
                    }
                    i5++;
                }
                if (i5 != str.length()) {
                    i4 = i5;
                }
                return i4;
            }
        }
        return indexOf + 1;
    }

    public String a(int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    public String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }
}
