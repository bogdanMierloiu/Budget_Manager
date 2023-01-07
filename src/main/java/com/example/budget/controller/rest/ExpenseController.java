package com.example.budget.controller.rest;

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

    @GetMapping("get-for-period/{id}")
    public List<ExpenseResponse> getAllForPeriod(@PathVariable Integer id) {
        return expenseService.getAllForPeriod(id);
    }

    @GetMapping("amount-for-period/{id}")
    public Double amountForPeriod(@PathVariable Integer id) {
        return expenseService.calculateAmountForPeriod(id);
    }

}
