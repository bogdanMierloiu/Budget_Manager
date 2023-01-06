package com.example.budget.controller;

import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeResponse;
import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.service.ExpectedIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("expected-income")
public class ExpectedIncomeController {
    private final ExpectedIncomeService incomeService;

    @PostMapping("/add")
    public ExpectedIncomeResponse addIncome(@RequestBody ExpectedIncomeRequest income) {
        return incomeService.addIncome(income);
    }

    @GetMapping("/get-for-period/{id}")
    public List<ExpectedIncomeResponse> getAllForPeriod(@PathVariable String id) {
        return incomeService.getAllForPeriod(Integer.parseInt(id));
    }

    @GetMapping("/amount-for-period/{id}")
    public Double amountForPeriod(@PathVariable String id) {
        return incomeService.calculateAmountForPeriod(Integer.parseInt(id));
    }


}
