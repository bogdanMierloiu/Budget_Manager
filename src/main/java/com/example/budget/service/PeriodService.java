package com.example.budget.service;

import com.example.budget.entity.Period;
import com.example.budget.mapper.PeriodMapper;
import com.example.budget.mapper.model.period.PeriodRequest;
import com.example.budget.mapper.model.period.PeriodResponse;
import com.example.budget.repository.PeriodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PeriodService {
    private final PeriodRepository periodRepository;
    private final PeriodMapper mapper;

    public PeriodResponse add(PeriodRequest request) {
        Period period = new Period();
        period.setName(request.getName());
        period.setStartDate(request.getStartDate());
        period.setEndDate(request.getEndDate());
        return mapper.map(periodRepository.save(period));
    }

    public List<PeriodResponse> getAll() {
        return mapper.map(periodRepository.findAll());
    }
    public PeriodResponse findById(Integer id) {
        return mapper.map(periodRepository.findById(id).orElseThrow());
    }
}
