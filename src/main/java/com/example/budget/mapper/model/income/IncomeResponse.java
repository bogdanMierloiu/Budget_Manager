package com.example.budget.mapper.model.income;

import com.example.budget.mapper.model.period.PeriodResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeResponse {
    private String incomeSource;
    private Double amount;

    private LocalDate date;

    private PeriodResponse period;
}
