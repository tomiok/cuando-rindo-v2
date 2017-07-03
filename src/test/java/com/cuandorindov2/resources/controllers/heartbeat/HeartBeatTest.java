package com.cuandorindov2.resources.controllers.heartbeat;

import com.cuandorindov2.main.resources.HeartBeatController;
import com.cuandorindov2.main.resources.responses.HeartBeatResponse;
import com.cuandorindov2.resources.utils.JsonConverterUtil;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tomaslingotti on 6/29/17.
 */
@RunWith(SpringRunner.class)
public class HeartBeatTest {

    private MockMvc mvcMocked;
    private HeartBeatResponse heartBeatJson;
    private JsonConverterUtil<HeartBeatResponse> converter;

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final String BASE_URL = "/status/heart";

    @Before
    public void setUp() {
        mvcMocked = MockMvcBuilders.standaloneSetup(new HeartBeatController()).build();
        converter = new JsonConverterUtil();
        HeartBeatResponse response = new HeartBeatResponse();
        heartBeatJson = converter.convert("/Users/tomaslingotti/development/cuando-rindo-v2/src/test/resources/heartBeat.json", HeartBeatResponse.class);
    }

    @Test
    public void testCon() {
        Assert.assertThat(heartBeatJson.getStatus(), Matchers.is("UP"));
    }

    @Test
    public void retrieveStatus_and_contentType() throws Exception {
        mvcMocked.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.status", Is.is(heartBeatJson.getStatus())));

    }
}
