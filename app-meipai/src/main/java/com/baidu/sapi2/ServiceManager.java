package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;

public class ServiceManager implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static ServiceManager f2460a;

    /* renamed from: b reason: collision with root package name */
    public ISAccountManager f2461b;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f2460a == null) {
                f2460a = new ServiceManager();
            }
            serviceManager = f2460a;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f2461b;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f2461b = iSAccountManager;
    }
}
