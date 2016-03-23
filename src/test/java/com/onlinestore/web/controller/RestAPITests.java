package com.onlinestore.web.controller;

import com.onlinestore.BaseTest;
import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;
import com.onlinestore.model.Item;
import com.onlinestore.model.ItemDetail;
import com.onlinestore.util.Money;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestAPITests extends BaseTest {

    @Test
    public void testGetItems() throws Exception {
        String result = callGet("/rest/store/items?criteria=Book");
        List<Item> actual = getCollectionFromJSon(result, Item.class);

        List<Item> expected = new ArrayList<Item>(2);
        expected.add(new Item("Book123", new Money(100.00f)));
        expected.add(new Item("Book250", new Money(20.99f)));

        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void testGetItem() throws Exception {
        String result = callGet("/rest/store/items/Book123");
        ItemDetail actual = getObjectFromJSon(result, ItemDetail.class);

        ItemDetail expected = new ItemDetail();
        expected.setCode("Book123");
        expected.setPrice(new Money(100.00f));
        expected.setDescription("Hard Cover Book");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddItemCart() throws Exception {
        String result = callPost("/rest/cart/items/Book250");
        Assert.assertEquals("", result);
    }

    @Test
    public void testGetCart() throws Exception {

        callPost("/rest/cart/items/Book123");

        String result = callGet("/rest/cart");
        Cart actual = getObjectFromJSon(result, Cart.class);

        Cart expected = new Cart();
        expected.setId(1);
        List<CartItem> items = new ArrayList<CartItem>(2);
        items.add(new CartItem("Book123", new Money(100.00f), 2, "A", 10f, new Money(110.01f)));
        expected.setItems(items);
        expected.setTotal(new Money(110.01f));

        Assert.assertThat(actual, is(expected));
    }

    // Helper methods
    private String callGet(String uri) throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(uri)).andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        return response.getContentAsString();
    }

    private String callPost(String uri) throws Exception {
        MvcResult mvcResult = mockMvc.perform(post(uri)).andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        return response.getContentAsString();
    }

    private List<Item> getCollectionFromJSon(String json, Class<Item> elementClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, elementClass));
    }

    private <T> T getObjectFromJSon(String json, Class<T> elementClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, elementClass);
    }

}
