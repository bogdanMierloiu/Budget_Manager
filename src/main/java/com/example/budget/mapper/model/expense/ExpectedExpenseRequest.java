package com.example.budget.mapper.model.expense;

import com.example.budget.entity.Period;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ExpectedExpenseRequest {
    @NotBlank(message = "Invalid name")
    private String spentOn;
    @Positive
    private Double amount;

    private Integer periodId;

    private Integer categoryId;
}
