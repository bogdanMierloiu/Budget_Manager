package com.example.budget.service;

import com.example.budget.entity.ExpectedExpense;
import com.example.budget.entity.Expense;
import com.example.budget.repository.ExpectedExpenseRepository;
import com.example.budget.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StatsService {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;

    private final ExpectedIncomeService expectedIncomeService;
    private final ExpectedExpenseService expectedExpenseService;

    private final ExpectedExpenseRepository expectedExpenseRepository;

    private final ExpenseRepository expenseRepository;


    public Double netWorth(Integer periodId) {
        Double amountFromIncome = incomeService.calculateAmountForPeriod(periodId);
        Double amountFromExpense = expenseService.calculateAmountForPeriod(periodId);
        return (amountFromIncome - amountFromExpense);
    }

    public Double expectedBalance(Integer periodId) {
        Double amountFromExpectedIncome = expectedIncomeService.calculateAmountForPeriod(periodId);
        Double amountFromExpectedExpense = expectedExpenseService.calculateAmountForPeriod(periodId);
        return amountFromExpectedIncome - amountFromExpectedExpense;
    }

    public Double incomeDifference(Integer periodId) {
        Double amountFromIncome = incomeService.calculateAmountForPeriod(periodId);
        Double amountFromExpectedIncome = expectedIncomeService.calculateAmountForPeriod(periodId);
        return amountFromIncome - amountFromExpectedIncome;
    }

    public Double expenseDifference(Integer periodId) {
        Double amountFromExpectedExpense = expectedExpenseService.calculateAmountForPeriod(periodId);
        Double amountFromExpense = expenseService.calculateAmountForPeriod(periodId);
        return amountFromExpectedExpense - amountFromExpense;
    }

    public Double amountExpectedExpenseForCategory(Integer categoryId, Integer periodId) {
        List<ExpectedExpense> list = expectedExpenseRepository.getAllForCategory(categoryId, periodId);
        double total = 0.0;
        for (ExpectedExpense expectedExpense : list) {
            total += expectedExpense.getAmount();
        }
        return total;
    }

    public Double amountExpenseForCategory(Integer categoryId, Integer periodId) {
        List<Expense> list = expenseRepository.getAllForCategory(categoryId, periodId);
        double total = 0.0;
        for (Expense expense : list) {
            total += expense.getAmount();
        }
        return total;
    }

}
