package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.CategoryResponseDTO;
import com.tenco.projectinit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/first")
    public ResponseEntity<?> firstCategoryList() {
        CategoryResponseDTO.FirstCategoryListDTO firstCategoryListDTO = categoryService.getFirstCategoryList();
        return ResponseEntity.ok().body(ApiUtils.success(firstCategoryListDTO));
    }

    @GetMapping("/second")
    public ResponseEntity<?> secondCategoryList(@RequestParam Integer firstCategoryId){
        CategoryResponseDTO.SecondCategoryListDTO secondCategoryList = categoryService.getSecondCategoryList(firstCategoryId);
        return ResponseEntity.ok().body(ApiUtils.success(secondCategoryList));
    }
}
