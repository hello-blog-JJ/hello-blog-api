package com.jj.hello_blog.web.category.controller;

import com.jj.hello_blog.domain.category.dto.CategorySaveDto;
import com.jj.hello_blog.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

import com.jj.hello_blog.domain.category.dto.CategoryResponse;
import com.jj.hello_blog.web.category.form.CategorySaveForm;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    CategoryResponse saveCategory(@Valid @RequestBody CategorySaveForm categorySaveForm) {
        return categoryService.saveCategory(new CategorySaveDto(categorySaveForm.getName()));
    }

    @GetMapping
    List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }
}
