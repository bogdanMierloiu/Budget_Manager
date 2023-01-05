package com.example.budget.mapper.model.income;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeResponse {
    private String incomeSource;
    private Double amount;

    private LocalDate date;
}
