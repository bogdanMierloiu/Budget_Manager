package com.example.budget.controller;

import com.example.budget.entity.ExpectedMonthlyIncome;
import com.example.budget.service.ExpectedIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("expected")
public class ExpectedIncomeController {
    private final ExpectedIncomeService incomeService;

    @PostMapping("/addIncome")
    public ExpectedMonthlyIncome addIncome(@RequestBody ExpectedMonthlyIncome income) {
        return incomeService.addIncome(income);

    }
}
