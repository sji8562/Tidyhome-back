package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.repository.entity.FaqPart;
import com.tenco.projectinit.repository.inteface.FaqJPARepository;
import com.tenco.projectinit.repository.inteface.FaqPartJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MngFaqService {

    @Autowired
    FaqJPARepository faqJPARepository;

    @Autowired
    FaqPartJPARepository faqPartJPARepository;

    public List<FaqResponseDTO.FaqListDTO> findAll() {
        List<FaqResponseDTO.FaqListDTO> faqListDTOList = faqJPARepository.findAllWithFaqPart();
        return faqListDTOList;
    }

    public FaqPart getDetail(int id) {
        return faqPartJPARepository.findById(id).orElse(null);
    }

    public void deleteFaq(int id) {
        faqPartJPARepository.deleteById(id);
    }

}
