package com.example.budget.controller;

import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseResponse;
import com.example.budget.service.ExpectedExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("expected-expense")
@RequiredArgsConstructor
public class ExpectedExpenseController {

    private final ExpectedExpenseService expectedExpenseService;

    @PostMapping("/add")
    public ExpectedExpenseResponse add(@RequestBody ExpectedExpenseRequest request) {
        return expectedExpenseService.add(request);
    }

    @GetMapping("get-for-period/{id}")
    public List<ExpectedExpenseResponse> getAllForPeriod(@PathVariable Integer id) {
        return expectedExpenseService.getAllForPeriod(id);
    }

    @GetMapping("/amount-for-period/{id}")
    public Double amountForPeriod(@PathVariable Integer id) {
        return expectedExpenseService.calculateAmountForPeriod(id);
    }
}
