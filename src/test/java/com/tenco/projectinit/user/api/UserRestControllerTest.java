package com.tenco.projectinit.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenco.projectinit.MyWithRestDoc;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.repository.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserRestControllerTest extends MyWithRestDoc {

    @Test
    public void hello_test() {
        String a = "1234";
        System.out.println(a.chars());
    }


    @Test
    public void join_test() throws Exception {
        //given
        UserRequestDTO.JoinDTO requestDTO = new UserRequestDTO.JoinDTO();

        requestDTO.setTel("01058288562");


        System.out.println(requestDTO);

        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/users/join")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);
        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

    @Test
    public void delete_test() throws Exception {
        //given
        UserRequestDTO.LoginDTO requestDTO = new UserRequestDTO.LoginDTO();

        requestDTO.setTel("01058288562");


        System.out.println(requestDTO);

        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/users/delete")
                                .content(requestBody)
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
    public void userList_test() throws Exception {
        // Given

        // When
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/mng/user/user-list")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // Then

        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

//    @Test
//    public void login_test() throws Exception {
//        UserRestRequest.LoginDTO requestDTO = new UserRestRequest.LoginDTO();
//
//        requestDTO.setLoginId("ssar");
//        requestDTO.setPassword("a12345678!");
//
//        ObjectMapper om = new ObjectMapper();
//        String requestBody = om.writeValueAsString(requestDTO);
//
//        //when
//        ResultActions resultActions =
//                mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/login")
//                                .content(requestBody)
//                                .contentType(MediaType.APPLICATION_JSON)
//                );
//        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
//        System.out.println(responseBody);
//        //then
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(document);
//
//    }

//    @Test
//    public void logout_test() throws Exception {
//
//        //when
//        ResultActions resultActions =
//                mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/logout")
//                                .contentType(MediaType.APPLICATION_JSON)
//                );
//        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
//        System.out.println(responseBody);
//        //then
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(document);
//    }

//    @Test
//    public void pwdupdate_test() throws Exception {
//        UserRestRequest.PwdUpdateDTO requestDTO = new UserRestRequest.PwdUpdateDTO();
//
//        requestDTO.setLoginId("ssar");
//        requestDTO.setPassword("asd8941403!");
//
//        ObjectMapper om = new ObjectMapper();
//        String requestBody = om.writeValueAsString(requestDTO);
//
//        //when
//        ResultActions resultActions =
//                mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/pwdupdate")
//                                .content(requestBody)
//                                .contentType(MediaType.APPLICATION_JSON)
//                );
//        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
//        System.out.println(responseBody);
//        //then
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(document);
//
//    }
//

}