package com.example.budget.mapper.model.expense;

import com.example.budget.entity.CategoryOfExpense;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class ExpectedExpenseRequest {
    @NotBlank(message = "Invalid name")
    private String spentOn;
    @Positive
    private Double amount;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer categoryId;
}
