package com.example.budget.mapper;

import com.example.budget.entity.ExpectedExpense;
import com.example.budget.mapper.model.expense.ExpectedExpenseRequest;
import com.example.budget.mapper.model.expense.ExpectedExpenseResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExpectedExpenseMapper {

    ExpectedExpense map(ExpectedExpenseRequest request);

    ExpectedExpenseResponse map(ExpectedExpense expense);

    List<ExpectedExpenseResponse> map(List<ExpectedExpense> all);
}
