package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.requestdto.RequestRequestDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;
import com.tenco.projectinit.repository.entity.EtcInfo;
import com.tenco.projectinit.repository.inteface.RequestJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {
    @Autowired
    private RequestJPARepository requestJPARepository;
    @Transactional
    public RequestResponseDTO.RequestDTO request(RequestRequestDTO.EtcDTO etcDTO) {
        // 기타사항 아이디 찾기
        Integer etcInfoId = etcDTO.getEtcInfoId();
        // 아이디 찾아서
        return request(etcDTO);
    }
}

