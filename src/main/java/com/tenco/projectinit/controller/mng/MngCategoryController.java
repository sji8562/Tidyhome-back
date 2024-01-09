package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.repository.entity.FirstCategory;
import com.tenco.projectinit.repository.entity.SecondCategory;
import com.tenco.projectinit.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/mng/category")
public class MngCategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("categories")
    public String categoryList(Model model) {
        List<FirstCategory> firstCategoryList = categoryService.findAll();
        model.addAttribute("firstCategoryList", firstCategoryList);
        return "/mng/category/categories";
    }


    // 카테고리 등록(대여/판매)
    @PostMapping("addFirstCategory")
    @ResponseBody
    public List<FirstCategory> addFirstCategory(@RequestBody Map<String, String> categoryName) {
        try {
            String fCategoryName = categoryName.get("categoryName");

            FirstCategory firstCategory = categoryService.findFirstCategoryByName(fCategoryName);
            if (firstCategory != null) {
                throw new Exception500("이미 존재하는 카테고리입니다");
            }

            int result = categoryService.addFirstCategory(fCategoryName);

            if (result != 1) {
                throw new Exception500("카테고리 등록에 실패했습니다.");
            }
            List<FirstCategory> firstCategoryList =categoryService.findAll();
            return firstCategoryList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 대여용
    // 1차 카테고리 삭제
    @GetMapping("/delete-first-category/{fId}")
    public List<FirstCategory> deleteFirstCategory(@PathVariable int fId) {
        try{
            // 해당 카테고리의 하위 항목이 있는지 확인
            List<SecondCategory> secondCategories = categoryService.findByFirstCategoryId(fId);
            if (!secondCategories.isEmpty()) {
                throw new Exception500("하위 카테고리가 존재합니다");
            }
            int result = categoryService.deleteFirstCategoryById(fId);
            if(result != 1){
                throw new Exception500("카테고리 삭제에 실패했습니다.");
            }
            return categoryService.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
//    @GetMapping("second-category-find-by-first-category/{fId}")
//    @ResponseBody
//    public List<SecondCategory> getScondCategoryfindByFirstCategoryId(@PathVariable String fId) {
//
//        try {
//            if(fId == null|| fId.isEmpty()){
//                throw new Exception500("id값이 없습니다");
//            }
//            List<SecondCategory> secondCategory = categoryService.findSecondCategoryByFirstCategoryId(fId);
//            return secondCategory;
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}
