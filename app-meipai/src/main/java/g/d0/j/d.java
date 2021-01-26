package g.d0.j;

import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import e.a.a.a.a;
import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public final String f9465a;

    /* renamed from: b reason: collision with root package name */
    public final int f9466b;

    /* renamed from: c reason: collision with root package name */
    public int f9467c;

    /* renamed from: d reason: collision with root package name */
    public int f9468d;

    /* renamed from: e reason: collision with root package name */
    public int f9469e;

    /* renamed from: f reason: collision with root package name */
    public int f9470f;

    /* renamed from: g reason: collision with root package name */
    public char[] f9471g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f9465a = name;
        this.f9466b = name.length();
    }

    public final char a() {
        int i2;
        int i3 = this.f9467c + 1;
        this.f9467c = i3;
        if (i3 != this.f9466b) {
            char c2 = this.f9471g[i3];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                int a2 = a(i3);
                                this.f9467c++;
                                char c3 = '?';
                                if (a2 >= 128) {
                                    if (a2 >= 192 && a2 <= 247) {
                                        if (a2 <= 223) {
                                            a2 &= 31;
                                            i2 = 1;
                                        } else if (a2 <= 239) {
                                            i2 = 2;
                                            a2 &= 15;
                                        } else {
                                            i2 = 3;
                                            a2 &= 7;
                                        }
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 < i2) {
                                                int i5 = this.f9467c + 1;
                                                this.f9467c = i5;
                                                if (i5 != this.f9466b && this.f9471g[i5] == '\\') {
                                                    int i6 = i5 + 1;
                                                    this.f9467c = i6;
                                                    int a3 = a(i6);
                                                    this.f9467c++;
                                                    if ((a3 & PassBiometricUtil.STANDARD_MIN_FACE_WIDTH) == 128) {
                                                        a2 = (a2 << 6) + (a3 & 63);
                                                        i4++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return c3;
                                }
                                c3 = (char) a2;
                                return c3;
                        }
                }
            }
            return this.f9471g[this.f9467c];
        }
        StringBuilder a4 = a.a("Unexpected end of DN: ");
        a4.append(this.f9465a);
        throw new IllegalStateException(a4.toString());
    }

    public final String b() {
        while (true) {
            int i2 = this.f9467c;
            if (i2 >= this.f9466b || this.f9471g[i2] != ' ') {
                int i3 = this.f9467c;
            } else {
                this.f9467c = i2 + 1;
            }
        }
        int i32 = this.f9467c;
        if (i32 == this.f9466b) {
            return null;
        }
        this.f9468d = i32;
        this.f9467c = i32 + 1;
        while (true) {
            int i4 = this.f9467c;
            if (i4 >= this.f9466b) {
                break;
            }
            char[] cArr = this.f9471g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f9467c = i4 + 1;
        }
        int i5 = this.f9467c;
        String str = "Unexpected end of DN: ";
        if (i5 < this.f9466b) {
            this.f9469e = i5;
            if (this.f9471g[i5] == ' ') {
                while (true) {
                    int i6 = this.f9467c;
                    if (i6 >= this.f9466b) {
                        break;
                    }
                    char[] cArr2 = this.f9471g;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.f9467c = i6 + 1;
                }
                char[] cArr3 = this.f9471g;
                int i7 = this.f9467c;
                if (cArr3[i7] != '=' || i7 == this.f9466b) {
                    StringBuilder a2 = a.a(str);
                    a2.append(this.f9465a);
                    throw new IllegalStateException(a2.toString());
                }
            }
            this.f9467c++;
            while (true) {
                int i8 = this.f9467c;
                if (i8 >= this.f9466b || this.f9471g[i8] != ' ') {
                    int i9 = this.f9469e;
                    int i10 = this.f9468d;
                } else {
                    this.f9467c = i8 + 1;
                }
            }
            int i92 = this.f9469e;
            int i102 = this.f9468d;
            if (i92 - i102 > 4) {
                char[] cArr4 = this.f9471g;
                if (cArr4[i102 + 3] == '.' && (cArr4[i102] == 'O' || cArr4[i102] == 'o')) {
                    char[] cArr5 = this.f9471g;
                    int i11 = this.f9468d;
                    if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                        char[] cArr6 = this.f9471g;
                        int i12 = this.f9468d;
                        if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                            this.f9468d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f9471g;
            int i13 = this.f9468d;
            return new String(cArr7, i13, this.f9469e - i13);
        }
        StringBuilder a3 = a.a(str);
        a3.append(this.f9465a);
        throw new IllegalStateException(a3.toString());
    }

    public final int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        String str = "Malformed DN: ";
        if (i5 < this.f9466b) {
            char c2 = this.f9471g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                StringBuilder a2 = a.a(str);
                a2.append(this.f9465a);
                throw new IllegalStateException(a2.toString());
            } else {
                i3 = c2 - '7';
            }
            char c3 = this.f9471g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                StringBuilder a3 = a.a(str);
                a3.append(this.f9465a);
                throw new IllegalStateException(a3.toString());
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        StringBuilder a4 = a.a(str);
        a4.append(this.f9465a);
        throw new IllegalStateException(a4.toString());
    }
}
