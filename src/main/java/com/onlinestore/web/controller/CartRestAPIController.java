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
 * Controller to only expose service as REST API.
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
    public void addCartItem(@PathVariable String itemCode) {
        cartService.addCartItem(getLoginUserName(), itemCode);
    }

    @ResponseBody
    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
    public void checkout() {
        cartService.checkout(getLoginUserName());
    }

    private String getLoginUserName() {
        // TODO security
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            throw new RuntimeException("Couldn't retrieve authentication!");
//        }
//        return authentication.getName();

        return "arun";
    }
}
