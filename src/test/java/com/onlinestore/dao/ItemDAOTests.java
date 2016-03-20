package com.onlinestore.dao;

import com.onlinestore.BaseTest;
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

    @Test
    public void testGetItems() throws Exception {
        List<Item> items = itemDAO.getItems("%Book%");
        Assert.assertEquals(2, items.size());
    }
}
