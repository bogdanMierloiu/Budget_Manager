package com.example.budget.mapper.model.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequest {
    private LocalDate date;
    @NotBlank(message = "Invalid name")
    private String spentOn;
    @Positive
    private Double amount;
    private Integer categoryId;

}
