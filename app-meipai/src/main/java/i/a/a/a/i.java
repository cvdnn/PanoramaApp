package i.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Option */
public class i implements Cloneable, Serializable {

    /* renamed from: a reason: collision with root package name */
    public String f9707a;

    /* renamed from: b reason: collision with root package name */
    public String f9708b;

    /* renamed from: c reason: collision with root package name */
    public String f9709c = "arg";

    /* renamed from: d reason: collision with root package name */
    public String f9710d;

    /* renamed from: e reason: collision with root package name */
    public int f9711e = -1;

    /* renamed from: f reason: collision with root package name */
    public List f9712f = new ArrayList();

    public i(String str, String str2, boolean z, String str3) throws IllegalArgumentException {
        if (str != null) {
            String str4 = "'";
            int i2 = 0;
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                if (Character.isJavaIdentifierPart(charAt) || charAt == ' ' || charAt == '?' || charAt == '@') {
                    i2 = 1;
                }
                if (i2 == 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal option value '");
                    stringBuffer.append(charAt);
                    stringBuffer.append(str4);
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            } else {
                char[] charArray = str.toCharArray();
                while (i2 < charArray.length) {
                    if (Character.isJavaIdentifierPart(charArray[i2])) {
                        i2++;
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("opt contains illegal character value '");
                        stringBuffer2.append(charArray[i2]);
                        stringBuffer2.append(str4);
                        throw new IllegalArgumentException(stringBuffer2.toString());
                    }
                }
            }
        }
        this.f9707a = str;
        this.f9708b = str2;
        if (z) {
            this.f9711e = 1;
        }
        this.f9710d = str3;
    }

    public String a() {
        String str = this.f9707a;
        return str == null ? this.f9708b : str;
    }

    public String[] b() {
        if (this.f9712f.isEmpty()) {
            return null;
        }
        List list = this.f9712f;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public boolean c() {
        int i2 = this.f9711e;
        return i2 > 0 || i2 == -2;
    }

    public Object clone() {
        try {
            i iVar = (i) super.clone();
            iVar.f9712f = new ArrayList(this.f9712f);
            return iVar;
        } catch (CloneNotSupportedException e2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e2.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        String str = this.f9707a;
        if (str == null ? iVar.f9707a != null : !str.equals(iVar.f9707a)) {
            return false;
        }
        String str2 = this.f9708b;
        String str3 = iVar.f9708b;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.f9707a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f9708b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ option: ");
        stringBuffer.append(this.f9707a);
        String str = " ";
        if (this.f9708b != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.f9708b);
        }
        stringBuffer.append(str);
        int i2 = this.f9711e;
        boolean z = true;
        if (i2 <= 1 && i2 != -2) {
            z = false;
        }
        if (z) {
            stringBuffer.append("[ARG...]");
        } else if (c()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.f9710d);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public final void a(String str) {
        if (this.f9711e <= 0 || this.f9712f.size() <= this.f9711e - 1) {
            this.f9712f.add(str);
            return;
        }
        throw new RuntimeException("Cannot add value, list full.");
    }
}
