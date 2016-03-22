package com.onlinestore.dao;

import com.onlinestore.dao.model.CartItemDO;
import com.onlinestore.model.Cart;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 9:45 PM To change this template use File | Settings | File
 * Templates.
 */
@Component
public interface CartDAO {

    Cart getCart(String userName);

//    Cart getCartItems(String userName);

    void createCart(String userName, Cart cart);

    void addItemToCart(CartItemDO cartItemDO);

    boolean clearCart(String userName);

}
