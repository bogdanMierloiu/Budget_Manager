package com.example.budget.mapper;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.mapper.model.ExpectedIncomeRequest;
import com.example.budget.mapper.model.ExpectedIncomeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExpectedIncomeMapper {
    ExpectedIncome map(ExpectedIncomeRequest request);

    ExpectedIncomeResponse map(ExpectedIncome income);

    List<ExpectedIncomeResponse> map(List<ExpectedIncome> all);


}
