package com.onlinestore.model;

import com.onlinestore.util.Money;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 10:02 AM To change this template use File | Settings | File
 * Templates.
 */
public class Item {

    private String code;
    private Money  price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
