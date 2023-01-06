package com.example.budget.mapper.model.income;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeRequest {
    @NotBlank(message = "Invalid name for income source")
    private String incomeSource;

    @NotBlank(message = "No value")
    @Positive(message = "Invalid number")
    private Double amount;

    private LocalDate date;

    private Integer periodId;


}
