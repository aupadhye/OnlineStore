package com.onlinestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlinestore.dao.ItemDAO;
import com.onlinestore.model.Item;
import com.onlinestore.model.ItemDetail;
import com.onlinestore.service.StoreService;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 3:54 PM To change this template use File | Settings | File
 * Templates.
 */
@Component
public class StoreServiceImpl implements StoreService {

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public List<Item> searchItems(String criteria) {
        return itemDAO.getItems("%" + criteria + "%");
    }

    @Override
    public ItemDetail getItem(String itemCode) {
        return itemDAO.getItem(itemCode);
    }
}
