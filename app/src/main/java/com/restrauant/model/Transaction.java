package com.restrauant.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by duanbiwei on 2016/12/9.
 */
public class Transaction {
    private String name;
    private String details;

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {

        return time;
    }

    public String getDetails() {

        return details;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    private String time;
    private String price;

    public Transaction(String name, String details, String price, Date date) {
        this.name = name;
        this.details = details;
        this.price = price;
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.time = format.format(date);
    }
}
