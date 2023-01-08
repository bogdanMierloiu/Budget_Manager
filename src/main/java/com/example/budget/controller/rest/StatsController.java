package com.example.budget.controller.rest;

import com.example.budget.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stats")
@RequiredArgsConstructor
public class StatsController {
    private final StatsService statsService;

    @GetMapping("worth/{id}")
    public Double netWorth(@PathVariable Integer id) {
        return statsService.netWorth(id);
    }

    @GetMapping("expected-balance/{id}")
    public Double expectedBalance(@PathVariable Integer id) {
        return statsService.expectedBalance(id);
    }

    @GetMapping("income-difference/{id}")
    public Double incomeDifference(@PathVariable Integer id) {
        return statsService.incomeDifference(id);
    }

    @GetMapping("expense-difference/{id}")
    public Double expenseDifference(@PathVariable Integer id) {
        return statsService.expenseDifference(id);
    }
    @GetMapping("amount-expected-expense-category/{categoryId}/{periodId}")
    public Double amountExpectedExpenseForCategory(@PathVariable Integer categoryId, @PathVariable Integer periodId) {
        return statsService.amountExpectedExpenseForCategory(categoryId, periodId);
    }
    @GetMapping("amount-expense-category/{categoryId}/{periodId}")
    public Double amountExpenseForCategory(@PathVariable Integer categoryId, @PathVariable Integer periodId) {
        return statsService.amountExpenseForCategory(categoryId, periodId);
    }


}
