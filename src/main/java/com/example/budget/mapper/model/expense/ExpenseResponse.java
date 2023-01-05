package com.example.budget.mapper.model.expense;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.mapper.model.category.CategoryOfExpenseResponse;
import jdk.jfr.Category;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseResponse {
    private Integer id;
    private LocalDate date;
    private String spentOn;
    private Double amount;
    private CategoryOfExpenseResponse category;

}
