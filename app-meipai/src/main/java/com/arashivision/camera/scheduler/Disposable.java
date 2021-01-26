package com.arashivision.camera.scheduler;

public interface Disposable {
    void dispose();

    Object getDiaposeObject();

    boolean isDisposed();
}
