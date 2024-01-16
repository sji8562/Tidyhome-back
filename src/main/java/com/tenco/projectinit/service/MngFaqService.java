package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.repository.inteface.FaqJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MngFaqService {

    @Autowired
    FaqJPARepository faqJPARepository;
    public List<FaqResponseDTO.faqListDTO> findAll() {
        List<FaqResponseDTO.faqListDTO> faqListDTOList = faqJPARepository.findAllWithFaqPart();
        return faqListDTOList;
    }
}
