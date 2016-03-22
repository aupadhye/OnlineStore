package com.onlinestore.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;

import com.onlinestore.BaseTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

public class RestAPITests extends BaseTest {

    @Test
    public void simple() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/rest/store/items?criteria=Book")).andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String result = response.getContentAsString();
        Assert.assertEquals("[{\"code\":\"Book123\",\"price\":null},{\"code\":\"Book250\",\"price\":null}]", result);
    }
}
