//package com.tenco.projectinit.mng;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@SpringBootTest
//public class MngConrollerTest {
//    @Test
//    public void join_test() throws Exception {
//        //given
//        UserRequestDTO.JoinDTO requestDTO = new UserRequestDTO.JoinDTO();
//
//        requestDTO.setTel("01058288562");
//
//
//        System.out.println(requestDTO);
//
//        ObjectMapper om = new ObjectMapper();
//        String requestBody = om.writeValueAsString(requestDTO);
//
//        //when
//        ResultActions resultActions =
//                mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/users/join")
//                                .content(requestBody)
//                                .contentType(MediaType.APPLICATION_JSON)
//                );
//        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
//        System.out.println(responseBody);
//        //then
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(document);
//    }
//}
