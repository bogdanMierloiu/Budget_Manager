package com.example.budget.mapper.model.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequest {
    @NotBlank(message = "Invalid name")
    private String spentOn;
    @Positive
    private Double amount;
    private LocalDate date;
    private Integer categoryId;

    private Integer periodId;

}
