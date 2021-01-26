package com.baidu.mobstat;

import e.a.a.a.a;
import java.net.InetSocketAddress;

public abstract class bz implements cb {
    public String a(by byVar) throws ch {
        InetSocketAddress a2 = byVar.a();
        if (a2 != null) {
            StringBuilder a3 = a.a("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            a3.append(a2.getPort());
            a3.append("\" /></cross-domain-policy>\u0000");
            return a3.toString();
        }
        throw new cj("socket not bound");
    }

    public void a(by byVar, cq cqVar) {
    }

    public void a(by byVar, cs csVar) throws ch {
    }

    public void a(by byVar, cs csVar, cz czVar) throws ch {
    }

    public void b(by byVar, cq cqVar) {
        cr crVar = new cr(cqVar);
        crVar.a(cq.a.PONG);
        byVar.a(crVar);
    }

    public void c(by byVar, cq cqVar) {
    }
}
