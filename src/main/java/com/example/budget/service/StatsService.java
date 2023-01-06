package com.example.budget.service;

import com.example.budget.mapper.model.PeriodRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StatsService {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;

    private final ExpectedIncomeService expectedIncomeService;
    private final ExpectedExpenseService expectedExpenseService;


    public Double netWorth(PeriodRequest periodRequest) {
        Double amountFromIncome = incomeService.calculateAmountForPeriod(periodRequest);
        Double amountFromExpense = expenseService.calculateAmountForPeriod(periodRequest);
        return (amountFromIncome - amountFromExpense);
    }

//    public Double expectedBalance(PeriodRequest periodRequest) {
//        Double amountFromExpectedIncome = expectedIncomeService.calculateAmountForPeriod(periodRequest);
//        Double amountFromExpectedExpense = expectedExpenseService.calculateAmountForPeriod(periodRequest);
//        return amountFromExpectedIncome - amountFromExpectedExpense;
//    }
//
//    public Double incomeDifference(PeriodRequest periodRequest) {
//        Double amountFromIncome = incomeService.calculateAmountForPeriod(periodRequest);
//        Double amountFromExpectedIncome = expectedIncomeService.calculateAmountForPeriod(periodRequest);
//        return amountFromIncome - amountFromExpectedIncome;
//    }

}
