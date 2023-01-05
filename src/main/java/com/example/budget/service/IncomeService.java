package com.example.budget.service;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.entity.Income;
import com.example.budget.mapper.ExpectedIncomeMapper;
import com.example.budget.mapper.IncomeMapper;
import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeResponse;
import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.income.IncomeResponse;
import com.example.budget.repository.ExpectedIncomeRepository;
import com.example.budget.repository.IncomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
//@RequiredArgsConstructor - I wrote the constructor with final field
public class IncomeService {
    private final IncomeRepository incomeRepository;

    private final IncomeMapper mapper;

    public IncomeService(IncomeRepository incomeRepository, IncomeMapper mapper) {
        this.incomeRepository = incomeRepository;
        this.mapper = mapper;
    }

    public IncomeResponse addIncome(IncomeRequest request) {
        Income income = new Income();
        income.setIncomeSource(request.getIncomeSource());
        income.setAmount(request.getAmount());
        income.setDate(request.getDate());
        return mapper.map(incomeRepository.save(income));
    }

    public List<IncomeResponse> getAllForPeriod(PeriodRequest periodRequest) {
        return mapper.map(incomeRepository.getAllForPeriod(periodRequest.getStartDate(), periodRequest.getEndDate()));
    }

    public Double calculateAmountForPeriod(PeriodRequest periodRequest) {
        List<Income> list = incomeRepository.getAllForPeriod(periodRequest.getStartDate(), periodRequest.getEndDate());
        Double total = 0.0;
        for (Income income : list) {
            total += income.getAmount();
        }
        return total;
    }
}
