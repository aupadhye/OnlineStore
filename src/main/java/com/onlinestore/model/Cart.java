package com.onlinestore.model;

import com.onlinestore.util.Money;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/18/16
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cart implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (id != cart.id) return false;
        if (!items.equals(cart.items)) return false;
        if (!total.equals(cart.total)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + items.hashCode();
        result = 31 * result + total.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
