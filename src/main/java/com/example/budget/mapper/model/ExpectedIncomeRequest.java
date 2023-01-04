package com.example.budget.mapper.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ExpectedIncomeRequest {
    @NotBlank(message = "Invalid name for income source")
    private String incomeSource;

    @NotBlank(message = "No value")
    @Positive(message = "Invalid number")
    private Double amount;
}
