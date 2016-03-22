package com.onlinestore.model;

import com.onlinestore.util.Money;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 3:36 PM To change this template use File | Settings | File
 * Templates.
 */
public class CartItem extends Item {

    private int id;

    private String category;
    private float tax;
    private Money priceAfterTax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public Money getPriceAfterTax() {
        return priceAfterTax;
    }

    public void setPriceAfterTax(Money priceAfterTax) {
        this.priceAfterTax = priceAfterTax;
    }
}
