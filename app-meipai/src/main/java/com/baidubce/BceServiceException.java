package com.baidubce;

public class BceServiceException extends BceClientException {
    public static final long serialVersionUID = 1483785729559154396L;
    public String errorCode;
    public String errorMessage;
    public ErrorType errorType = ErrorType.Unknown;
    public String requestId;
    public int statusCode;

    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public BceServiceException(String str) {
        super(null);
        this.errorMessage = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(getErrorMessage());
        sb.append(" (Status Code: ");
        sb.append(getStatusCode());
        sb.append("; Error Code: ");
        sb.append(getErrorCode());
        sb.append("; Request ID: ");
        sb.append(getRequestId());
        sb.append(")");
        return sb.toString();
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorType(ErrorType errorType2) {
        this.errorType = errorType2;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public BceServiceException(String str, Exception exc) {
        super(null, exc);
        this.errorMessage = str;
    }
}
