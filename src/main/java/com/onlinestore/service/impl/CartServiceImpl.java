package com.onlinestore.service.impl;

import org.springframework.stereotype.Component;

import com.onlinestore.model.Cart;
import com.onlinestore.service.CartService;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 3:53 PM To change this template use File | Settings | File
 * Templates.
 */
@Component
public class CartServiceImpl implements CartService {

    @Override
    public Cart getCart(String userName) {
        return null; // To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean addCartItem(String userName, String itemCode) {
        return false; // To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean checkout(String userName) {
        return false; // To change body of implemented methods use File | Settings | File Templates.
    }
}
