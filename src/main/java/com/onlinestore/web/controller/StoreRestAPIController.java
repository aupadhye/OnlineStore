package com.onlinestore.web.controller;

import java.util.List;

import com.onlinestore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinestore.model.Item;
import com.onlinestore.model.ItemDetail;

@Controller
@RequestMapping("/rest")
public class StoreRestAPIController {

    @Autowired(required = true)
    StoreService storeService;

    @ResponseBody
    @RequestMapping(value = "/store/items", method = RequestMethod.GET)
    public List<Item> searchItems(@RequestParam String criteria) {
        return storeService.searchItems(criteria);
    }

    @ResponseBody
    @RequestMapping(value = "/store/items/{itemCode}", method = RequestMethod.GET)
    public ItemDetail getItem(@PathVariable("itemCode") String itemCode) {
        return storeService.getItem(itemCode);
    }
}