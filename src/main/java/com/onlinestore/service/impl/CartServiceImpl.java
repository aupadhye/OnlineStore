package com.onlinestore.service.impl;

import com.onlinestore.dao.CartDAO;
import com.onlinestore.dao.model.CartItemDO;
import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;
import com.onlinestore.service.CartService;
import com.onlinestore.util.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 3:53 PM To change this template use File | Settings | File
 * Templates.
 */
@Component
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Override
    public Cart getCart(String userName) {
        Cart cart = cartDAO.getCart(userName);
        if (cart == null) {
            throw new RuntimeException("Cart cannot be null!");
        }
        Money total = new Money(0f);
        List<CartItem> items = cart.getItems();
        for (CartItem cartItem : items) {
            String category = cartItem.getCategory();
            float tax = getTaxByCategory(category);
            cartItem.setTax(tax);
            Money priceAfterTax = cartItem.getPrice().multiply(1 + tax/100);
            cartItem.setPriceAfterTax(priceAfterTax);
            total = total.add(priceAfterTax);
        }
        cart.setTotal(total);
        return cart;
    }

    @Override
    public void addCartItem(String userName, String itemCode) {
        cartDAO.addItemToCart(new CartItemDO(userName, itemCode));
    }

    @Override
    public void checkout(String userName) {

        // ... checkout code

        cartDAO.clearCart(userName);
    }

    private static float getTaxByCategory(String category){
        if("A".equals(category)) {
            return 10f;
        }
        else if("B".equals(category)) {
            return 20f;
        }
        else if("C".equals(category)) {
            return 0f;
        }
        throw new RuntimeException("Category not supported! " + category);
    }
}
