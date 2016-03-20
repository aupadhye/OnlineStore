package com.onlinestore.dao;

import java.util.List;

import com.onlinestore.model.Cart;
import com.onlinestore.model.Item;
import com.onlinestore.model.ItemDetail;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 9:45 PM To change this template use File | Settings | File
 * Templates.
 */
@Component
public interface CartDAO {

    Cart getCart(String userName);

    void createCart(String userName, Cart cart);

    boolean addItemToCart(String userName, Item item);

    boolean clearCart(String userName);

}
