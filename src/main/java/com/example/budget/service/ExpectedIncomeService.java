package com.example.budget.service;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.mapper.ExpectedIncomeMapper;
import com.example.budget.mapper.model.ExpectedIncomeRequest;
import com.example.budget.mapper.model.ExpectedIncomeResponse;
import com.example.budget.repository.ExpectedIncomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
//@RequiredArgsConstructor - I wrote the constructor with final field
public class ExpectedIncomeService {
    private final ExpectedIncomeRepository expectedIncomeRepository;

    private final ExpectedIncomeMapper mapper;

    public ExpectedIncomeService(ExpectedIncomeRepository expectedIncomeRepository, ExpectedIncomeMapper mapper) {
        this.expectedIncomeRepository = expectedIncomeRepository;
        this.mapper = mapper;
    }

    public ExpectedIncomeResponse addIncome(ExpectedIncomeRequest income) {
        ExpectedIncome expectedIncome = new ExpectedIncome();
        expectedIncome.setIncomeSource(income.getIncomeSource());
        expectedIncome.setAmount(income.getAmount());
        return mapper.map(expectedIncomeRepository.save(expectedIncome));
    }
}
