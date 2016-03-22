package com.onlinestore.dao;

import com.onlinestore.BaseTest;
import com.onlinestore.dao.model.CartItemDO;
import com.onlinestore.model.Cart;
import com.onlinestore.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/20/16
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDAOTests extends BaseTest {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private CartDAO cartDAO;

    @Test
    public void testGetItems() throws Exception {
        List<Item> items = itemDAO.getItems("%Book%");
        Assert.assertEquals(2, items.size());
    }

    @Test
    public void testAddItemToCart() throws Exception {
        cartDAO.addItemToCart(new CartItemDO("arun", "Book123"));
    }

    @Test
    public void testGetCart() throws Exception {

        cartDAO.addItemToCart(new CartItemDO("arun", "Book123"));
        Cart cart = cartDAO.getCart("arun");
        Assert.assertEquals(1, cart.getId());
        Assert.assertNotNull(cart.getItems());
        Assert.assertEquals(1, cart.getItems().size());
        Assert.assertEquals("Book123", cart.getItems().get(0).getCode());

    }
}
