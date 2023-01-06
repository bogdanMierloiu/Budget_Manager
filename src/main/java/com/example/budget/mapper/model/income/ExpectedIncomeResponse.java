package com.example.budget.mapper.model.income;

import com.example.budget.entity.Period;
import com.example.budget.mapper.model.period.PeriodResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpectedIncomeResponse {
    private String incomeSource;
    private Double amount;
    private PeriodResponse period;
}
