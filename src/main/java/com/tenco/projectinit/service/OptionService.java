package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.responsedto.OptionResponseDTO;
import com.tenco.projectinit.repository.entity.sub_entity.Option;
import com.tenco.projectinit.repository.inteface.OptionJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionJPARepository optionJPARepository;


    public OptionResponseDTO.OptionDetail getOptionDetail(Integer secondCategoryId) {
        List<Option> options = optionJPARepository.findBySecondCategoryId(secondCategoryId);
        List<OptionResponseDTO.OptionPrice> optionPrices = new ArrayList<>();

        for(Option option :options){
            OptionResponseDTO.OptionPrice optionPrice = new OptionResponseDTO.OptionPrice(option.getId(), option.getName(), option.getPrice());
            optionPrices.add(optionPrice);
        }

        return new OptionResponseDTO.OptionDetail(optionPrices);
    }
}
