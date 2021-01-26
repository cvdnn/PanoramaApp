package e.m.a;

/* compiled from: Direction */
public enum b {
    START {
        public int a(int i2) {
            return i2 * -1;
        }

        public boolean b(int i2) {
            return i2 < 0;
        }
    },
    END {
        public int a(int i2) {
            return i2;
        }

        public boolean b(int i2) {
            return i2 > 0;
        }
    };

    public static b c(int i2) {
        return i2 > 0 ? END : START;
    }

    public abstract int a(int i2);

    public abstract boolean b(int i2);
}
