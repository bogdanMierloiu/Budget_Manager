package com.example.budget.mapper.model.income;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.entity.Period;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class ExpectedIncomeRequest {
    @NotBlank(message = "Invalid name for income source")
    private String incomeSource;

    @NotBlank(message = "No value")
    @Positive(message = "Invalid number")
    private Double amount;
    private Integer periodId;

}
