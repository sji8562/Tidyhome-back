package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.inteface.PartnerJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PartnerService {

    @Autowired
    private PartnerJPARepository partnerJPARepository;

    public List<Partner> findAll() {
        List<Partner> partnerList = partnerJPARepository.findAll();
        if(partnerList.isEmpty() || partnerList == null){
            throw new Exception500("파트너가 없습니다.");
        }
        return partnerList;
    }
    public Page<Partner> findByPageNation(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<Partner> partnerPG = partnerJPARepository.findAll(pageable);
        if(partnerPG.isEmpty() || partnerPG == null){
            throw new Exception500("파트너가 없습니다.");
        }
        return partnerPG;
    }

    public Page<Partner> findByPageNation(Integer page,String keyword) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<Partner> partnerPG = partnerJPARepository.findByUsernameContaining(keyword,pageable);
        if(partnerPG.isEmpty() || partnerPG == null){
            throw new Exception500("파트너가 없습니다.");
        }
        return partnerPG;

    }


}
