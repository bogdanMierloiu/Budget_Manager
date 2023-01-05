package com.example.budget.mapper;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.mapper.model.category.CategoryOfExpenseRequest;
import com.example.budget.mapper.model.category.CategoryOfExpenseResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryOfExpenseMapper {

    CategoryOfExpense map(CategoryOfExpenseRequest request);

    CategoryOfExpenseResponse map(CategoryOfExpense categoryOfExpense);

    List<CategoryOfExpenseResponse> map(List<CategoryOfExpense> all);

}
