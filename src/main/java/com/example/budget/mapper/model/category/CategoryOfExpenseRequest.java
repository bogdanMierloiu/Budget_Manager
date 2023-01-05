package com.example.budget.mapper.model.category;

import com.example.budget.entity.Expense;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryOfExpenseRequest {

    @NotBlank
    private String name;



}
