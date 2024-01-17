package com.tenco.projectinit.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenco.projectinit.MyWithRestDoc;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class ReservationRestControllerTest extends MyWithRestDoc {

    @Test
    void testReservationRegister() throws Exception {
        ReservationRequestDTO.ReservationRegister request = new ReservationRequestDTO.ReservationRegister();

        request.setReservationDate("2024-01-17");
        request.setReservationTime("10:00");
        request.setPet(true);
        request.setOptionId(1);
        request.setAddressInfoId(1);

        System.out.println(request);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(request);

        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/reservation/save")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);

        resultActions
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }
}
