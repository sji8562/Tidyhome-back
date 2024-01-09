package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.responsedto.CategoryResponseDTO;
import com.tenco.projectinit.repository.entity.FirstCategory;
import com.tenco.projectinit.repository.entity.SecondCategory;
import com.tenco.projectinit.repository.entity.sub_entity.Option;
import com.tenco.projectinit.repository.inteface.FirstCategoryJPARepository;
import com.tenco.projectinit.repository.inteface.OptionJPARepository;
import com.tenco.projectinit.repository.inteface.SecondCategoryJPARepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private FirstCategoryJPARepository firstCategoryJPARepository;

    @Autowired
    private SecondCategoryJPARepository secondCategoryJPARepository;

    @Autowired
    private OptionJPARepository optionJPARepository;

    public CategoryResponseDTO.FirstCategoryListDTO getFirstCategoryList() {
        List<FirstCategory> firstCategories = firstCategoryJPARepository.findAll();
        List<CategoryResponseDTO.FirstCategoryDTO> firstCategoryDTOS = new ArrayList<>();
        for (FirstCategory firstCategory : firstCategories) {
            CategoryResponseDTO.FirstCategoryDTO firstCategoryDTO = new CategoryResponseDTO.FirstCategoryDTO(firstCategory.getId(), firstCategory.getName());
            firstCategoryDTOS.add(firstCategoryDTO);
        }
        return new CategoryResponseDTO.FirstCategoryListDTO(firstCategoryDTOS);
    }

    public CategoryResponseDTO.SecondCategoryListDTO getSecondCategoryList(Integer firstCategoryId) {
        List<SecondCategory> secondCategories = secondCategoryJPARepository.findByFirstCategoryId(firstCategoryId);
        List<CategoryResponseDTO.SecondCategoryDTO> secondCategoryDTOS = new ArrayList<>();
        for (SecondCategory secondCategory :secondCategories){
            CategoryResponseDTO.SecondCategoryDTO secondCategoryDTO = new CategoryResponseDTO.SecondCategoryDTO(secondCategory.getId(), secondCategory.getName());
            secondCategoryDTOS.add(secondCategoryDTO);
        }
        return new CategoryResponseDTO.SecondCategoryListDTO(secondCategoryDTOS);
    }

    public List<FirstCategory> findAll() {
        return firstCategoryJPARepository.findAll();
    }

    public FirstCategory findFirstCategoryByName(String fCategoryName) {
        return firstCategoryJPARepository.findByName(fCategoryName);
    }

    @Transactional
    public int addFirstCategory(String fCategoryName) {
        return firstCategoryJPARepository.saveByName(fCategoryName);
    }

    public List<SecondCategory> findByFirstCategoryId(int fId) {
        return secondCategoryJPARepository.findByFirstCategoryId(fId);
    }

    @Transactional
    public int deleteFirstCategoryById(int fId) {
        if(firstCategoryJPARepository.existsById(fId)){
            firstCategoryJPARepository.deleteById(fId);
            return 1;
        }
         return 0;
    }

    public SecondCategory findByfirstCategoryNameWithSecondCategoryName(Integer fCategory, String sCategoryName) {
        return secondCategoryJPARepository.findByFirstCategoryIdAndName(fCategory,sCategoryName);
    }

    public int addSecondCategory(Integer fCategoryId, String name) {
        return secondCategoryJPARepository.saveByFirstCategoryIdWithName(fCategoryId,name);
    }

    public SecondCategory findBySecondCategoryId(int sId) {
         return secondCategoryJPARepository.findById(sId);
    }
    public int findOptionBySecondCategoryId(Integer sId){
        return optionJPARepository.findBySecondCategoryIdCounting(sId);
    }

    public int deleteSecondCategoryById(int sId) {
        if(secondCategoryJPARepository.existsById(sId)){
            secondCategoryJPARepository.deleteById(sId);
            return 1;
        }
        return 0;
    }
}
