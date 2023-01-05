package com.example.budget.service;

import com.example.budget.entity.ExpectedExpense;
import com.example.budget.mapper.ExpectedExpenseMapper;
import com.example.budget.mapper.model.expense.ExpectedExpenseRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseResponse;
import com.example.budget.repository.CategoryOfExpenseRepository;
import com.example.budget.repository.ExpectedExpenseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpectedExpenseService {

    private final ExpectedExpenseRepository expectedExpenseRepository;

    private final CategoryOfExpenseRepository categoryOfExpenseRepository;

    private final ExpectedExpenseMapper mapper;


    public ExpectedExpenseResponse add(ExpectedExpenseRequest request) {
        ExpectedExpense expense = new ExpectedExpense();
        expense.setAmount(request.getAmount());
        expense.setSpentOn(request.getSpentOn());
        expense.setCategory(categoryOfExpenseRepository.findById(request.getCategoryId()).orElseThrow());
        expense.setStartDate(request.getStartDate());
        expense.setEndDate(request.getEndDate());
        return mapper.map(expectedExpenseRepository.save(expense));
    }
}
