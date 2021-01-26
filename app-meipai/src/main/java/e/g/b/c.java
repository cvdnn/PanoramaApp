package e.g.b;

import java.lang.reflect.Field;
import java.util.Locale;

/* compiled from: FieldNamingPolicy */
public enum c implements d {
    IDENTITY {
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String a(Field field) {
            return c.a(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String a(Field field) {
            return c.a(c.a(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String a(Field field) {
            return c.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String a(Field field) {
            return c.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String a(Field field) {
            return c.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i2++;
            charAt = str.charAt(i2);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        int i3 = i2 + 1;
        if (i3 < str.length()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(upperCase);
            sb2.append(str.substring(i3));
            str2 = sb2.toString();
        } else {
            str2 = String.valueOf(upperCase);
        }
        sb.append(str2);
        return sb.toString();
    }
}
