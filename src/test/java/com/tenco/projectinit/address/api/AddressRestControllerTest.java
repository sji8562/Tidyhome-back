package com.tenco.projectinit.address.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenco.projectinit.MyWithRestDoc;
import com.tenco.projectinit.dto.requestdto.AddressInfoChoiceRequestDTO;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.dto.responsedto.AddressInfoResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class AddressRestControllerTest extends MyWithRestDoc {
    @Test
    public void address_add_test() throws Exception {
        //given
        AddressInfoResponseDTO requestDTO = new AddressInfoResponseDTO();
        requestDTO.setAddress("부산 금정구");
        requestDTO.setAddressDetail("장전동 소정로 1번길");
        requestDTO.setUserId(3);
        requestDTO.setChoice(false);


        System.out.println(requestDTO);

        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/address/add")
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
    public void first_address_add_test() throws Exception {
        //given
        AddressInfoChoiceRequestDTO requestDTO = new AddressInfoChoiceRequestDTO();
        requestDTO.setUserId(4);
        requestDTO.setAddressInfoId(1);



        System.out.println(requestDTO);

        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO);

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/address/add/first-address")
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
    public void view_address_list_by_userId() throws Exception {

        //when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/address/list/1")
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
