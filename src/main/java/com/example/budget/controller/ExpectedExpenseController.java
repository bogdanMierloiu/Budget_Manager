package com.example.budget.controller;

import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseResponse;
import com.example.budget.service.ExpectedExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Period;

@RestController
@RequestMapping("expected-expense")
@RequiredArgsConstructor
public class ExpectedExpenseController {

    private final ExpectedExpenseService expectedExpenseService;

    @PostMapping("/add")
    public ExpectedExpenseResponse add(@RequestBody ExpectedExpenseRequest request) {
        return expectedExpenseService.add(request);
    }

    @GetMapping("/amount-for-period")
    public Double amountForPeriod(@RequestBody PeriodRequest request) {
        return expectedExpenseService.calculateAmountForPeriod(request);
    }
}
