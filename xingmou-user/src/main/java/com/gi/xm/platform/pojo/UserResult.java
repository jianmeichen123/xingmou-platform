//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gi.xm.platform.pojo;


import com.gi.xm.platform.pojo.User;

public class UserResult {
    private boolean success;
    private String errorCode;
    private String message;
    private User value;

    public UserResult() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getValue() {
        return this.value;
    }

    public void setValue(User value) {
        this.value = value;
    }

    public String toString() {
        return "AuthResult [success=" + this.success + ", errorCode=" + this.errorCode + ", message=" + this.message + ", value=" + this.value + "]";
    }
}
