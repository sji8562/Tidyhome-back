package com.tenco.projectinit.service;

import com.tenco.projectinit.repository.entity.Services;
import com.tenco.projectinit.repository.inteface.ServiceJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceJPARepository serviceJPARepository;
    public List<Services> findAll() {
        List<Services> servicesList = serviceJPARepository.findAll();
        return servicesList;
    }
}
