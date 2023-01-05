package com.example.budget.mapper.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodRequest {
    private LocalDate startDate;

    private LocalDate endDate;
}
