package com.restrauant.model;

/**
 * Created by duanbiwei on 2016/12/7.
 */
public class CardAndPerson {
    private String name;
    private String cardNum;

    public CardAndPerson(String name, String cardNum) {
        this.name = name;
        this.cardNum = cardNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getName() {
        return name;
    }
}
