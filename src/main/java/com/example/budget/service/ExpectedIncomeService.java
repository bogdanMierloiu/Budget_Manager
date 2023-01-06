package com.example.budget.service;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.mapper.ExpectedIncomeMapper;
import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeResponse;
import com.example.budget.repository.ExpectedIncomeRepository;
import com.example.budget.repository.PeriodRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
//@RequiredArgsConstructor - I wrote the constructor with final field
public class ExpectedIncomeService {
    private final ExpectedIncomeRepository expectedIncomeRepository;
    private final ExpectedIncomeMapper mapper;
    private final PeriodRepository periodRepository;

    public ExpectedIncomeService(ExpectedIncomeRepository expectedIncomeRepository, ExpectedIncomeMapper mapper,
                                 PeriodRepository periodRepository) {
        this.expectedIncomeRepository = expectedIncomeRepository;
        this.mapper = mapper;
        this.periodRepository = periodRepository;
    }

    public ExpectedIncomeResponse addIncome(ExpectedIncomeRequest income) {
        ExpectedIncome expectedIncome = new ExpectedIncome();
        expectedIncome.setIncomeSource(income.getIncomeSource());
        expectedIncome.setAmount(income.getAmount());
        expectedIncome.setPeriod(periodRepository.findById(income.getPeriodId()).orElseThrow());
        return mapper.map(expectedIncomeRepository.save(expectedIncome));
    }

    public List<ExpectedIncomeResponse> getAllForPeriod(Integer periodId) {
        return mapper.map(expectedIncomeRepository.getAllForPeriod(periodId));
    }

    public Double calculateAmountForPeriod(Integer periodId) {
        List<ExpectedIncome> list = expectedIncomeRepository.getAllForPeriod(periodId);
        Double total = 0.0;
        for (ExpectedIncome response : list) {
            total += response.getAmount();
        }
        return total;
    }
}
