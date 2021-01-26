package com.arashivision.onecamera.options;

public class ButtonPressOptions {
    public int click;
    public int double_click;
    public int long_press;
    public int shutdown_click;
    public int shutdown_short_press;
    public int triple_click;

    private void setClick(int i2) {
        this.click = i2;
    }

    private void setDouble_click(int i2) {
        this.double_click = i2;
    }

    private void setLong_press(int i2) {
        this.long_press = i2;
    }

    private void setShutdown_click(int i2) {
        this.shutdown_click = i2;
    }

    private void setShutdown_short_press(int i2) {
        this.shutdown_short_press = i2;
    }

    private void setTriple_click(int i2) {
        this.triple_click = i2;
    }
}
