package com.example.demo.webSocket;

/**
 * Created by hello on 2018/4/11.
 */

public class ContentVo {
    private String own;
    private String msg;
    private String time;

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTo(String own) {
        this.own = own;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTo() {
        return own;
    }

    public String getMsg() {
        return msg;
    }
}