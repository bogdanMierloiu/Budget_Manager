package com.example.budget.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    @NotBlank(message = "Invalid name")
    private String spentOn;

    @Positive
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryOfExpense category;
}
