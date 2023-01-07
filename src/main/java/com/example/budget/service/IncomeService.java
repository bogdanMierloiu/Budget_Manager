package com.example.budget.service;

import com.example.budget.entity.Income;
import com.example.budget.entity.Period;
import com.example.budget.mapper.IncomeMapper;
import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.income.IncomeResponse;
import com.example.budget.repository.IncomeRepository;
import com.example.budget.repository.PeriodRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
//@RequiredArgsConstructor - I wrote the constructor with final field
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeMapper mapper;
    private final PeriodRepository periodRepository;

    public IncomeService(
            IncomeRepository incomeRepository, IncomeMapper mapper, PeriodRepository periodRepository
    ) {
        this.incomeRepository = incomeRepository;
        this.mapper = mapper;
        this.periodRepository = periodRepository;
    }

    public IncomeResponse addIncome(IncomeRequest request) {
        Period period = periodRepository.findById(request.getPeriodId()).orElseThrow();
        Income income = new Income();
        if (request.getDate().isAfter(period.getStartDate().minusDays(1))
                && request.getDate().isBefore(period.getEndDate().plusDays(1))) {
            income.setIncomeSource(request.getIncomeSource());
            income.setAmount(request.getAmount());
            income.setDate(request.getDate());
            income.setPeriod(period);
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
        return mapper.map(incomeRepository.save(income));
    }

    public List<IncomeResponse> getAllForPeriod(Integer periodId) {
        return mapper.map(incomeRepository.getAllForPeriod(periodId));
    }

    public Double calculateAmountForPeriod(Integer periodId) {
        List<Income> list = incomeRepository.getAllForPeriod(periodId);
        Double total = 0.0;
        for (Income income : list) {
            total += income.getAmount();
        }
        return total;
    }
}
