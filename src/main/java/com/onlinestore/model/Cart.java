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

    private List<CartItem> items;
    private Money totalPrice;
}
