package com.ITComponentsStore.RestControllers;

import com.ITComponentsStore.Entity.Category;
import com.ITComponentsStore.Service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/category",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @PostMapping()
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);

    }

    @GetMapping("/{id}")
    Optional<Category> getCategoryById(@PathVariable Long id){
        return  categoryService.getCategoryById(id);
    }
    @GetMapping("/all")
    List<Category> getAll(){
        return categoryService.getListOfCategory();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);

    }


}
