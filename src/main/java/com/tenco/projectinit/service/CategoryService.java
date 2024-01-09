package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.responsedto.CategoryResponseDTO;
import com.tenco.projectinit.repository.entity.FirstCategory;
import com.tenco.projectinit.repository.entity.SecondCategory;
import com.tenco.projectinit.repository.inteface.FirstCategoryJPARepository;
import com.tenco.projectinit.repository.inteface.OptionJPARepository;
import com.tenco.projectinit.repository.inteface.SecondCategoryJPARepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
