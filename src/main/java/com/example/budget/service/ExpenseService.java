package com.example.budget.service;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.entity.Expense;
import com.example.budget.mapper.ExpenseMapper;
import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.expense.ExpenseRequest;
import com.example.budget.mapper.model.expense.ExpenseResponse;
import com.example.budget.repository.CategoryOfExpenseRepository;
import com.example.budget.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final CategoryOfExpenseRepository categoryOfExpenseRepository;

    private final ExpenseMapper mapper;

    public ExpenseResponse add(ExpenseRequest request) {
        CategoryOfExpense category = categoryOfExpenseRepository.findById(request.getCategoryId()).orElseThrow();
        Expense expense = new Expense();
        expense.setDate(request.getDate());
        expense.setSpentOn(request.getSpentOn());
        expense.setAmount(request.getAmount());
        expense.setCategory(category);
        return mapper.map(expenseRepository.save(expense));
    }

    public List<ExpenseResponse> getAllForPeriod(PeriodRequest request) {
        return mapper.map(expenseRepository.getAllForPeriod(request.getStartDate(), request.getEndDate()));
    }

    public Double calculateAmountForPeriod(PeriodRequest request) {
        List<Expense> list = expenseRepository.getAllForPeriod(request.getStartDate(), request.getEndDate());
        Double total = 0.0;
        for (Expense expense : list) {
            total += expense.getAmount();
        }
        return total;
    }
}
