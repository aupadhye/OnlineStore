package com.onlinestore.model;

import com.onlinestore.util.Money;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/18/16
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cart {

    private int id;
    private List<CartItem> items;
    private Money total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Money getTotal() {
        return total;
    }

    public void setTotal(Money total) {
        this.total = total;
    }
}
