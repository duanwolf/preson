package com.restrauant.model;

import java.util.List;

/**
 * Created by duanbiwei on 2017/5/16.
 */

public class AListOfGood {
    private String type;
    private int index;
    private List<FoodItem> product;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<FoodItem> getProduct() {
        return product;
    }

    public void setProduct(List<FoodItem> product) {
        this.product = product;
    }
}
