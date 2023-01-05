package com.example.budget.controller;

import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.mapper.model.expense.ExpenseRequest;
import com.example.budget.mapper.model.expense.ExpenseResponse;
import com.example.budget.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("add")
    public ExpenseResponse add(@RequestBody ExpenseRequest request) {
        return expenseService.add(request);
    }

    @GetMapping("get-for-period")
    public List<ExpenseResponse> getAllForPeriod(@RequestBody PeriodRequest request) {
        return expenseService.getAllForPeriod(request);
    }

    @GetMapping("amount-for-period")
    public Double amountForPeriod(@RequestBody PeriodRequest request) {
        return expenseService.calculateAmountForPeriod(request);
    }

}
