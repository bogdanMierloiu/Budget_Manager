package com.example.budget.service;

import com.example.budget.entity.ExpectedExpense;
import com.example.budget.mapper.ExpectedExpenseMapper;
import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseResponse;
import com.example.budget.repository.CategoryOfExpenseRepository;
import com.example.budget.repository.ExpectedExpenseRepository;
import com.example.budget.repository.PeriodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpectedExpenseService {
    private final ExpectedExpenseRepository expectedExpenseRepository;
    private final CategoryOfExpenseRepository categoryOfExpenseRepository;
    private final PeriodRepository periodRepository;
    private final ExpectedExpenseMapper mapper;


    public ExpectedExpenseResponse add(ExpectedExpenseRequest request) {
        ExpectedExpense expense = new ExpectedExpense();
        expense.setAmount(request.getAmount());
        expense.setSpentOn(request.getSpentOn());
        expense.setCategory(categoryOfExpenseRepository.findById(request.getCategoryId()).orElseThrow());
        expense.setPeriod(periodRepository.findById(request.getPeriodId()).orElseThrow());
        return mapper.map(expectedExpenseRepository.save(expense));
    }

    public List<ExpectedExpenseResponse> getAllForPeriod(Integer id) {
        return mapper.map(expectedExpenseRepository.getAllForPeriod(id));
    }

    public List<ExpectedExpenseResponse> getAllForCategory(Integer categoryId, Integer periodId) {
        return mapper.map(expectedExpenseRepository.getAllForCategory(categoryId, periodId));
    }

    public Double calculateAmountForPeriod(Integer id) {
        List<ExpectedExpense> expectedExpenseList = expectedExpenseRepository.getAllForPeriod
                (id);
        double total = 0.0;
        for (ExpectedExpense expectedExpense : expectedExpenseList) {
            total += expectedExpense.getAmount();
        }
        return total;
    }
}
