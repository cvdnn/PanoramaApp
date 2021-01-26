package com.baidu.picapture.hardware.panorama.beans;

import java.util.List;

public class OSCOptions {
    public int aperture;
    public List<Integer> apertureSupport;
    public String captureMode;
    public List<String> captureModeSupport;
    public int exposureCompensation;
    public List<Integer> exposureCompensationSupport;
    public int exposureProgram;
    public List<Integer> exposureProgramSupport;
    public String hdr;
    public List<String> hdrSupport;
    public int iso;
    public List<Integer> isoSupport;
    public long remainingSpace;
    public float shutterSpeed;
    public List<Float> shutterSpeedSupport;
    public long totalSpace;
    public String whiteBalance;
    public List<String> whiteBalanceSupport;

    public int getAperture() {
        return this.aperture;
    }

    public List<Integer> getApertureSupport() {
        return this.apertureSupport;
    }

    public String getCaptureMode() {
        return this.captureMode;
    }

    public List<String> getCaptureModeSupport() {
        return this.captureModeSupport;
    }

    public int getExposureCompensation() {
        return this.exposureCompensation;
    }

    public List<Integer> getExposureCompensationSupport() {
        return this.exposureCompensationSupport;
    }

    public int getExposureProgram() {
        return this.exposureProgram;
    }

    public List<Integer> getExposureProgramSupport() {
        return this.exposureProgramSupport;
    }

    public String getHdr() {
        return this.hdr;
    }

    public List<String> getHdrSupport() {
        return this.hdrSupport;
    }

    public int getIso() {
        return this.iso;
    }

    public List<Integer> getIsoSupport() {
        return this.isoSupport;
    }

    public long getRemainingSpace() {
        return this.remainingSpace;
    }

    public float getShutterSpeed() {
        return this.shutterSpeed;
    }

    public List<Float> getShutterSpeedSupport() {
        return this.shutterSpeedSupport;
    }

    public long getTotalSpace() {
        return this.totalSpace;
    }

    public String getWhiteBalance() {
        return this.whiteBalance;
    }

    public List<String> getWhiteBalanceSupport() {
        return this.whiteBalanceSupport;
    }

    public void setAperture(int i2) {
        this.aperture = i2;
    }

    public void setApertureSupport(List<Integer> list) {
        this.apertureSupport = list;
    }

    public void setCaptureMode(String str) {
        this.captureMode = str;
    }

    public void setCaptureModeSupport(List<String> list) {
        this.captureModeSupport = list;
    }

    public void setExposureCompensation(int i2) {
        this.exposureCompensation = i2;
    }

    public void setExposureCompensationSupport(List<Integer> list) {
        this.exposureCompensationSupport = list;
    }

    public void setExposureProgram(int i2) {
        this.exposureProgram = i2;
    }

    public void setExposureProgramSupport(List<Integer> list) {
        this.exposureProgramSupport = list;
    }

    public void setHdr(String str) {
        this.hdr = str;
    }

    public void setHdrSupport(List<String> list) {
        this.hdrSupport = list;
    }

    public void setIso(int i2) {
        this.iso = i2;
    }

    public void setIsoSupport(List<Integer> list) {
        this.isoSupport = list;
    }

    public void setRemainingSpace(long j2) {
        this.remainingSpace = j2;
    }

    public void setShutterSpeed(float f2) {
        this.shutterSpeed = f2;
    }

    public void setShutterSpeedSupport(List<Float> list) {
        this.shutterSpeedSupport = list;
    }

    public void setTotalSpace(long j2) {
        this.totalSpace = j2;
    }

    public void setWhiteBalance(String str) {
        this.whiteBalance = str;
    }

    public void setWhiteBalanceSupport(List<String> list) {
        this.whiteBalanceSupport = list;
    }
}
