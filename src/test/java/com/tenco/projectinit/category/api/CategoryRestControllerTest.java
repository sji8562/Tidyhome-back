package com.tenco.projectinit.category.api;

import com.tenco.projectinit.MyWithRestDoc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class CategoryRestControllerTest extends MyWithRestDoc {
    @Test
    public void first_category_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/category/first")
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
    @Test
    public void second_category_by_1_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/category/second")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("firstCategoryId","1")
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
    @Test
    public void second_category_by_2_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/category/second")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("firstCategoryId","2")
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
    @Test
    public void second_category_by_3_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/category/second")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("firstCategoryId","3")
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
