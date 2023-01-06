package com.example.budget.mapper.model.expense;

import com.example.budget.mapper.model.category.CategoryOfExpenseResponse;
import com.example.budget.mapper.model.period.PeriodResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpectedExpenseResponse {
    private Integer id;

    private String spentOn;

    private Double amount;

    private PeriodResponse period;

    private CategoryOfExpenseResponse category;
}
