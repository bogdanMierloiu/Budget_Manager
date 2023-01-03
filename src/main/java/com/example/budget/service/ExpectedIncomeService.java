package com.example.budget.service;

import com.example.budget.entity.ExpectedMonthlyIncome;
import com.example.budget.repository.ExpectedIncomeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
//@RequiredArgsConstructor - I wrote the constructor with final field
public class ExpectedIncomeService {
    private final ExpectedIncomeRepository expectedIncomeRepository;

    public ExpectedIncomeService(ExpectedIncomeRepository expectedIncomeRepository) {
        this.expectedIncomeRepository = expectedIncomeRepository;
    }

    public ExpectedMonthlyIncome addIncome(ExpectedMonthlyIncome income) {
        ExpectedMonthlyIncome expectedMonthlyIncome = new ExpectedMonthlyIncome();
        expectedMonthlyIncome.setIncomeSource(income.getIncomeSource());
        expectedMonthlyIncome.setAmount(income.getAmount());
        return expectedIncomeRepository.save(expectedMonthlyIncome);
    }
}
