package com.example.budget.controller;

import com.example.budget.mapper.model.period.PeriodRequest;
import com.example.budget.mapper.model.period.PeriodResponse;
import com.example.budget.repository.PeriodRepository;
import com.example.budget.service.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("period")
@RequiredArgsConstructor
public class PeriodController {
    private final PeriodService periodService;
    private final PeriodRepository periodRepository;

    @PostMapping("/add")
    public PeriodResponse add(@RequestBody PeriodRequest periodRequest) {
        return periodService.add(periodRequest);
    }
}