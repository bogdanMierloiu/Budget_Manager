package com.example.budget.mapper.model;

import lombok.Data;

@Data
public class ExpectedIncomeResponse {
    private String incomeSource;
    private Double amount;
}
