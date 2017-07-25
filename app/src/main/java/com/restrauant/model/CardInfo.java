package com.restrauant.model;

import java.io.Serializable;

/**
 * Created by duanbiwei on 2016/12/14.
 */
public class CardInfo implements Serializable {
    private String num;
    private String fullBKName;
    private String shortBkName;
    private String kind;
    private String userName;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFullBKName() {
        return fullBKName;
    }

    public void setFullBKName(String fullBKName) {
        this.fullBKName = fullBKName;
    }

    public String getShortBkName() {
        return shortBkName;
    }

    public void setShortBkName(String shortBkName) {
        this.shortBkName = shortBkName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
