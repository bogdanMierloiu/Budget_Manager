package com.example.budget.controller.rest;

import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeResponse;
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
    public List<ExpectedIncomeResponse> getAllForPeriod(@PathVariable Integer id) {
        return incomeService.getAllForPeriod(id);
    }

    @GetMapping("/amount-for-period/{id}")
    public Double amountForPeriod(@PathVariable Integer id) {
        return incomeService.calculateAmountForPeriod(id);
    }


}
