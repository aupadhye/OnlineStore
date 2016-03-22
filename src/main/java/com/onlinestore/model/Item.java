package com.onlinestore.model;

import com.onlinestore.util.Money;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 10:02 AM To change this template use File | Settings | File
 * Templates.
 */
public class Item {

    private String code;
    private Money  price;

    public Item() {
    }

    public Item(String code, Money price) {
        this.code = code;
        this.price = price;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (!code.equals(item.code)) return false;
        if (!price.equals(item.price)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
