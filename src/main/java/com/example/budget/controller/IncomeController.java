package com.example.budget.controller;

import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeResponse;
import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.income.IncomeResponse;
import com.example.budget.service.ExpectedIncomeService;
import com.example.budget.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("income")
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping("/add")
    public IncomeResponse addIncome(@RequestBody IncomeRequest income) {
        return incomeService.addIncome(income);
    }

    @GetMapping("/get-for-period")
    public List<IncomeResponse> getAllForPeriod(@RequestBody PeriodRequest periodRequest) {
        return incomeService.getAllForPeriod(periodRequest);
    }

    @GetMapping("/amount-for-period")
    public Double amountForPeriod(@RequestBody PeriodRequest periodRequest) {
        return incomeService.calculateAmountForPeriod(periodRequest);
    }


}
