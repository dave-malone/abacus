package io.dmalone.abacus.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.dmalone.abacus.AbacusApplication;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AbacusApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class HomeControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(
                new HomeController())
            .build();
    }

    @Test
    public void getHome() throws Exception {
    	Map<String, String> expectedRequestHeadersModelAttribute = new HashMap<String, String>();
    	expectedRequestHeadersModelAttribute.put("test-header", "abcdefg");
    	
        mvc.perform(MockMvcRequestBuilders
            .get("/")
            .header("test-header", "abcdefg"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("serverTime"))
            .andExpect(model().attributeExists("requestHeaders"))
            .andExpect(model().attributeExists("name"))
            .andExpect(model().attribute("requestHeaders", expectedRequestHeadersModelAttribute))
            .andExpect(forwardedUrl("home"));
    }
}
