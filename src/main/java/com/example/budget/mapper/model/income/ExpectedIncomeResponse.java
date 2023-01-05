package com.example.budget.mapper.model.income;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpectedIncomeResponse {
    private String incomeSource;
    private Double amount;

    private LocalDate startDate;

    private LocalDate endDate;
}
