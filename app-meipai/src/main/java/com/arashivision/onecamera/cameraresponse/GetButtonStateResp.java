package com.arashivision.onecamera.cameraresponse;

public class GetButtonStateResp {
    public int errorCode;
    public long requestID;
    public ButtonPressStatus state;

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setRequestID(long j2) {
        this.requestID = j2;
    }

    public void setState(ButtonPressStatus buttonPressStatus) {
        this.state = buttonPressStatus;
    }
}
