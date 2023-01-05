package com.example.budget.service;

import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.repository.IncomeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StatsService {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;


    public Double netWorth(PeriodRequest periodRequest) {
        Double amountFromIncome = incomeService.calculateAmountForPeriod(periodRequest);
        Double amountFromExpense = expenseService.calculateAmountForPeriod(periodRequest);
        return (amountFromIncome - amountFromExpense);

    }
}
