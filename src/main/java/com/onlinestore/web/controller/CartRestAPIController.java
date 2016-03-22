package com.onlinestore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinestore.model.Cart;
import com.onlinestore.service.CartService;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 3:44 PM To change this template use File | Settings | File
 * Templates.
 */
@Controller
@RequestMapping("/rest")
public class CartRestAPIController {

    @Autowired(required = true)
    CartService cartService;

    @ResponseBody
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public Cart getCartItems() {
        return cartService.getCart(getLoginUserName());
    }

    @ResponseBody
    @RequestMapping(value = "/cart/items/{itemCode}", method = RequestMethod.POST)
    public boolean addCartItem(@PathVariable String itemCode) {
        return cartService.addCartItem(getLoginUserName(), itemCode);
    }

    @ResponseBody
    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
    public boolean checkout() {
        return cartService.checkout(getLoginUserName());
    }

    private String getLoginUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new RuntimeException("Couldn't retrieve authentication!");
        }
        return authentication.getName();
    }
}
