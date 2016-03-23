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

    public CartItem() {
        super();
    }

    public CartItem(int id, String category, float tax, Money priceAfterTax) {
        this.id = id;
        this.category = category;
        this.tax = tax;
        this.priceAfterTax = priceAfterTax;
    }

    public CartItem(String code, Money price, int id, String category, float tax, Money priceAfterTax) {
        super(code, price);
        this.id = id;
        this.category = category;
        this.tax = tax;
        this.priceAfterTax = priceAfterTax;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem)) return false;
        if (!super.equals(o)) return false;

        CartItem cartItem = (CartItem) o;

        if (id != cartItem.id) return false;
        if (Float.compare(cartItem.tax, tax) != 0) return false;
        if (!category.equals(cartItem.category)) return false;
        if (!priceAfterTax.equals(cartItem.priceAfterTax)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + category.hashCode();
        result = 31 * result + (tax != +0.0f ? Float.floatToIntBits(tax) : 0);
        result = 31 * result + priceAfterTax.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                super.toString() +
                ", id=" + id +
                ", category='" + category + '\'' +
                ", tax=" + tax +
                ", priceAfterTax=" + priceAfterTax +
                '}';
    }
}
