package g;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MediaType */
public final class t {

    /* renamed from: c reason: collision with root package name */
    public static final Pattern f9557c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d reason: collision with root package name */
    public static final Pattern f9558d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a reason: collision with root package name */
    public final String f9559a;

    /* renamed from: b reason: collision with root package name */
    public final String f9560b;

    public t(String str, String str2, String str3, String str4) {
        this.f9559a = str;
        this.f9560b = str4;
    }

    public static t a(String str) {
        Matcher matcher = f9557c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f9558d.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 != null) {
                    String str3 = "'";
                    if (group2.startsWith(str3) && group2.endsWith(str3) && group2.length() > 2) {
                        group2 = group2.substring(1, group2.length() - 1);
                    }
                } else {
                    group2 = matcher2.group(3);
                }
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group2;
            }
        }
        return new t(str, lowerCase, lowerCase2, str2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && ((t) obj).f9559a.equals(this.f9559a);
    }

    public int hashCode() {
        return this.f9559a.hashCode();
    }

    public String toString() {
        return this.f9559a;
    }
}
