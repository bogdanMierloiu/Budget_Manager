package com.example.budget.controller;

import com.example.budget.mapper.model.category.CategoryOfExpenseRequest;
import com.example.budget.mapper.model.category.CategoryOfExpenseResponse;
import com.example.budget.service.CategoryOfExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryOfExpenseController {

    private final CategoryOfExpenseService categoryOfExpenseService;


    @PostMapping("/add")
    public CategoryOfExpenseResponse addCategory(@RequestBody CategoryOfExpenseRequest request) {
        return categoryOfExpenseService.addCategory(request);
    }

}
