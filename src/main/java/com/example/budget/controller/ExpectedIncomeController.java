package com.example.budget.controller;

import com.example.budget.mapper.model.ExpectedIncomeRequest;
import com.example.budget.mapper.model.ExpectedIncomeResponse;
import com.example.budget.service.ExpectedIncomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
    public ExpectedIncomeResponse addIncome(@RequestBody ExpectedIncomeRequest income) {
        return incomeService.addIncome(income);
    }
}
