package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.cameranotification.Photo;

public class TakePictureResponse {
    public Photo[] aeb_images;
    public int error_code;
    public Photo image;

    private void setAeb_images(Photo[] photoArr) {
        this.aeb_images = photoArr;
    }

    private void setError_code(int i2) {
        this.error_code = i2;
    }

    private void setPhoto(Photo photo) {
        this.image = photo;
    }
}
