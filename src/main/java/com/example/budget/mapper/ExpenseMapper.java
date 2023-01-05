package com.example.budget.mapper;

import com.example.budget.entity.Expense;
import com.example.budget.mapper.model.expense.ExpenseRequest;
import com.example.budget.mapper.model.expense.ExpenseResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper

public interface ExpenseMapper {

    Expense map(ExpenseRequest request);

    ExpenseResponse map(Expense expense);

    List<ExpenseResponse> map(List<Expense> all);
}
