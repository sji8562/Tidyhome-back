package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit._core.errors.exception.CustomRestfullException;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.repository.entity.FirstCategory;
import com.tenco.projectinit.repository.entity.SecondCategory;
import com.tenco.projectinit.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("second-category-find-by-first-category/{fId}")
    @ResponseBody

    public List<SecondCategory> getScondCategoryfindByFirstCategoryId(@PathVariable Integer fId) {

        try {
            if (fId == null) {
                throw new Exception500("id값이 없습니다");
            }
            List<SecondCategory> secondCategory = categoryService.findByFirstCategoryId(fId);
            return secondCategory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
            List<FirstCategory> firstCategoryList = categoryService.findAll();
            return firstCategoryList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //2차 카테고리 추가
    @PostMapping("addSecondCategory")
    @ResponseBody
    public List<SecondCategory> addSecondCategory(@RequestBody Map<String, String> postData) {
        try {
            String sCategoryName = postData.get("categoryName");
            Integer fCategoryId = Integer.parseInt(postData.get("selectedFirstCategory"));


            // 같은 이름의 카테고리가 있는지 확인
            SecondCategory secondCategory = categoryService.findByfirstCategoryNameWithSecondCategoryName(fCategoryId, sCategoryName);
            if (secondCategory != null) {
                throw new Exception500("이미 존재하는 카테고리입니다");
            }
            int result = categoryService.addSecondCategory(fCategoryId, sCategoryName);
            if (result != 1) {
                throw new Exception500("카테고리 생성에 실패했습니다.");
            }
            return categoryService.findByFirstCategoryId(fCategoryId);
//return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // 대여용
    // 1차 카테고리 삭제
    @GetMapping("/delete-first-category/{fId}")
    public List<FirstCategory> deleteFirstCategory(@PathVariable int fId) {
        try {
            // 해당 카테고리의 하위 항목이 있는지 확인
            List<SecondCategory> secondCategories = categoryService.findByFirstCategoryId(fId);
            if (!secondCategories.isEmpty()) {
                throw new Exception500("하위 카테고리가 존재합니다");
            }
            int result = categoryService.deleteFirstCategoryById(fId);
            if (result != 1) {
                throw new Exception500("카테고리 삭제에 실패했습니다.");
            }
            return categoryService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    //    List<FirstCategory>
    @GetMapping("/delete-second-category/{sId}")
    public void deleteSecondCategoryById(@PathVariable int sId) {
        try {
            System.out.println("--- 2차 카테고리 삭제 ---" + sId);
            // 해당 카테고리가 존재하는지 확인
            SecondCategory secondCategory = categoryService.findBySecondCategoryId(sId);
            if(secondCategory == null){
                throw new CustomRestfullException("없는 카테고리입니다.", HttpStatus.BAD_REQUEST);
            }

            // 해당 카테고리에 등록된 상품이 있는지 확인
            int resultRows = categoryService.findOptionBySecondCategoryId(sId);
            System.out.println(resultRows);

            if (resultRows > 0) {
                throw new CustomRestfullException("해당 카테고리에 등록된 상품이 있습니다.", HttpStatus.BAD_REQUEST);
            }
            System.out.println("여긴여긴??");
            int result = categoryService.deleteSecondCategoryById(sId);
            if (result != 1) {
                throw new CustomRestfullException("삭제하지 못했습니다.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}