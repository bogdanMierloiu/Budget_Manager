package com.example.budget.mapper.model.period;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodRequest {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
