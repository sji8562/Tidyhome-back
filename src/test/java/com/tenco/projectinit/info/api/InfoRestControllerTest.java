package com.tenco.projectinit.info.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenco.projectinit.MyWithRestDoc;
import com.tenco.projectinit.dto.requestdto.InfoRequestDTO;
import com.tenco.projectinit.dto.responsedto.AddressInfoResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class InfoRestControllerTest extends MyWithRestDoc {

    @Test
    public void info_save_test() throws Exception {
        //given
        InfoRequestDTO.InfoSaveRequestDTO requestDTO = new InfoRequestDTO.InfoSaveRequestDTO();
        requestDTO.setOptionId(1);
        requestDTO.setReservationDate("2024년01월24일(수)");
        requestDTO.setReservationTime("오전 9시 ~ 오전 11시");
        requestDTO.setPet(false);


        System.out.println(requestDTO);

        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/info/save")
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
    public void info_have_param_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/info/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("reservationId","1")
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
    public void info_have_not_param_test() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/info/")
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
