package i.b.a;

import java.io.PrintStream;
import java.util.logging.Level;

/* compiled from: Logger */
public interface g {

    /* compiled from: Logger */
    public static class a implements g {
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(level);
            sb.append("] ");
            sb.append(str);
            printStream.println(sb.toString());
        }

        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(level);
            sb.append("] ");
            sb.append(str);
            printStream.println(sb.toString());
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
