package com.arashivision.camera;

import com.arashivision.camera.exception.OpenException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class InstaCameraState {
    public static final int BUSY = 3;
    public static final int ERROR = 4;
    public static final int IDEL = 0;
    public static final int OPENING = 1;
    public static final int OPEN_COMPLETE = 2;
    public static final int RECORDING = 5;
    public static final int RECORD_STOPING = 6;
    public int mCurrentState;

    public static class SingletonInstance {
        public static final InstaCameraState INSTANCE = new InstaCameraState();
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static InstaCameraState create() {
        return SingletonInstance.INSTANCE;
    }

    public void changeState(int i2) {
        this.mCurrentState = i2;
    }

    public void checkIdelState() {
        if (this.mCurrentState != 0) {
            throw new OpenException("only idel status can open camera");
        }
    }

    public void checkoutOpenState() throws OpenException {
        if (this.mCurrentState < 2) {
            throw new OpenException("only opened camera can send cmd");
        }
    }

    public int getState() {
        return this.mCurrentState;
    }

    public boolean isCameraReady() {
        return this.mCurrentState >= 2;
    }

    public InstaCameraState() {
        this.mCurrentState = 0;
    }
}
