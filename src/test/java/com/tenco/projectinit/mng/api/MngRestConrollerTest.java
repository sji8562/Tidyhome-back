//package com.tenco.projectinit.mng.api;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import com.tenco.projectinit.MyWithRestDoc;
//import com.tenco.projectinit.dto.mng.NoticeRequestDTO;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@SpringBootTest
//public class MngRestConrollerTest extends MyWithRestDoc {
//    @Test
//    public void notice_submit_test() throws Exception {
//        //given
//        NoticeRequestDTO.NoticeSaveDTO requestDTO = new NoticeRequestDTO.NoticeSaveDTO();
//
//
//        requestDTO.setTitle("공지테스트1");
//        requestDTO.setContent("공지테스트111111111");
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
//                        MockMvcRequestBuilders.post("/mng/notice/save-proc")
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
//    }
//}
