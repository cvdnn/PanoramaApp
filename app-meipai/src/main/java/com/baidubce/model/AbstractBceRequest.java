package com.baidubce.model;

import com.baidubce.auth.BceCredentials;
import g.e;

public abstract class AbstractBceRequest {
    public e call;
    public boolean canceled = false;
    public BceCredentials credentials;

    public void cancel() {
        e eVar = this.call;
        if (eVar != null) {
            eVar.cancel();
        }
        this.canceled = true;
    }

    public boolean getCanceled() {
        return this.canceled;
    }

    public BceCredentials getRequestCredentials() {
        return this.credentials;
    }

    public boolean isCanceled() {
        e eVar = this.call;
        if (eVar == null) {
            return this.canceled;
        }
        return eVar.i();
    }

    public void setCall(e eVar) {
        this.call = eVar;
    }

    public void setRequestCredentials(BceCredentials bceCredentials) {
        this.credentials = bceCredentials;
    }

    public abstract AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials);
}
