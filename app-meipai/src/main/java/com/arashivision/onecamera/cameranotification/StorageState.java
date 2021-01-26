package com.arashivision.onecamera.cameranotification;

public class StorageState {
    public int card_state;
    public long free_space;
    public long total_space;

    private void setCard_state(int i2) {
        this.card_state = i2;
    }

    private void setFree_space(long j2) {
        this.free_space = j2;
    }

    private void setTotal_space(long j2) {
        this.total_space = j2;
    }
}
