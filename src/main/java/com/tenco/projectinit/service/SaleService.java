package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.dto.mng.payListRequestDTO;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.inteface.SaleJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleJPARepository saleJPARepository;

    // 결제 내역 조회
    public List<Sale> getList () {
        return saleJPARepository.findAllSalesWithUsers();
    }

    // 카테고리 이름
    public List<payListRequestDTO.payListDTO> getCategoryName(List<Sale> saleList) {
        List<String> categoryNames = new ArrayList<>();
        for (Sale sale : saleList) {
            String categoryName = saleJPARepository.findFirstCategoryNameBySaleId(sale.getId());
            categoryNames.add(categoryName);
        }
        List<payListRequestDTO.payListDTO> payList = new ArrayList<>();
        for(int i = 0; i < saleList.size(); i++) {
           payListRequestDTO.payListDTO dto = new payListRequestDTO.payListDTO(saleList.get(i), categoryNames.get(i));
           payList.add(dto);
        }
        return payList;
    }
}
