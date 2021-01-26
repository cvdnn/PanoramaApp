package i.d.a.i;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/* compiled from: StringBuilderWriter */
public class c extends Writer implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public final StringBuilder f9899a;

    public c(int i2) {
        this.f9899a = new StringBuilder(i2);
    }

    public Writer append(char c2) {
        this.f9899a.append(c2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.f9899a.toString();
    }

    public void write(String str) {
        if (str != null) {
            this.f9899a.append(str);
        }
    }

    /* renamed from: append reason: collision with other method in class */
    public Appendable m79append(char c2) throws IOException {
        this.f9899a.append(c2);
        return this;
    }

    public void write(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            this.f9899a.append(cArr, i2, i3);
        }
    }

    public Writer append(CharSequence charSequence) {
        this.f9899a.append(charSequence);
        return this;
    }

    /* renamed from: append reason: collision with other method in class */
    public Appendable m80append(CharSequence charSequence) throws IOException {
        this.f9899a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.f9899a.append(charSequence, i2, i3);
        return this;
    }

    /* renamed from: append reason: collision with other method in class */
    public Appendable m81append(CharSequence charSequence, int i2, int i3) throws IOException {
        this.f9899a.append(charSequence, i2, i3);
        return this;
    }
}
