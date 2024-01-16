package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.responsedto.FaqPartResponseDTO;
import com.tenco.projectinit.repository.entity.Faq;
import com.tenco.projectinit.repository.inteface.FaqJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    @Autowired
    FaqJPARepository faqJPARepository;


    public List<FaqPartResponseDTO.FaqJoinPartDTO> findAllAndServicesIdAndPartId(Integer id) {
        return faqJPARepository.findAllAndServicesId(id);
    }
    public List<FaqPartResponseDTO.FaqJoinPartDTO> findAllAndServicesIdAndPartId(Integer id, Integer partId) {
        return faqJPARepository.findAllAndServicesIdAndPartId(id,partId);
    }
}
