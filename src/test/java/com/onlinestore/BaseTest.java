package com.onlinestore;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/20/16 Time: 9:24 AM To change this template use File | Settings | File
 * Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/applicationContext.xml",
// "file:src/main/webapp/WEB-INF/applicationContext-security.xml",
        "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class BaseTest {

    protected MockMvc               mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @After
    public void tearDown() {
    }
}
