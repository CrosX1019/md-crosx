package com.root.crosx.bean;

import java.io.Serializable;

/**
 * Created by CrosX on 2017/6/23.
 */

public class BaseResult<T> implements Serializable {

    private boolean success;

    private String msg;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
