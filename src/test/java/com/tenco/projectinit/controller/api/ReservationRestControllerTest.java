package com.tenco.projectinit.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenco.projectinit.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReservationService reservationService;

    @Test
    public void GetUserReservationInfo_test() throws Exception {
        // Given
        Integer userId = 1;

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/reservation/user/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
        // 여기에 추가적인 검증 로직을 추가하십시오.
    }
}
