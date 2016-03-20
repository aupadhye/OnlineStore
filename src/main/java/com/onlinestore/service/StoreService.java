package com.onlinestore.service;

import java.util.List;

import com.onlinestore.model.Item;
import com.onlinestore.model.ItemDetail;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 11:26 AM To change this template use File | Settings | File
 * Templates.
 */
public interface StoreService {

    List<Item> searchItems(String criteria);

    ItemDetail getItem(String itemCode);
}
