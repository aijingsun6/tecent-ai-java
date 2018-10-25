package org.alking.tecent.ai.domain;

import com.google.gson.annotations.SerializedName;

/**
 *
 *
 */
public class BaseReply<T> {

    @SerializedName("ret")
    private Integer ret;

    @SerializedName("msg")
    private String msg;

    @SerializedName("data")
    private T data;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
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

    public BaseReply() {
    }
}
