package com.example.budget.service;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.mapper.CategoryOfExpenseMapper;
import com.example.budget.mapper.model.category.CategoryOfExpenseRequest;
import com.example.budget.mapper.model.category.CategoryOfExpenseResponse;
import com.example.budget.repository.CategoryOfExpenseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryOfExpenseService {

    private final CategoryOfExpenseRepository categoryOfExpenseRepository;
    private final CategoryOfExpenseMapper mapper;

    public CategoryOfExpenseResponse addCategory(CategoryOfExpenseRequest request) {
        CategoryOfExpense categoryOfExpense = new CategoryOfExpense();
        categoryOfExpense.setName(request.getName());
        return mapper.map(categoryOfExpenseRepository.save(categoryOfExpense));
    }
}
