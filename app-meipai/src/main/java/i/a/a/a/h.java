package i.a.a.a;

import java.util.Iterator;
import java.util.List;

/* compiled from: MissingOptionException */
public class h extends l {
    public h(List list) {
        StringBuffer stringBuffer = new StringBuffer("Missing required option");
        stringBuffer.append(list.size() == 1 ? "" : "s");
        stringBuffer.append(": ");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        super(stringBuffer.toString());
    }
}
