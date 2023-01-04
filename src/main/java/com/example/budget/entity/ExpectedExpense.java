package com.example.budget.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class ExpectedExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Invalid name")
    private String spentOn;
    @Positive
    private Double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryOfExpense category;

}
