package com.example.budget.controller.rest;

import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.income.IncomeResponse;
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

    @GetMapping("/get-for-period/{id}")
    public List<IncomeResponse> getAllForPeriod(@PathVariable Integer id) {
        return incomeService.getAllForPeriod(id);
    }

    @GetMapping("/amount-for-period/{id}")
    public Double amountForPeriod(@PathVariable Integer id) {
        return incomeService.calculateAmountForPeriod(id);
    }

}
