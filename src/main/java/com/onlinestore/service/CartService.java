package com.onlinestore.service;

import com.onlinestore.model.Cart;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 11:26 AM To change this template use File | Settings | File
 * Templates.
 */
public interface CartService {

    Cart getCart(String userName);

    boolean addCartItem(String userName, String itemCode);

    boolean checkout(String userName);
}
