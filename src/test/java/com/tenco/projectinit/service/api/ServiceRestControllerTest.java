package com.tenco.projectinit.service.api;

import com.tenco.projectinit.MyWithRestDoc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class ServiceRestControllerTest extends MyWithRestDoc {
    @Test
    public void service_list_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/service/list")
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);

        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }
}
