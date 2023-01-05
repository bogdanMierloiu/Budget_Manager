package com.example.budget.service;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.mapper.ExpectedIncomeMapper;
import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeResponse;
import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.repository.ExpectedIncomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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
        expectedIncome.setStartDate(income.getStartDate());
        expectedIncome.setEndDate(income.getEndDate());
        return mapper.map(expectedIncomeRepository.save(expectedIncome));
    }

    public List<ExpectedIncomeResponse> getAllForPeriod(PeriodRequest periodRequest) {
        return mapper.map(expectedIncomeRepository.getAllForPeriod(periodRequest.getStartDate(), periodRequest.getEndDate()));
    }

    public Double calculateAmountForPeriod(PeriodRequest periodRequest) {
        List<ExpectedIncome> list = expectedIncomeRepository.getAllForPeriod(periodRequest.getStartDate(), periodRequest.getEndDate());
        Double total = 0.0;
        for (ExpectedIncome response : list) {
            total += response.getAmount();
        }
        return total;
    }
}
