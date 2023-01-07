package com.example.budget.controller;

import com.example.budget.mapper.model.category.CategoryOfExpenseRequest;
import com.example.budget.mapper.model.category.CategoryOfExpenseResponse;
import com.example.budget.service.CategoryOfExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryOfExpenseController {

    private final CategoryOfExpenseService categoryOfExpenseService;


    @PostMapping("/add")
    public CategoryOfExpenseResponse addCategory(@RequestBody CategoryOfExpenseRequest request) {
        return categoryOfExpenseService.addCategory(request);
    }

    @GetMapping("/all")
    public List<CategoryOfExpenseResponse> getAll() {
        return categoryOfExpenseService.getAll();
    }

    @GetMapping("/find/{id}")
    public CategoryOfExpenseResponse findById(@PathVariable Integer id) {
        return categoryOfExpenseService.findById(id);
    }


}
