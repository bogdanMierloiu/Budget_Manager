package com.example.budget.service;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.entity.Expense;
import com.example.budget.entity.Period;
import com.example.budget.mapper.ExpenseMapper;
import com.example.budget.mapper.model.expense.ExpectedExpenseResponse;
import com.example.budget.mapper.model.expense.ExpenseRequest;
import com.example.budget.mapper.model.expense.ExpenseResponse;
import com.example.budget.repository.CategoryOfExpenseRepository;
import com.example.budget.repository.ExpenseRepository;
import com.example.budget.repository.PeriodRepository;
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
    private final PeriodRepository periodRepository;

    public ExpenseResponse add(ExpenseRequest request) {
        CategoryOfExpense category = categoryOfExpenseRepository.findById(request.getCategoryId()).orElseThrow();
        Period period = periodRepository.findById(request.getPeriodId()).orElseThrow();
        Expense expense = new Expense();
        if (request.getDate().isAfter(period.getStartDate().minusDays(1))
                && request.getDate().isBefore(period.getEndDate().plusDays(1))) {
            expense.setSpentOn(request.getSpentOn());
            expense.setAmount(request.getAmount());
            expense.setDate(request.getDate());
            expense.setCategory(category);
            expense.setPeriod(period);
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
        return mapper.map(expenseRepository.save(expense));
    }


    public List<ExpenseResponse> getAllForPeriod(Integer id) {
        return mapper.map(expenseRepository.getAllForPeriod(id));
    }
    public List<ExpenseResponse> getAllForCategory(Integer categoryId, Integer periodId) {
        return mapper.map(expenseRepository.getAllForCategory(categoryId, periodId));
    }

    public Double calculateAmountForPeriod(Integer id) {
        List<Expense> list = expenseRepository.getAllForPeriod(id);
        Double total = 0.0;
        for (Expense expense : list) {
            total += expense.getAmount();
        }
        return total;
    }
}
